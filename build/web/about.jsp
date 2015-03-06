<%-- 
    Document   : about
    Created on : Feb 16, 2015, 4:05:03 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                <a class="breadCrumbLink" href="about.jsp">About Us</a>
            </div>
            <p>The Kitten Korner is your number one online location to buy a live ferocious animal that you have never met before!</p>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
