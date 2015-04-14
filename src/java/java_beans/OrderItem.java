/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
@Entity
public class OrderItem implements Serializable {
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    private int orderNumber;
    private int quantity;
    private double total;
    
    @OneToOne
    private Product product;
    
    public OrderItem(){
        product=null;
        quantity=0;
        orderNumber = 0;
        total=0;
    }
    
    public OrderItem(Product P, int Q, int onum){
        product=P;
        quantity=Q;
        orderNumber = onum;
    }
    
    public void setProduct(Product p){
        product=p;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public void setQuantity(int q){
        quantity=q;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getTotal(){
        return product.getPrice()*quantity;
    }
    public void setTotal(double tot) {
        total = tot;
    }
    
    public void setOrderNum(int onum) {
        orderNumber = onum;
    }
    public int getOrderNum () {
        return orderNumber;
    }
    
}
