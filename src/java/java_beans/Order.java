/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    @ManyToOne
    private User user;
    
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<OrderItem> items;
    
    public Order(){
        date = null;
        user = null;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(String D, User usr, double TR, boolean P) {
        date=D;
        user=usr;
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
    
    public void setUser(User usr){
        user = usr;
    }
    
    public User getUser(){
        return user;
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
    
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems (List<OrderItem> oi) {
        items = oi;
    }
    
}
