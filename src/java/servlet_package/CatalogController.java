/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import java_files.*;
import temp_db.*;

/**
 * @author : Eric Knowles
 * @author : Chirag Patel
 */
public class CatalogController extends HttpServlet {

    ProductDB pdb = new ProductDB();
    ArrayList<Product> unSortedItems = pdb.getProdList();
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
            items = pdb.getProducts(sort);
        } else {
            items = pdb.getProdList();
        }
        if (buttonClicked != null) {
            if (buttonClicked.equals("itemInfoButton")) {
                requestedProduct = request.getParameter("productCode");
                Product p = pdb.getProduct(requestedProduct);
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
}
