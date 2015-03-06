<%-- 
    Document   : contact
    Created on : Feb 16, 2015, 4:05:46 PM
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
                <a class="breadCrumbLink" href="contact.jsp">Contact Us</a>
            </div>
            <p>If you have any issues or concerns you can address them to Wayne Wilson at "wcwilso1@uncc.edu"!</p>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
