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
                    <form action="updateCatalog" method="get">
                    Category: <select id="categorySelector" name="categorySelect" size="1">
                        <option value="all">All</option>
                        <option value="ferocious">Ferocious</option>
                        <option value="cute">Cute</option>
                        <option value="crazy">Crazy</option>
                    </select>
                    <button class="updateCatalog" onclick="updateCatalog()">Update</button>
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
                                <form method="GET" action="item.jsp">
                                    <button class="moreInfoButton" type="submit">More Info</button>
                                    <input type="hidden" name="prodCode" value="${prod.getProductCode()}">
                                </form>
                                <form method="POST" action="cart.jsp">
                                    <button class="addToCart" type="submit">Add To Cart</button>
                                    <input type="hidden" name="prodCode" value="${prod.getProductCode()}">
                                </form>
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



