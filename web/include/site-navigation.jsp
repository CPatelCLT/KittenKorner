<%-- 
    Document   : site-navigation
    Created on : Feb 16, 2015, 4:04:08 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="genNav">
    <ul id="genNavList">
        <li id="${pageContext.request.servletPath == '/index.jsp' ? 'currentPage' : 'none'}"><a href="index.jsp">Home</a></li>
        <li id="${pageContext.request.servletPath == '/catalog.jsp' ? 'currentPage' : 'none'}"><a href="catalog">Catalog</a></li>
        <li id="${pageContext.request.servletPath == '/about.jsp' ? 'currentPage' : 'none'}"><a href="about.jsp">About</a></li>
        <li id="${pageContext.request.servletPath == '/contact.jsp' ? 'currentPage' : 'none'}"><a href="contact.jsp">Contact Us</a></li>
    </ul>
</div>
