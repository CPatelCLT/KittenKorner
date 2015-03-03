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
    ProductDB PDB = new ProductDB();
    ArrayList<Product> allItems = PDB.getProdList();
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        buttonClicked = request.getParameter("buttonClicked");
        
        
        if (buttonClicked.equals("addToCartButton")) {
            pcode=request.getParameter("productCode");
            pcode="1";//for testing
            if(pcode!=null){
                if(request.getAttribute("cart")!=null){
                    //request.setAttribute("alert", pcode+"if ran");
                    Cart c = (Cart) request.getSession().getAttribute("cart");
                    c.addItem(PDB.getProduct(pcode),1);
                    request.getSession().setAttribute("cart", c);
                }
                else{
                    //request.setAttribute("alert", pcode+"else ran");
                    Product p = PDB.getProduct(pcode);
                    if(p!=null){
                        Cart cart = new Cart();
                        cart.addItem(p,1); 
                        request.getSession().setAttribute("cart", cart);
                    }
                    else{
                        //request.setAttribute("alert", "p is null");
                    }
                }
                
            }
            RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");//change to cart
            dispatch.forward(request, response);
        }
    }
    
}
