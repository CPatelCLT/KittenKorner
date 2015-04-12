/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
@Entity
public class OrderItem implements Serializable {
    @Id
    private int orderNum;
    private int productCode;
    private int quantity;
    @Transient
    private double total;
    
    public OrderItem(){
        productCode=0;
        quantity=0;
        orderNum = 0;
    }
    
    public OrderItem(int P, int Q, int onum){
        productCode=P;
        quantity=Q;
        orderNum = onum;
    }
    
    public void setProduct(int p){
        productCode=p;
    }
    
    public int getProduct(){
        return productCode;
    }
    
    public void setQuantity(int q){
        quantity=q;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getTotal(){
        return total;
    }
    public void setTotal(double tot) {
        total = tot;
    }
    
    public void setOrderNum(int onum) {
        orderNum = onum;
    }
    public int getOrderNum () {
        return orderNum;
    }
    
}
