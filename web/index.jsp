<%-- 
    Document   : index
    Created on : Feb 16, 2015, 4:04:45 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>

        <%@ include file="include/site-navigation.jsp" %>
        <div id="main">
            <div class="breadCrumb">
                <a class="breadCrumbLink" href="/4166_Assignment_2/index.jsp">Home</a>
            </div>
            <div id="welcomeMessage">
                <p>
                    Welcome to the Kitten Korner!
                </p>
                <p>
                    The Kitten Korner is your ultimate destination if you are wanting to<br>make an impulsive 15+ year commitment to obtain a ferocious furry <br>little friend from a random online site without ever meeting it first!
                </p>
            </div>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
