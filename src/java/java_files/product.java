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
public class product implements Serializable {
    
    private int productCode;
    private String productName;
    private String catalogCategory;
    private String description;
    private double price;
    
    public product(){
        
    }
}
