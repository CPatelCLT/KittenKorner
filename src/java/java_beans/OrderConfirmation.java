/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import javax.mail.*;
import db.OrderDB;
import db.UserDB;
import java.util.*;
import javax.activation.*;
import javax.mail.internet.*;
/**
 *
 * @author chirag
 */
public class OrderConfirmation {
    public void sendConfirmation(int ordId) {
        OrderDB odb = new OrderDB();
        UserDB udb = new UserDB();
        // TODO Add getOrder(int ordID) to OrderDB
        Order currOrder = new Order(); //odb.getOrder(ordId);
        User currUser = udb.getUser(currOrder.getUser().getUserID());
        String to = currUser.getEmailAddress();
        // TODO Change to actual email information
        String from = "kittenkorner@measurementcontrols.com";
        String host = "mail.measurementcontrols.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.user", "kittenkorner@measurementcontrols.com");
        properties.setProperty("mail.password", "vCs-G6g-FmS-rWg");
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Order Confirmation");
            message.setText("Just letting you know the order " + currOrder.getOrderNumber() + " has been recieved.\n");
            message.setText("The items in the order are:");
            double temp = 0;
            for (int i = 0; i<currOrder.getItems().size(); i++) {
                OrderItem oi = currOrder.getItems().get(i);
                message.setText(oi.getProduct().getProductName() + "     " + oi.getQuantity() + "       $" + oi.getTotal());
                temp += oi.getTotal();
            }
            message.setText("Your total is: $" + temp);
            Transport.send(message);
            System.out.println("Message Sent");
        } catch (MessagingException mex) {
            System.out.print(mex);
        }
    }
}
