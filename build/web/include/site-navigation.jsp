<%-- 
    Document   : site-navigation
    Created on : Feb 16, 2015, 4:04:08 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="genNav">
    <ul id="genNavList">
        <li id="${pageContext.request.servletPath == index.html ? 'currentPage' : 'none'}"><a href="index.jsp">Home</a></li>
        <li><a href="catalog">Catalog</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="contact.jsp">Contact Us</a></li>
    </ul>
</div>
