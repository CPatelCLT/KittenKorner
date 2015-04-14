/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */

@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderNumber;
    private String date;
    private int userID;
    private double taxRate;
    private double totalCost;
    private boolean paid;
    @OneToMany(mappedBy="prod", fetch=FetchType.EAGER)
    private ArrayList<OrderItem> items;
    
    public Order(){
        date = null;
        userID = 0;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(String D, int Uid, double TR, boolean P) {
        date=D;
        userID=Uid;
        taxRate=TR;
        paid=P;
    }
    
    public void setOrderNumber(int on){
        orderNumber = on;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void setDate(String d){
        date = d;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setUserID(int uid){
        userID = uid;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setTaxRate(double tr){
        taxRate = tr;
    }
    
    public double getTaxRate(){
        return taxRate;
    }
    
    public void setTotalCost(double tc){
        totalCost = tc;
    }
    
    public double getTotalCost(){
        return totalCost;
    }
    
    public void setPaid(boolean p){
        paid = p;
    }
    
    public boolean getPaid(){
        return paid;
    }
    
    public ArrayList<OrderItem> getItems() {
        return items;
    }
    public void setItems (ArrayList<OrderItem> oi) {
        items = oi;
    }
    
}
