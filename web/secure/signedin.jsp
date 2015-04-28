<%-- 
    Document   : signin
    Created on : Feb 16, 2015, 4:06:15 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Kitten Korner</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/4166_Assignment_2/styles/main.css" type="text/css"/>
        <script type="text/javascript" src="/4166_Assignment_2/main.js">
        </script>
    </head>
    <body>
        <%@ include file="../include/header.jsp" %>
        <%@ include file="../include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="../include/site-navigation.jsp" %>
            <div id="main">
                <div class="breadCrumb">
                    <a class="breadCrumbLink" href="/4166_Assignment_2/index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="signedin.jsp">Signed In</a>
                </div>
                You have successfully signed in!
                <form action="user" method="POST">
<!--                    <input type="hidden" name="userEmail" value="<c:out value=''/>"/>-->
                    <button name="requestedAction" value="confirm" type="submit">Continue</button>
                </form>

            </div>
        <%@ include file="../include/footer.jsp" %>
    </body>
</html>
