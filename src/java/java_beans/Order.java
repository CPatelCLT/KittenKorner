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
public class Order implements Serializable {
    
    private int orderNumber;
    private String date;
    private User user;
    private ArrayList<OrderItem> items;
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    public Order(){
        orderNumber = 0;
        date = null;
        user = null;
        items = null;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(int ON, String D, User U, ArrayList<OrderItem> I, double TR, boolean P) {
        orderNumber=ON;
        date=D;
        user=U;
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
    
    public void setUser(User u){
        user = u;
    }
    
    public User getUser(){
        return user;
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
