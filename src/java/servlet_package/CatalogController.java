/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import java.io.*;
import java.util.ArrayList;
import java_files.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import temp_db.ProductDB;
/*import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

/**
 *
 * @author Eric
 */

public class CatalogController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
        ProductDB pdb = new ProductDB();
        ArrayList<Product> prodList = pdb.getProdList();
        request.setAttribute("products", pdb);
        RequestDispatcher rd = request.getRequestDispatcher("/catalog.jsp");
        rd.forward(request, response);
    }  
}
