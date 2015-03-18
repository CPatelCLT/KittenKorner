/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
@Entity
public class Product implements Serializable {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String productCode;
    private String productName;
    private String catalogCategory;
    private String description;
    private double price;
    private String imageUrl;
    
    public Product() {
        
    }
    public Product(String PC, String PN, String CC, String D, double P, String iU) {
      productCode = PC;
      productName = PN;
      catalogCategory = CC;
      description = D;
      price = P;  
      imageUrl = iU;
    }
    
    public void setProductCode(String pc){
        productCode = pc;
    }
    
    public String getProductCode(){
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
        return imageUrl;
        //return ("pictures/pic"+productCode+".jpg");
    }
    public void setImageUrl(String iU) {
        imageUrl = iU;
    }
}
