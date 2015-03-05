<%-- 
    Document   : user-navigation
    Created on : Feb 16, 2015, 4:03:57 PM
    Author     : Eric
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="userNav" id="userNav1">
    <ul id="userNavList">
        <li id="${pageContext.request.servletPath == '/signin.jsp' ? 'currentPage' : 'none'}"><a href="signin.jsp">Sign In</a></li>
        <li id="${pageContext.request.servletPath == '/cart.jsp' ? 'currentPage' : 'none'}"><a href="cart.jsp">Cart</a></li>
        <li id="${pageContext.request.servletPath == '/orders.jsp' ? 'currentPage' : 'none'}"><a href="order">My Orders</a></li>        
    </ul>
</div>