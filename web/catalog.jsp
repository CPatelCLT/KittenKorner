<%-- 
    Document   : catalog
    Created on : Feb 16, 2015, 4:05:33 PM
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
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script type="text/javascript" src="main.js">
        </script>
    </head>
    <body onload="setSizes();">
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
        <div id="main">
            <div class="breadCrumb">
                <a class="breadCrumbLink" href="index.jsp">Home</a>
                >
                <a class="breadCrumbLink" href="catalog">Catalog</a>
            </div>
            <div id="sorter">
                <form method="GET" action="catalog">
                    Category: <select id="categorySelector" selected="${curCategory}" name="categorySelect" size="1">
                        <option value="all" ${curCategory == 'all' ? 'selected' : ''}>All</option>
                        <option value="cute" ${curCategory == 'cute' ? 'selected' : ''}>Cute</option>
                        <option value="evil" ${curCategory == 'evil' ? 'selected' : ''}>Evil</option>
                    </select>
                    <button class="updateCatalog" type="submit">Update</button>
                </form>
            </div>
            <div id="itemHolder">
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
                                <form method="GET" action="catalog">
                                    <button class="moreInfoButton" type="submit">More Info</button>
                                    <input type="hidden" name="buttonClicked" value="itemInfoButton">
                                    <input type="hidden" name="productCode" value="${prod.getProductCode()}">
                                </form>
                            </div>
                        </div>
                        <c:if test="${count % 3 == 2}">
                        </div>
                    </c:if>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
            </div>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>



