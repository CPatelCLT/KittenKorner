/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp_db;

import java.util.ArrayList;
import java_files.Product;

/**
 *
 * @author Eric
 */
public class ProductDB {
    private ArrayList<Product> productList;
    void populateDB (){
    Product p = new Product();
        int[] pCodes = {0,1,2,3,4,5};
        String[] pNames = {"cat1","cat2","cat3","cat4","cat5","cat6"};
        String[] category = {"cute","evil"};
        String[] desc = {"Furry creature1","Furry creature2","Furry creature3","Furry creature4","Furry creature5","Furry creature6"};
        double[] dollars = {1.00,1.25, 1.50, 1.75, 2.00, 2.25};
        for (int i = 0; i< 6; i++) {
            p.setProductCode(pCodes[i]);
            p.setProductName(pNames[i]);
            if (i % 2 == 0) {
                p.setCatalogCategory(category[0]);
            }
            else { 
                p.setCatalogCategory(category[1]); 
            }
            p.setDescription(desc[i]);
            p.setPrice(dollars[i]);
            productList.add(p);
        }
    }
    public ArrayList<Product> getProdList () {
        return productList;
    }
}
