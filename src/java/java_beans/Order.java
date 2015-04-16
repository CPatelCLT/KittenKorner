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
import static javax.persistence.FetchType.EAGER;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @ManyToOne
    private User user;
    
    @OneToMany(fetch=EAGER, cascade=CascadeType.PERSIST)
    private ArrayList<OrderItem> orderItem;
    
    @Temporal(TemporalType.DATE)
    private Date oDate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderNumber;
    
    private boolean paid;
    private double taxRate;
    private double totalCost;



//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "orderNumber")
//    private Integer orderNumber;
//    
//    @Column(name = "oDate")
//    @Temporal(TemporalType.DATE)
//    private Date date;
//    
////    @JoinColumn(name="userID", referencedColumnName="userID", insertable=false, updatable=false)
//    @JoinColumn(name="userID", referencedColumnName="userID")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private User userID;
//    
//    private double taxRate;
//    private double totalCost;
//    private boolean paid;
//    
//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy="order")
//    private ArrayList<OrderItem> items;
    
    public Order(){
        oDate = null;
        user = null;
        taxRate = 0.0;
        totalCost = 0;
        paid = false;
    }
    
    public Order(Integer ON){
        orderNumber= ON;
    }
    
    public Order(Date D, User usr, double TR, boolean P) {
        oDate=D;
        user=usr;
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
        oDate = d;
    }
    
    public Date getDate(){
        return oDate;
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
    
    public ArrayList<OrderItem> getItems() {
        return orderItem;
    }
    public void setItems (ArrayList<OrderItem> oi) {
        orderItem = oi;
    }
    
}