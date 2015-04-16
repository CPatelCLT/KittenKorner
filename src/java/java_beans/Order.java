/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderNumber")
    private Integer orderNumber;
    
    @Column(name = "oDate")
    @Temporal(TemporalType.DATE)
    private Date date;
    
//    @JoinColumn(name="userID", referencedColumnName="userID", insertable=false, updatable=false)
    @JoinColumn(name="userID", referencedColumnName="userID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userID;
    
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy="order")
    private ArrayList<OrderItem> items;
    
    public Order(){
        date = null;
        userID = null;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(Integer ON){
        orderNumber= ON;
    }
    
    public Order(Date D, User usr, double TR, boolean P) {
        date=D;
        userID=usr;
        taxRate=TR;
        paid=P;
    }
    
    public void setOrderNumber(Integer on){
        orderNumber = on;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void setDate(Date d){
        date = d;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setUser(User usr){
        userID = usr;
    }
    
    public User getUserID(){
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