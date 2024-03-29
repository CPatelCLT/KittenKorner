<%-- 
    Document   : item
    Created on : Feb 16, 2015, 4:05:54 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="breadCrumbLink" href="catalog.jsp">Catalog</a>
                >
                <a class="breadCrumbLink" href="item.jsp"><c:out value="${item.getProductName()}"/></a>
            </div>
            <div id="itemWrapper">
                <div class="itemPictureDiv">
                    <img class="itemPicture" src="<c:out value="${item.getImageUrl()}"/>" alt="item 1 picture">
                </div>
                <div class="itemInfoDiv">
                    <h1>
                        <c:out value="${item.getProductName()}"/>
                    </h1>
                    <p>
                        <c:out value="${item.getCatalogCategory()}"/>
                    </p>
                    <p>
                        Price: <fmt:formatNumber value="${item.getPrice()}" type="currency"/>
                    </p>
                </div>
                <div class="itemButtonHolderDiv">
                    <form method="POST" action="order">
                        <button id="addItemToCartb1" type="submit" name="action" value="addToCartButton">Add To Cart</button>
                        <input type="hidden" name="productCode" value="<c:out value="${item.getProductCode()}"/>"></form>
                        <form method="GET" action="catalog">
                        <button id="addItemToCartb2" type="submit" name="action" value="backToCatalog">Back</button>
                        </form>
                </div>
                <div class="itemDetailsDiv">
                    <p>
                        <c:out value="${item.getDescription()}"/>
                    </p>
                </div>
            </div>  
        </div>    
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
