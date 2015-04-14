<%--
    Document   : user-navigation
    Created on : Feb 16, 2015, 4:03:57 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="userNav" id="userNav1">
    <ul id="userNavList">
        <li class="${pageContext.request.servletPath == '/signedin.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/secure/signedin.jsp">Sign In</a></li>
        <li class="${pageContext.request.servletPath == '/cart.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/cart.jsp">Cart</a></li>
        <li class="${pageContext.request.servletPath == '/orders.jsp' ? 'currentPage' : 'none'}"><a href="/order?action=viewOrders">My Orders</a></li>
    </ul>
</div>