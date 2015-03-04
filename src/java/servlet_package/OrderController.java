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
 *
 * @author Eric
 */
public class OrderController extends HttpServlet {
    String buttonClicked, pcode;
    ProductDB pdb = new ProductDB();
    ArrayList<Product> allItems = pdb.getProdList();
    Cart c;
    Order o;
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        buttonClicked = request.getParameter("buttonClicked");
        
        
        if (buttonClicked.equals("addToCartButton")) {
            pcode=request.getParameter("productCode");
            //pcode="1";//for testing
            if(pcode!=null){
                if(request.getSession().getAttribute("cart")!=null){
                    //request.setAttribute("alert", pcode+"if ran");
                    c = (Cart) request.getSession().getAttribute("cart");
                    c.addItem(pdb.getProduct(pcode),1);
                    request.getSession().setAttribute("cart", c);
                    RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");
                    dispatch.forward(request, response);
                }
                else{
                    //request.setAttribute("alert", pcode+"else ran");
                    Product p = pdb.getProduct(pcode);
                    if(p!=null){
                        c = new Cart();
                        c.addItem(p,1); 
                        request.getSession().setAttribute("cart", c);
                    }
                    else{
                        //request.setAttribute("alert", "p is null");
                    }
                }
            }
            RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");//change to cart
            dispatch.forward(request, response);
        } else if (buttonClicked.equals("updateCart")) {
                c = (Cart) request.getSession().getAttribute("cart");
                int newQty = Integer.parseInt(request.getParameter("quantity"));
                int prodCode = Integer.parseInt(request.getParameter("prodCode"));
                if (newQty < 0) {
                    newQty = 1;
                }
                for(int i=0; i<c.getItems().size(); i++) {
                    OrderItem currItem = c.getItems().get(i);
                    if (currItem.getProduct().getProductCode() == prodCode) {
                        currItem.setQuantity(newQty);
                    }
                }
                request.getSession().setAttribute("cart", c);
                RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");
                dispatch.forward(request, response);
            }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("id").equals("o")){ //order page
            
            if(request.getSession().getAttribute("cart")!=null){
                    //request.setAttribute("alert", pcode+"if ran");
                    Cart ca = (Cart) request.getSession().getAttribute("cart");
                    request.getSession().setAttribute("orderItems", ca);
                    RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                    dispatch.forward(request, response);
            }
            
            else{ //nothing in cart
                Cart ca = new Cart(); 
                request.getSession().setAttribute("orderItems", ca);
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            }
        }
    }
    
}

