<%-- 
    Document   : login
    Created on : Mar 30, 2015, 6:52:21 PM
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
                    <a class="breadCrumbLink" href="index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="login.jsp">Log In</a>
                </div>
                <p>
                    Please log in or click <a class="blueLink" href="/4166_Assignment_2/userInfo.jsp">here</a> to create a new account.
                </p>
                <form action="user" method="POST">
                    <p>Please enter a username: 
                    <input type="text" name="username" size="25"></p>
                    <p>Please enter a password: 
                    <input type="password" name="password" size="25"></p>
                    <button type="submit" name="requestedAction" value="login">Submit</button> 
                </form>
            </div>
        <%@ include file="/include/footer.jsp" %>
    </body>
</html>
