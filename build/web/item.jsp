<%-- 
    Document   : item
    Created on : Feb 16, 2015, 4:05:54 PM
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
            <div id="itemWrapper">
                <div class="itemPictureDiv">
                    <img class="itemPicture" src="${item.getImageUrl()}" alt="item 1 picture">
                </div>
                <div class="itemInfoDiv">
                    <h1>
                        ${item.getProductName()}
                    </h1>
                    <p>
                        ${item.getCatalogCategory()}
                    </p>
                    <p>
                        Price: ${item.getPrice()} 
                    </p>
                </div>
                <div class="itemButtonHolderDiv">
                    <form method="POST" action="order">
                        <button class="addItemToCart" type="submit">Add To Cart</button>
                        <input type="hidden" name="buttonClicked" value="addToCartButton">
                        <input type="hidden" name="productCode" value="${item.getProductCode()}">
                    </form>

                    <button class="addItemToCart" onclick="parent.location = 'catalog'">Back</button>
                </div>
                <div class="itemDetailsDiv">
                    <p>
                        ${item.getDescription()}
                    </p>
                </div>
            </div>  
        </div>    
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
