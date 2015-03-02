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
                    <c:forEach items="${prodResponse}" var="prod">
                        <c:if test="${count % 3 == 0}">
                            <div class="row">
                        </c:if>
                        <div class="itemContainer">
                            <div class="itemPreviewPic">
                                <img class="previewPicFormat" src="${prod.ImageUrl}" alt="product photo">
                            </div>
                            <div class="itemDescription">
                                <h2>
                                    ${prod.Name}
                                </h2>
                                <p>
                                    ${prod.Description}
                                </p>
                            </div>
                            <div class="itemPreviewButtons">
                                <form method="GET" action="item.jsp">
                                    <button class="moreInfoButton" type="submit">More Info</button>
                                    <input type="hidden" name="prodCode" value="${prod.Productcode}">
                                </form>
                                <form method="POST" action="cart.jsp">
                                    <button class="addToCart" type="submit">Add To Cart</button>
                                    <input type="hidden" name="prodCode" value="${prod.Productcode}">
                                </form>
                            </div>
                        </div>
                        <c:if test="${count % 3 == 0}">
                            </div>
                        </c:if>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach>
                    <!-- end not working yet-->
                </div>
            </div>
        <%@ include file="include/footer.jsp" %>
        <div id="hiddenItems">

            <div class="itemContainer" id="product1">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic1.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #1
                    </h2>
                    <p>
                        This furry cutie can't wait to come home with you!<br>Category: Cute, Crazy
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product1')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input cl <inpass="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

            <div class="itemContainer" id="product2">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic2.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #2
                    </h2>
                    <p>
                        Watch out, this one is a fighter!<br>Category: Ferocious, Cute
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product2')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input class="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

            <div class="itemContainer" id="product3">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic3.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #3
                    </h2>
                    <p>
                        Such a beautiful creature!<br>Category: Crazy, Ferocious
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product3')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input class="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

            <div class="itemContainer" id="product4">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic4.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #4
                    </h2>
                    <p>
                        She just wants a good home!<br>Category: Crazy, Cute
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product4')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input class="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

            <div class="itemContainer" id="product5">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic5.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #5
                    </h2>
                    <p>
                        Warning, do not buy if you are allergic to cuteness!<br>Category: Ferocious, Crazy
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product5')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input class="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

            <div class="itemContainer" id="product6">
                <div class="itemPreviewPic">
                    <img class="previewPicFormat" src="pictures/pic1.jpg" alt="picture of kitten">
                </div>
                <div class="itemDescription">
                    <h2>
                        Kitten #6
                    </h2>
                    <p>
                        How can you say no to a face like this?<br>Category: Cute, Ferocious
                    </p>
                </div>
                <div class="itemPreviewButtons">
                    <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                    <button class="addToCart" onclick="addToCart('product6')">Add To Cart</button>
                    <!--<form action="item.html">
                        <input class="moreInfoButton" type="submit" value="More Info">
                    </form>
                    <form action="cart.html">
                        <input class="addToCart" type="submit" value="Add To Cart">
                    </form>-->
                </div>
            </div>

        </div>
    </body>
</html>
