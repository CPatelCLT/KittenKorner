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
 * @author    : Eric Knowles
 * @author    : Chirag Patel
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
        buttonClicked = request.getParameter("action");

        if (buttonClicked!=null&&buttonClicked.equals("addToCartButton")) {
            pcode = request.getParameter("productCode");
            if (pcode != null) {
                if (request.getSession().getAttribute("theShoppingCart") != null) {
                    c = (Cart) request.getSession().getAttribute("theShoppingCart");
                    c.addItem(pdb.getProduct(pcode), 1);
                    request.getSession().setAttribute("theShoppingCart", c);
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
            request.getSession().setAttribute("theShoppingCart", c);
            RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");
            dispatch.forward(request, response);
        } else if(buttonClicked!=null&&buttonClicked.equals("checkout")){
            if (request.getSession().getAttribute("theShoppingCart") != null) {
                c = (Cart) request.getSession().getAttribute("theShoppingCart");
                request.getSession().setAttribute("theShoppingCart", null);
                UserDB udb = new UserDB();
                User usr = udb.getUser("john.doe@gmail.com");
                request.getSession().setAttribute("theUser", usr);
                request.getSession().setAttribute("currentOrder", convertToOrder(c, usr));
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            } else { //nothing in cart
                request.getSession().setAttribute("currentOrder", null);
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            }
        } else {
            if(request.getSession().getAttribute("currentOrder")!=null){
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);                
            }else{
                request.getSession().setAttribute("currentOrder", null);
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            }
            
            /*if (request.getSession().getAttribute("theShoppingCart") != null) {
                c = (Cart) request.getSession().getAttribute("theShoppingCart");
                UserDB udb = new UserDB();
                User usr = udb.getUser("john.doe@gmail.com");
                request.getSession().setAttribute("theUser", usr);
                request.getSession().setAttribute("currentOrder", convertToOrder(c, usr));
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            } else { //nothing in cart
                request.getSession().setAttribute("currentOrder", null);
                RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
                dispatch.forward(request, response);
            }*/
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public Order convertToOrder(Cart c, User usr){
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance();
        Order ord = new Order(0, df.format(date), usr, c.getItems(), 0.075, false);
        return ord;
    }
}
