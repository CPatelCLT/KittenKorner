<%-- 
    Document   : loginerror
    Created on : Apr 10, 2015, 8:04:44 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kitten Korner</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/4166_Assignment_2/styles/main.css" type="text/css"/>
        <script type="text/javascript" src="/4166_Assignment_2/main.js">
        </script>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="/include/site-navigation.jsp" %>
            <div id="main">
                <div class="breadCrumb">
                    <a class="breadCrumbLink" href="/4166_Assignment_2/index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="/4166_Assignment_2/login.jsp">Log In</a>
                </div>
                <p>Your login attempt failed, please go <a class="blueLink" href="/login.jsp">back</a> and try again!</p>
            </div>
        <%@ include file="/include/footer.jsp" %>
    </body>
</html>
