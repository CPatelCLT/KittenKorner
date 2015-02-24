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
    
    private ArrayList<OrderItem> items;
    
    public Cart(){
        items=null;
    }
    
    public void setItems(ArrayList<OrderItem> i){
        items=i;
    }
    
    public ArrayList<OrderItem> getItems(){
        return items;
    }
    
    public void addItem(Product p, int q){
        this.items.add(new OrderItem(p,q));
    }
    
    public void removeItem(Product p){
        for(OrderItem item : items){
            if(item.getProduct().equals(p)){
                items.remove(item);
            }
        }
    }
    
    public void emptyCart(){
        this.items.clear();
    }
    
}
