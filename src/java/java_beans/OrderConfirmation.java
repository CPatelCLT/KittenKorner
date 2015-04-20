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
    
    UserDB udb;
    String to;
    public OrderConfirmation(){
        
    }
    
    public void sendConfirmation(Order ord) {
        udb = new UserDB();
        Order currOrder = ord;
        User currUser = ord.getUser();
        if(currUser!=null){
            to = currUser.getEmailAddress();
            //System.out.println("Email address = "+to);
        }
        else{
            //System.out.println("no current order");
            return;
        }
        String from = "kittenkorner@measurementcontrols.com";
        String host = "mail.measurementcontrols.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getInstance(properties,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(
                  "kittenkorner@measurementcontrols.com", "vCs-G6g-FmS-rWg");
            }
         });
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
            message.setText("Your total is: $" + temp + "\n\n");
            
            message.setText("Your cat will be sent to: \n"+currUser.getFirstName()+" "+currUser.getLastName()+"\n"+currUser.getAddress1()+"\n"+currUser.getAddress2()+"\n"+currUser.getCity()+", "+currUser.getState()+" "+currUser.getPostCode());
            Transport.send(message);
            System.out.println("Message Sent");
        } catch (MessagingException mex) {
            System.out.print(mex);
        }
    }
}
