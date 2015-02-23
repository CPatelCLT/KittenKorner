<%-- 
    Document   : cart
    Created on : Feb 16, 2015, 4:05:12 PM
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
    <body onload="setSizes(); getCart();">
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
            <div id="main">
                <div id="cartWrapper">
                    <div id="yourCart">
                        <h1>
                            Welcome to your shopping cart!
                        </h1>
                    </div>
                    <div id="cartItems">
                        <div id="cartItemsCategories">
                            <div id="itemCategoryLabel">
                                Item
                            </div>
                            <div id="priceCategoryLabel">
                                Price
                            </div>
                            <div id="quantityCategoryLabel">
                                Quantity
                            </div>
                            <div id="totalCategoryLabel">
                                Total
                            </div>
                        </div>
                        <div id="itemsInCart">
                        </div>
                    </div>
                    <div id="processingButtons">
                        <button id="checkOut" onclick="checkOut()">Check Out</button>
                        <button id="updateCart" onclick="updateCart()">Update Cart</button>
                    </div>
                </div>
            </div>
        <%@ include file="include/footer.jsp" %>

        <div id="hiddenItems">

            <div id="emptyCart">
                <div class="itemCategory">
                    Your shopping cart is empty, go pick out a kitten!
                </div>
                <div class="priceCategory">

                </div>
                <div class="quantityCategory">

                </div>
                <div class="totalCategory">

                </div>
                <div class="clearBoth">

                </div>
            </div>

            <div id="newItemInCart">
                <div class="itemCategory">
                    Item Placeholder
                </div>
                <div class="priceCategory">
                    Price Placeholder
                </div>
                <div class="quantityCategory">
                    <form>
                        <input value="1" class="quantityTextBox" type="text" name="quantity">
                    </form>
                </div>
                <div class="totalCategory">
                    Total Placeholder
                </div>
                <div class="clearBoth">

                </div>
            </div>

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
                </div>
                <div class="priceHolder">
                    100.00
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
                </div>
                <div class="priceHolder">
                    200.00
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
                </div>
                <div class="priceHolder">
                    300.00
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
                </div>
                    <div class="priceHolder">
                    400.00
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
                </div>
                <div class="priceHolder">
                    500.00
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
                </div>
                <div class="priceHolder">
                    600.00
                </div>
            </div>
            <div class="itemPreviewButtons">
                <button class="moreInfoButton" onclick="parent.location = 'item.jsp'">More Information</button>
                <button class="addToCart" onclick="addToCart('product6')">Add To Cart</button>
            </div>
        </div>
    </div>
</body>
</html>
