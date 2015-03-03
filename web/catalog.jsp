<%-- 
    Document   : catalog
    Created on : Feb 16, 2015, 4:05:33 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body onload="setSizes(); updateCatalog();">
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
            <div id="main">
                <div id="sorter">
                    <form method="GET" action="catalog">
                    Category: <select id="categorySelector" selected="${curCategory}" name="categorySelect" size="1">
                        <option value="all">All</option>
                        <option value="cute">Cute</option>
                        <option value="evil">Evil</option>
                    </select>
                    <button class="updateCatalog" onclick="parent.location = 'catalog'">Update</button>
                    </form>
                </div>
                <div id="itemHolder">
                    <!-- not working yet -->
                    <c:set var="count" value="0" scope="page" />
                    
                    <c:forEach items="${items}" var="prod">
                        <c:if test="${count % 3 == 0}">
                            <div class="row">
                        </c:if>
                        <div class="itemContainer">
                            <div class="itemPreviewPic">
                                <img class="previewPicFormat" src="${prod.getImageUrl()}" alt="product photo">
                            </div>
                            <div class="itemDescription">
                                <h2>
                                    ${prod.getProductName()}
                                </h2>
                                <p>
                                    ${prod.getDescription()}
                                </p>
                            </div>
                            <div class="itemPreviewButtons">
<!--                                <div class="moreInfoButton">
                                    <a href="catalog?productCode=  el for product code here  ">Add To Cart</a>
                                </div>-->
                                <form method="GET" action="catalog">
                                    <button class="moreInfoButton" type="submit">More Info</button>
                                    <input type="hidden" name="buttonClicked" value="itemInfoButton">
                                    <input type="hidden" name="productCode" value="${prod.getProductCode()}">
                                </form>
<!--                                where dd to cart button was-->
                            </div>
                        </div>
                        <c:if test="${count % 3 == 2}">
                            </div>
                        </c:if>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach>
                    <!-- end not working yet-->
                </div>
            </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>



