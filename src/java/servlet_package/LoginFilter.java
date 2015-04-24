/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

/**
 *
 * @author chirag
 */
// Servlet Filter source code: LoginFilter.java
/**
 * A Servlet filter example: This example filters j_security_check and
 * performs pre-login action to determine if the user trying to log in
 * is in the revoked list. If the user is in revoked list, an error is
 * sent back to the browser.
 *
 * This filter reads the revoked list file name from the FilterConfig 
 * passed in the init() method. Reads the revoked user list file and
 * creates a revokedUsers list.
 * 
 * When doFilter method is called, the user being logged in is checked 
 * to make sure that the user is not in the revoked User list.
 *
 */

import db.PWUtil;
import db.UserDB;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_beans.User;

public class LoginFilter implements Filter {

  protected FilterConfig filterConfig;
  java.util.List revokeList; 
   

 /**
  * init() : init() method called when the filter is instantiated. This
  * filter is instantiated first time j_security_check is invoked for the
  * application (when a protected servlet in the application is accessed).
     * @param filterConfig
     * @throws javax.servlet.ServletException
  */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }


 /**
  * doFilter() : doFilter() method called before the servlet that this filter
  * is mapped is invoked. Since this filter is mapped to j_security_check, 
  * this method is called before j_security_check action is posted.
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
  */
  @Override
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
   throws java.io.IOException, ServletException {

     HttpServletRequest req = (HttpServletRequest)request;
     HttpServletResponse res = (HttpServletResponse)response;

     // pre login action
      UserDB udb = new UserDB();
     String username = request.getParameter("username");
            String password = request.getParameter("password");
            User temp = udb.getUserByEmail(username);
            PWUtil pw = new PWUtil();
            try {
                password = pw.hashAndSaltPassword(temp.getSalt(), password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("j_username", username);
            request.setAttribute("j_password", password);

            
     // call next filter in the chain : let j_security_check authenticate user
     chain.doFilter(request, response);

     // post login action
   }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}