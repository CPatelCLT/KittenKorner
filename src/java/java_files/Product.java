/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_files;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Product implements Serializable {
    
    private int productCode;
    private String productName;
    private String catalogCategory;
    private String description;
    private double price;
    private String imageUrl;
    
    public Product(){
        productCode = 0;
        productName = null;
        catalogCategory = null;
        description = null;
        price = 0.00;
    }
    
    public Product(int PC, String PN, String CC, String D, double P) {
      productCode = PC;
      productName = PN;
      catalogCategory = CC;
      description = D;
      price = P;      
    }
    
    public void setProductCode(int pc){
        productCode = pc;
    }
    
    public int getProductCode(){
        return productCode;
    }
    
    public void setProductName(String pn){
        productName = pn;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void setCatalogCategory(String cc){
        catalogCategory = cc;
    }
    
    public String getCatalogCategory(){
        return catalogCategory;
    }
    
    public void setDescription(String d){
        description = d;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setPrice(double p){
        price = p;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getImageUrl(){
        imageUrl = "pictures/pic"+productCode+".jpg";
        return imageUrl;
    }
}
