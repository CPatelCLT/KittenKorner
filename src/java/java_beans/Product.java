/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
@Entity
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productCode;
    private String productName;
    private String catalogCategory;
    private String description;
    private double price;
    private String imageUrl;
    
    //@OneToOne
//    private OrderItem orderItem;
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="product")
//    public List<OrderItem> orderItem;
    
    public Product() {
        
    }
    public Product(int PC, String PN, String CC, String D, double P, String iU) {
      productCode = PC;
      productName = PN;
      catalogCategory = CC;
      description = D;
      price = P;  
      imageUrl = iU;
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
        return imageUrl;
        //return ("pictures/pic"+productCode+".jpg");
    }
    public void setImageUrl(String iU) {
        imageUrl = iU;
    }
    
//    @XmlTransient
//    public OrderItem orderItem(){
//        return orderItem;
//    }
//    
//    public void setOrderItem(OrderItem OI){
//        orderItem = OI;
//    }
}
