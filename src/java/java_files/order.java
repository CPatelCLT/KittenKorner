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
}
