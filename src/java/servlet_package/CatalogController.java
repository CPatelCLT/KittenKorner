/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import db.ProductDB;
import java_beans.Product;
import java_beans.Cart;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author : Eric Knowles
 * @author : Chirag Patel
 */
public class CatalogController extends HttpServlet {

    ProductDB pdb = new ProductDB();
    ArrayList<Product> sortedItems = new ArrayList();
    ArrayList<Product> items = new ArrayList();
    Cart crt = new Cart();
    String requestedProduct, buttonClicked, sort;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        requestedProduct = request.getParameter("productCode");
        request.getSession().setAttribute("items", items);
        if (requestedProduct == null) { //load catalog page
            RequestDispatcher dispatch = request.getRequestDispatcher("/catalog.jsp");
            dispatch.forward(request, response);
        } else if (buttonClicked.equals("backToCatalog")) {
            RequestDispatcher dispatch = request.getRequestDispatcher("/catalog.jsp");
            dispatch.forward(request, response);
        } else { //find which item and load item page
            //request.setAttribute("alert", "I got here");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        buttonClicked = request.getParameter("action");
        sort = request.getParameter("categorySelect");
        request.getSession().setAttribute("curCategory", sort);
        if (sort != null) {
            items = getSortedProducts(sort);
        } else {
            items = pdb.getAllProducts();
        }
        if (buttonClicked != null) {
            if (buttonClicked.equals("itemInfoButton")) {
                requestedProduct = request.getParameter("productCode");
                Product p = pdb.getProduct(Integer.parseInt(requestedProduct));
                request.setAttribute("item", p);
                RequestDispatcher dispatch = request.getRequestDispatcher("/item.jsp");
                dispatch.forward(request, response);
            } else if (buttonClicked.equals("backToCatalog")) {
                RequestDispatcher dispatch = request.getRequestDispatcher("/catalog.jsp");
                dispatch.forward(request, response);
            } else {
                doPost(request, response);
            }

        } else {
            doPost(request, response);
        }

    }
    public ArrayList<Product> getSortedProducts(String prodCat) {
     ArrayList<Product> tmp = new ArrayList<Product>();
     items = pdb.getAllProducts();
     if (prodCat.equals("all")) {
     return items;
     }
     for (int i = 0; i < items.size(); i++) {
     if (items.get(i).getCatalogCategory().equals(prodCat)) {
     tmp.add(items.get(i));
     }
     }
     return tmp;
     }
}
