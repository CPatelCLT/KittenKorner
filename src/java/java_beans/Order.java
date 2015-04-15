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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderNumber")
    private Integer orderNumber;
    
    @Column(name = "oDate")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JoinColumn(name="ouser", referencedColumnName="userID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy="order")
    private ArrayList<OrderItem> items;
    
    public Order(){
//        date = null;
//        user = null;
//        taxRate = 0.0;
//        totalCost = 0;
//        paid = false;
    }
    
    public Order(Date D, User usr, double TR, boolean P) {
        date=D;
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
        date = d;
    }
    
    public Date getDate(){
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
    
    public ArrayList<OrderItem> getItems() {
        return items;
    }
    public void setItems (ArrayList<OrderItem> oi) {
        items = oi;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNumber != null ? orderNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderNumber == null && other.orderNumber != null) || (this.orderNumber != null && !this.orderNumber.equals(other.orderNumber))) {
            return false;
        }
        return true;
    }
}
