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
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
        <script type="text/javascript" src="../main.js">
        </script>
    </head>
    <body>
        <%@ include file="../include/header.jsp" %>
        <%@ include file="../include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="../include/site-navigation.jsp" %>
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
                    <p>Please enter a username: 
                    <input type="text" name="userName" size="25"></p>
                    <p>Please enter a password: 
                    <input type="password" name="password" size="25"></p>
                    <p>Please enter your first name: 
                    <input type="text" name="firstName" size="25"></p>
                    <p>Please enter your last name: 
                    <input type="text" name="lastName" size="25"></p>
                    <p>Please enter your email address: 
                    <input type="email" name="emailAddr" size="25"></p>
                    <p>Please enter your Address: 
                    <input type="text" name="address1" size="50"></p>
                    <p>Please enter your Address (optional): 
                    <input type="text" name="address2" size="50"></p>
                    <p>Please enter your city: 
                    <input type="text" name="city" size="25"></p>
                    <p>Please enter your state: 
                    <input type="text" name="state" size="2"></p>
                    <p>Please enter your postal code: 
                    <input type="text" name="postCode" size="25"></p>
                    <button type="submit" name="submitButton" value="createUserButton">Submit</button> 
                </form>
            </div>
        <%@ include file="../include/footer.jsp" %>
    </body>
</html>
