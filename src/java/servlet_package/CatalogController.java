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
    ArrayList<Product> items = new ProductDB().getProdList();
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String requestedProduct = request.getParameter("requestProduct"); //getting the value (from the url or post) that the user submits
        
        
        
        if(false)//this will be used for specific item if requestedProduct is not null;
        {
            String nada=null;
        }
        else
        {
            request.setAttribute("alert", "I got here");
            request.setAttribute("items", items); //must use this to set the attribute for el to be able to use it
            RequestDispatcher dispatch = request.getRequestDispatcher("/catalog.jsp");
            dispatch.forward(request, response);
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }  
}
