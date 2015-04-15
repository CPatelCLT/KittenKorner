/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.List;
import java_beans.Product;
import javax.persistence.*;

/**
 * @author : Eric Knowles
 * @author : Chirag Patel
 */
public class ProductDB {

    public ProductDB() {
        //setupDB();
    }
    public void setupDB() {
        int[] pCodes = {0, 1, 2, 3, 4, 5};
        String[] pNames = {"cat1", "cat2", "cat3", "cat4", "cat5", "cat6"};
        String[] category = {"cute", "evil"};
        String[] desc = {"Furry creature1", "Furry creature2", "Furry creature3", "Furry creature4", "Furry creature5", "Furry creature6"};
        double[] dollars = {1.00, 1.25, 1.50, 1.75, 2.00, 2.25};
        for (int i = 0; i < 6; i++) {
            Product p = new Product();
            p.setProductCode(pCodes[i]);
            p.setProductName(pNames[i]);
            if (i % 2 == 0) {
                p.setCatalogCategory(category[0]);
            } else {
                p.setCatalogCategory(category[1]);
            }
            p.setDescription(desc[i]);
            p.setPrice(dollars[i]);
            p.setImageUrl("pictures/pic"+pCodes[i]+".jpg");
            addProduct(p);
        }
    }
    public ArrayList<Product> getAllProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        List<Product> p;
        try {
            p = q.getResultList();
            if (p == null || p.isEmpty()) {
                return null;
            }
        } finally {
            em.close();

        }
        ArrayList<Product> pNew = new ArrayList<Product>(p.size());
        pNew.addAll(p);
        return pNew;
    }

    // Gets product using the product code
    public Product getProduct(int pCode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p " + "WHERE p.productCode = :pCode";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        q.setParameter("pCode", pCode);
        Product p = null;
        try {
            p = q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return p;
    }

    /* get products by category
     public ArrayList<Product> getProducts(String prodCat) {
     ArrayList<Product> tmp = new ArrayList<Product>();
     if (prodCat.equals("all")) {
     return productList;
     }
     for (int i = 0; i < productList.size(); i++) {
     if (productList.get(i).getCatalogCategory().equals(prodCat)) {
     tmp.add(productList.get(i));
     }
     }
     return tmp;
     } */
    public void addProduct(Product prod) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(prod);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void addProduct(int productCode, String productName, String catalogCategory, double price, String description, String imageUrl) {
        Product prod = new Product(productCode, productName, catalogCategory, description, price, imageUrl);
        addProduct(prod);
    }
}
