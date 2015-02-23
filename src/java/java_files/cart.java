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
public class cart implements Serializable {
    
    private ArrayList<orderitem> items;
    
    public cart(){
        
    }
    
    public void setItems(ArrayList<orderitem> i){
    
    }
    
    public ArrayList<orderitem> getItems(){
        
        return items;
    }
    
}
