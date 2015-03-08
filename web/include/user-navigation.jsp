<%-- 
    Document   : user-navigation
    Created on : Feb 16, 2015, 4:03:57 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="userNav" id="userNav1">
    <ul id="userNavList">
        <li class="${pageContext.request.servletPath == '/signin.jsp' ? 'currentPage' : 'none'}"><a href="signin.jsp">Sign In</a></li>
        <li class="${pageContext.request.servletPath == '/cart.jsp' ? 'currentPage' : 'none'}"><a href="cart.jsp">Cart</a></li>
        <li class="${pageContext.request.servletPath == '/orders.jsp' ? 'currentPage' : 'none'}"><a href="order">My Orders</a></li>        
    </ul>
</div>