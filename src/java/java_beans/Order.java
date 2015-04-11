/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */

@Entity
public class Order implements Serializable {
    
    private int orderNumber;
    private String date;
    private int userID;
    private ArrayList<OrderItem> items;
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    public Order(){
        orderNumber = 0;
        date = null;
        userID = 0;
        items = null;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(int ON, String D, int Uid, ArrayList<OrderItem> I, double TR, boolean P) {
        orderNumber=ON;
        date=D;
        userID=Uid;
        items=I;
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
    
    public void setItems(ArrayList<OrderItem> i){
        items = i;
    }
    
    public ArrayList<OrderItem> getItems(){
        return items;
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
        double subTotal = 0.00;
        for (int i = 0; i<items.size(); i++) {
            subTotal += items.get(i).getTotal();
        }
        totalCost = subTotal + (subTotal*taxRate);
        return totalCost;
    }
    
    public void setPaid(boolean p){
        paid = p;
    }
    
    public boolean getPaid(){
        return paid;
    }
    
    
}
