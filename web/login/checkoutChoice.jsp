<%-- 
    Document   : checkoutChoice
    Created on : Mar 30, 2015, 6:51:48 PM
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
                    <a class="breadCrumbLink" href="../index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="checkoutChoice.jsp">Check Out</a>
                </div>
                <H1>Login or Create New User</H1>
                <p>Select one of the two options below to proceed with checkout.</p>
                <div id="checkoutChoiceButtons">
                    <form action="/4166_Assignment_2/secure/signedin.jsp">
                        <button class="checkoutChoiceButton" id="existingUserButton"  type="submit" name="action" value="existingUser">Log in as Existing User</button>
                    </form>
                    <form action="/4166_Assignment_2/login/userInfo.jsp">
                        <button class="checkoutChoiceButton" id="createNewUserButton" type="submit" name="action" value="createNewUser">Create New User</button>
                    </form>
                </div>
            </div>
        <%@ include file="../include/footer.jsp" %>
    </body>
</html>
