/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 *
 * @author chirag
 */
@Embeddable
public class OrderItemPK implements Serializable {
    @Basic(optional = false)
    private int orderNumber;
    @Basic(optional = false)
    private int productCode;
    
    public OrderItemPK() {
    }
    
    public OrderItemPK(int ordNum, int prodCode) {
        orderNumber = ordNum;
        productCode = prodCode;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int ordNum) {
        orderNumber=ordNum;
    }
    
    public int getProductCode() {
        return productCode;
    }
    public void setProductCode(int prodCode) {
        productCode = prodCode;
    }
}