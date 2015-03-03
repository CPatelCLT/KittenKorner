/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Eric
 */
public class OrderController extends HttpServlet {
    String buttonClicked;
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        buttonClicked = request.getParameter("buttonClicked");
        if (buttonClicked.equals("addToCartButton")) {
            
        }
    }
    
}
