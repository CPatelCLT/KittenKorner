<%--
    Document   : site-navigation
    Created on : Feb 16, 2015, 4:04:08 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="genNav">
    <ul id="genNavList">
        <li class="${pageContext.request.servletPath == '/index.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/index.jsp">Home</a></li>
        <li class="${pageContext.request.servletPath == '/catalog.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/catalog">Cat-alog</a></li>
        <li class="${pageContext.request.servletPath == '/about.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/about.jsp">About</a></li>
        <li class="${pageContext.request.servletPath == '/contact.jsp' ? 'currentPage' : 'none'}"><a href="/4166_Assignment_2/contact.jsp">Contact Us</a></li>
    </ul>
</div>
