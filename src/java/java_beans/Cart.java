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
public class Cart implements Serializable {

    private ArrayList<OrderItem> itemsInCart;

    public Cart() {
        //itemsInCart=null;
        itemsInCart = new ArrayList<OrderItem>();
    }

    public void setItems(ArrayList<OrderItem> i) {
        itemsInCart = i;
    }

    public ArrayList<OrderItem> getItems() {
        return itemsInCart;
    }

    public void addItem(Product p, int q) {
        OrderItem o = new OrderItem(p, q, 0);
        boolean check=true;
        for (OrderItem item : itemsInCart) {
            if (item.getProduct()==p) {
                item.setQuantity(item.getQuantity() + 1);
                check=false;
            }
        }
        if(check){
            this.itemsInCart.add(o);
        }

    }
    public void addItem(OrderItem oi) {
        boolean check=true;
        for (int i = 0; i<itemsInCart.size(); i++) {
            if (itemsInCart.get(i).getProduct().getProductCode().equals(oi.getProduct().getProductCode())) {
                itemsInCart.get(i).setQuantity(itemsInCart.get(i).getQuantity()+1);
                check=false;
            }
        }
        if (check) {
            this.itemsInCart.add(oi);
        }
    }

    public boolean checkIfInCart(Product oi) {
        for (OrderItem item : itemsInCart) {

        }
        return false;
    }

    public void removeItem(Product p) {
        for (int i = 0; i < itemsInCart.size(); i++) {
            if (itemsInCart.get(i).getProduct().equals(p)){
                itemsInCart.remove(i);
            }
        }
    }

    public void emptyCart() {
        this.itemsInCart.clear();
    }

}
