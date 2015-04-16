/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import db.UserDB;
import db.ProductDB;
import java_beans.Order;
import java_beans.Product;
import java_beans.Cart;
import java_beans.OrderItem;
import java_beans.User;
import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import db.OrderDB;

/**
 * @author : Eric Knowles
 * @author : Chirag Patel
 */
public class OrderController extends HttpServlet {

    String buttonClicked, pcode;
    ProductDB pdb = new ProductDB();
    OrderDB odb = new OrderDB();
    ArrayList<Product> allItems = pdb.getAllProducts();
    Cart c;
    Order o;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        buttonClicked = request.getParameter("action");
        if (buttonClicked != null) {
            if (buttonClicked.equals("addToCartButton")) {
                pcode = request.getParameter("productCode");
                if (pcode != null) {
                    if (request.getSession().getAttribute("theShoppingCart") != null) {
                        //Add another item to cart
                        c = (Cart) request.getSession().getAttribute("theShoppingCart");
                        Product p = pdb.getProduct(Integer.parseInt(pcode));
                        OrderItem oi = new OrderItem();
                        oi.setProduct(p);
                        c.addItem(oi);
                        request.getSession().setAttribute("theShoppingCart", c);
                    } else {
                        //Add first item to cart
                        Product p = pdb.getProduct(Integer.parseInt(pcode));
                        OrderItem oi = new OrderItem();
                        oi.setProduct(p);
                        if (p != null) {
                            c = new Cart();
                            c.addItem(oi);
                            request.getSession().setAttribute("theShoppingCart", c);
                        } else {
                            //request.setAttribute("alert", "p is null");
                        }
                    }
                }
                RequestDispatcher dispatch = request.getRequestDispatcher("/cart.jsp");//change to cart
                dispatch.forward(request, response);
            } else if (buttonClicked.equals("updateCart")) {
                c = (Cart) request.getSession().getAttribute("theShoppingCart");
                
                for (int i = 0; i < c.getItems().size(); i++) {
                    OrderItem currItem = c.getItems().get(i);
                    int newQty = Integer.parseInt(request.getParameter(currItem.getProduct().getProductCode() + ""));
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
            } else if (buttonClicked.equals("checkout")) {
                c = (Cart) request.getSession().getAttribute("theShoppingCart");
                request.getSession().setAttribute("theShoppingCart", c);
                
                if (request.getSession().getAttribute("theUser") != null) {
                    User currUser = (User) request.getSession().getAttribute("theUser");
                    Order thisOrder = convertToOrder(c, currUser);
                    request.getSession().setAttribute("thisOrder", thisOrder);
                    RequestDispatcher dispatch = request.getRequestDispatcher("/secure/payment.jsp");
                    dispatch.forward(request,response);
                } else {
                    RequestDispatcher dispatch = request.getRequestDispatcher("/checkoutChoice.jsp");
                    dispatch.forward(request,response);
                }
//                if (request.getSession().getAttribute("theShoppingCart") != null) {
//                    c = (Cart) request.getSession().getAttribute("theShoppingCart");
//                    request.getSession().setAttribute("theShoppingCart", null);
//                    UserDB udb = new UserDB();
//                    User usr = udb.getUser("302");
//                    request.getSession().setAttribute("theUser", usr);
//                    request.getSession().setAttribute("currentOrder", convertToOrder(c, usr));
//                    RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
//                    dispatch.forward(request, response);
//                } else { //nothing in cart
//                    request.getSession().setAttribute("currentOrder", null);
//                    RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
//                    dispatch.forward(request, response);
//                }
//            } else if (buttonClicked.equals("makePayment")) {
//                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/payment.jsp");
//                dispatch.forward(request, response);
//            } 
            }  else if (buttonClicked.equals("confirmOrder")) {
                Order thisOrder = (Order) request.getSession().getAttribute("thisOrder");
                odb.addOrder(thisOrder);
                thisOrder = odb.getLastOrder(thisOrder.getUser());
                request.getSession().removeAttribute("thisOrder");
                request.getSession().setAttribute("currentOrder", thisOrder);
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
                dispatch.forward(request, response);
            }
        } else {
            if (request.getSession().getAttribute("currentOrder") != null) {
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
                dispatch.forward(request, response);
            } else {
                request.getSession().setAttribute("currentOrder", null);
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
                dispatch.forward(request, response);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        buttonClicked = request.getParameter("action");
        if (buttonClicked.equals("ordnum")){
            if (request.getParameter("num")!=null){
                String orderNumber = request.getParameter("num");
                request.getSession().setAttribute("currentOrder", odb.getOrderByNum(Integer.parseInt(orderNumber)));
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orders.jsp");
                dispatch.forward(request, response);
            }
        }
        else if(buttonClicked.equals("viewOrders")){
            User u = (User) request.getSession().getAttribute("theUser");
//            UserDB udb = new UserDB();
//            String usr = request.getUserPrincipal().getName();
//            User u = udb.getUserByEmail(usr);
            if (u==null){
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/signedin.jsp");
                dispatch.forward(request, response);
            }
            else{
//                User u = udb.getUserByEmail(usr);
                //request.getSession().setAttribute("theUser", u);
                request.getSession().setAttribute("userOrders", odb.getOrders(u));
                RequestDispatcher dispatch = request.getRequestDispatcher("/secure/orderlist.jsp");
                dispatch.forward(request, response);
            }
        }
        else{
            doPost(request, response);
        }
    }

    public Order convertToOrder(Cart c, User usr) {
        Date date = new Date();
        double taxRate = 0.075;
        Order ord = new Order(date, usr, taxRate, false);
//        Order ord = new Order("test", usr.getUserID(), taxRate, false);
        ord.setItems(c.getItems());
        double totalCost = 0.0;
        for (int i = 0; i<c.getItems().size(); i++){
            totalCost+=c.getItems().get(i).getTotal();
        }
        ord.setTotalCost(totalCost);
        return ord;
    }
//    public ArrayList<Order> userOrders(int userid) {
//        
//    }
}
