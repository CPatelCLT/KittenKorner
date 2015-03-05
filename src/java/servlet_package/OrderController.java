/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        if (buttonClicked!=null&&buttonClicked.equals("addToCartButton")) {
            pcode = request.getParameter("productCode");
            //pcode="1";//for testing
            if (pcode != null) {
                if (request.getSession().getAttribute("theShoppingCart") != null) {
                    //request.setAttribute("alert", pcode+"if ran");
                    c = (Cart) request.getSession().getAttribute("theShoppingCart");
                    c.addItem(pdb.getProduct(pcode), 1);
                    request.getSession().setAttribute("theShoppingCart", c);
                    RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");
                    dispatch.forward(request, response);
                } else {
                    //request.setAttribute("alert", pcode+"else ran");
                    Product p = pdb.getProduct(pcode);
                    if (p != null) {
                        c = new Cart();
                        c.addItem(p, 1);
                        request.getSession().setAttribute("theShoppingCart", c);
                    } else {
                        //request.setAttribute("alert", "p is null");
                    }
                }
            }
            RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");//change to cart
            dispatch.forward(request, response);
        } else if (buttonClicked!=null&&buttonClicked.equals("updateCart")) {
            c = (Cart) request.getSession().getAttribute("theShoppingCart");
            
            for (int i = 0; i < c.getItems().size(); i++) {
                OrderItem currItem = c.getItems().get(i);
                int newQty = Integer.parseInt(request.getParameter(currItem.getProduct().getProductCode()+""));
                if (newQty < 0) {
                    //Invalid quantity gets reverted to previous value
                    newQty = currItem.getQuantity();
                } else if (newQty == 0) {
                    //Zero value deletes the item
                    c.removeItem(currItem.getProduct());
                } else {
                    //Quantity gets updated
                    currItem.setQuantity(newQty);
                }
            }
            
            /* Obsolete again, doesnt meet requirements
            String[] newQty = request.getParameterValues("quantity"); 
            String[] prodCode = request.getParameterValues("prodCode");
            for (int i = 0; i<newQty.length; i++) {
                if (Integer.parseInt(newQty[i]) < 0) {
                newQty[i] = 1+"";
            }
            for (int j = 0; j < c.getItems().size(); j++) {
                OrderItem currItem = c.getItems().get(i);
                if (currItem.getProduct().getProductCode() == Integer.parseInt(prodCode[i])) {
                    currItem.setQuantity(Integer.parseInt(newQty[i]));
                }
            }
            } */
            
            /* Obsolete, doesnt work on all items in cart
            int newQty = Integer.parseInt(request.getParameter("quantity"));
            int prodCode = Integer.parseInt(request.getParameter("prodCode"));
            if (newQty < 0) {
                newQty = 1;
            }
            for (int i = 0; i < c.getItems().size(); i++) {
                OrderItem currItem = c.getItems().get(i);
                if (currItem.getProduct().getProductCode() == prodCode) {
                    currItem.setQuantity(newQty);
                }
            }*/
            request.getSession().setAttribute("theShoppingCart", c);
            RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");
            dispatch.forward(request, response);
        } else {
            if (request.getSession().getAttribute("theShoppingCart") != null) {
                //request.setAttribute("alert", pcode+"if ran");
                c = (Cart) request.getSession().getAttribute("theShoppingCart");
                request.getSession().setAttribute("currentOrder", convertToOrder(c));
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            } else { //nothing in cart
                c = new Cart();
                request.getSession().setAttribute("currentOrder", convertToOrder(c));
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public Order convertToOrder(Cart c){
        Order ord = new Order();
        UserDB udb = new UserDB();
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance();
        ord.setUser(udb.getUser("john.doe@gmail.com"));
        ord.setDate(df.format(date));
        ord.setOrderNumber(0);
        ord.setPaid(false);
        ord.setTaxRate(0.075);
        ord.setItems(c.getItems());
        return ord;
    }
}
