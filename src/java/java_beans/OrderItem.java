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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderNumber;
    
    @OneToOne
    private Product product;
    
    private int quantity=1;
    
    
    
    
    
    
    
//    @EmbeddedId
//    protected OrderItemPK oiPK;
//    
//    @JoinColumn(name="orderNumber", referencedColumnName="orderNumber", insertable=false, updatable=false)
//    @ManyToOne(optional = false, fetch=FetchType.LAZY)
//    private Order order;
//    
//    private int quantity;
//    
////    @OneToOne//(cascade=CascadeType.REFRESH)
//    @JoinColumn(name="productCode", referencedColumnName="productCode", insertable=false, updatable=false)
//    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//    private Product product;
    
    public OrderItem(){
//        product=null;
//        quantity=0;
//        order = null;
    }
    
//    public OrderItem(Product P, int Q, int OID){
//        product=P;
//        quantity=Q;
//        orderItemId = OID;
//    }
    
//    public OrderItemPK getOiPK() {
//        return oiPK;
//    }
//    public void setOiPK(OrderItemPK oipk) {
//        oiPK = oipk;
//    }
    
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
    
//    public void setOrder(int OID) {
//        orderNumber = OID;
//    }
//    public int getOrder() {
//        return orderNumber;
//    }
    
    public void setOrderNumber(int ON){
        ON=orderNumber;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
}