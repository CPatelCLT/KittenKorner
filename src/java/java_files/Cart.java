/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_files;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eric
 */
public class Cart implements Serializable {
    
    private ArrayList<OrderItem> itemsInCart = new ArrayList();
    
    public Cart(){
        itemsInCart=null;
    }
    
    public void setItems(ArrayList<OrderItem> i){
        itemsInCart=i;
    }
    
    public ArrayList<OrderItem> getItems(){
        return itemsInCart;
    }
    
    public void addItem(Product p, int q){
        //this.itemsInCart.add(new OrderItem(p,q)); //commented to break down to find source of nullpointer
        OrderItem o = new OrderItem(p,q);
        //OrderItem o = new OrderItem(); //Only for testing
        this.itemsInCart.add(o); //null pointer exception here when adding
    }
    
    public void removeItem(Product p){
        for(OrderItem item : itemsInCart){
            if(item.getProduct().equals(p)){
                itemsInCart.remove(item);
            }
        }
    }
    
    public void emptyCart(){
        this.itemsInCart.clear();
    }
    
}
