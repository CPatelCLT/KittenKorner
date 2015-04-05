<%-- 
    Document   : userInfo
    Created on : Mar 30, 2015, 6:52:34 PM
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
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script type="text/javascript" src="main.js">
        </script>
    </head>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
            <div id="main">
                <div class="breadCrumb">
                    <a class="breadCrumbLink" href="index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="userInfo.jsp">My Info</a>
                </div>
                <div class="errorMsg">
                    ${errorType}
                </div>
                <h1>Create New User Account</h1>
                <form action="user" method="post">
                    <p>Please enter a username: </p>
                    <input type="text" name="userName" size="25">
                    <p>Please enter a password: </p>
                    <input type="password" name="password" size="25">
                    <p>Please enter your first name: </p>
                    <input type="text" name="firstName" size="25">
                    <p>Please enter your last name: </p>
                    <input type="text" name="lastName" size="25">
                    <p>Please enter your email address: </p>
                    <input type="email" name="emailAddr" size="25">
                    <p>Please enter your Address: </p>
                    <input type="text" name="address1" size="50">
                    <p>Please enter your Address (optional): </p>
                    <input type="text" name="address2" size="50">
                    <p>Please enter your city: </p>
                    <input type="text" name="city" size="25">
                    <p>Please enter your state: </p>
                    <input type="text" name="state" size="2">
                    <p>Please enter your postal code: </p>
                    <input type="text" name="postCode" size="25">
                    <button type="submit" name="submitButton" value="createUserButton">Submit</button> 
                </form>
            </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
