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
public class order implements Serializable {
    
    private int orderNumber;
    private String date;
    private String user;
    private ArrayList<orderitem> items;
    private double taxRate;
    private double totalCost;
    private boolean paid;
    
    public order(){
        
    }
    
    public void setOrderNumber(int on){
        
    }
    
    public int getOrderNumber(){
        
        return orderNumber;
    }
    
    public void setDate(String d){
        
    }
    
    public String getDate(){
        
        return date;
    }
    
    public void setUser(String u){
        
    }
    
    public String getUser(){
        
        return user;
    }
    
    public void setItems(String i){
        
    }
    
    public ArrayList<orderitem> getItems(){
        
        return items;
    }
    
    public void setTaxRate(double tr){
        
    }
    
    public double getTaxRate(){
        
        return taxRate;
    }
    
    public void setTotalCost(double tc){
        
    }
    
    public double getTotalCost(){
        
        return totalCost;
    }
    
    public void setPaid(boolean p){
        
    }
    
    public boolean getPaid(){
        
        return paid;
    }
    
    
}
