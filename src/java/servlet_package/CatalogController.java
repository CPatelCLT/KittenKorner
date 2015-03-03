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
/*import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;*/

/**
 *
 * looks at url,
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
        requestedProduct = request.getParameter("productCode"); //getting the value (from the url or post) that the user submits
        
        //request.setAttribute("alert", "I got here");
        request.getSession().setAttribute("items", items); //must use this to set the attribute for el to be able to use it
        //request.getSession().setAttribute("itemList", items);
        if (requestedProduct == null) { //load catalog page
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

        buttonClicked = request.getParameter("buttonClicked");
        sort = request.getParameter("categorySelect");
        request.setAttribute("curCategory", sort);
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
            } else {
                doPost(request, response);
            }
            //request.setAttribute("items", items);

        } else {
            doPost(request, response);
        }

    }
}
