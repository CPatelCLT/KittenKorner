/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java_beans.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
public class UserController extends HttpServlet {

    UserDB udb = new UserDB();
    User currUser;
    String requestedAction, errorType;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestedAction = request.getParameter("requestedAction");
        if (requestedAction.equals("createUser")) {
            String firstName, lastName, emailAddress, password, address1, address2, city, state, postCode, country;
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            emailAddress = request.getParameter("emailAddr");
            address1 = request.getParameter("address1");
            address2 = request.getParameter("address2");
            city = request.getParameter("city");
            state = request.getParameter("state");
            postCode = request.getParameter("postCode");
            country = request.getParameter("country");
            password = request.getParameter("password");
            currUser = new User(firstName, lastName, emailAddress, address1, address2, city, state, postCode, country, password);
            ArrayList<User> allUsers = udb.getAllUsers();
            if (allUsers != null) {
                for (int i = 0; i < allUsers.size(); i++) {
                    if (currUser.getEmailAddress().equalsIgnoreCase(allUsers.get(i).getEmailAddress())) {
                        errorType = "User exists in Database";
                        request.setAttribute("errorType", errorType);
                        RequestDispatcher dispatch = request.getRequestDispatcher("/userInfo.jsp");
                        dispatch.forward(request, response);
                        return;
                    }
                }
            }
            udb.addUser(firstName, lastName, emailAddress, address1, address2, city, state, postCode, country, password);
//            currUser = udb.getUserByEmail(emailAddress);
//            request.getSession().setAttribute("theUser", currUser);
            //RequestDispatcher dispatch;
            //dispatch = request.getRequestDispatcher("/secure/signedin.jsp");
            //dispatch.forward(request, response);
            response.sendRedirect("secure/signedin.jsp");
//            if (request.getSession().getAttribute("theShoppingCart") != null) {
////                        response.sendRedirect("/order?buttonClicked=addToCartButton");
//                dispatch = request.getRequestDispatcher("/cart.jsp");
//                dispatch.forward(request, response);
//            } else {
//                dispatch = request.getRequestDispatcher("/index.jsp");
//                dispatch.forward(request, response);
//            }
        } else if (requestedAction.equals("confirm")) {
            String emailAddr = request.getParameter("userEmail");
            if (emailAddr.equals("")) {
                request.setAttribute("error", "Error processing login, please try again.");
                RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
                dispatch.forward(request, response);
            } else {
            User usr = udb.getUserByEmail(emailAddr);
            request.getSession().setAttribute("theUser", usr);
            RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
            dispatch.forward(request, response);
            }
        }
//        else if (requestedAction.equals("j_securitycheck")) {
//            String username, password;
//            username = request.getParameter("j_username");
//            password = request.getParameter("j_password");
//            ArrayList<User> allUsers = udb.getAllUsers();
//            for (int i = 0; i<allUsers.size(); i++) {
//                if (username.equalsIgnoreCase(allUsers.get(i).getEmailAddress())) {
//                    if(password.equals(allUsers.get(i).getPassword())){
//                        request.getSession().setAttribute("theUser", allUsers.get(i));
//                        RequestDispatcher dispatch;
//                        if (request.getSession().getAttribute("theShoppingCart") != null) {
//                            dispatch = request.getRequestDispatcher("/secure/orders.jsp");
//                        }
//                        else{
//                            dispatch = request.getRequestDispatcher("/secure/index.jsp");
//                        }
//                        dispatch.forward(request, response);
//                    }
//                }
//            }
//        }
//        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
