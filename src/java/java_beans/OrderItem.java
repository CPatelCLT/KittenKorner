/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
public class OrderItem implements Serializable {
    
    private Product product;
    private int quantity;
    
    public OrderItem(){
        product=null;
        quantity=0;
    }
    
    public OrderItem(Product P, int Q){
        product=P;
        quantity=Q;
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
    
}
