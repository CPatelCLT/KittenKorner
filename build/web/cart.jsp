<%-- 
    Document   : cart
    Created on : Feb 16, 2015, 4:05:12 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <body onload="setSizes();">
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
        <div id="main">
            <div class="breadCrumb">
                <a class="breadCrumbLink" href="index.jsp">Home</a>
                >
                <a class="breadCrumbLink" href="cart.jsp">Shopping Cart</a>
            </div>
            <div id="cartWrapper">

                <div id="yourCart">
                    <h1>
                        Welcome to your shopping cart!
                    </h1>
                </div>
                <form class="cartForm" method="POST" action="order">
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
                            <c:set var="total" value="${0.00}"/>
                            <c:forEach items="${sessionScope.theShoppingCart.getItems()}" var="cItem">
                                <c:set var="total" value="${total+cItem.getTotal()}"/>
                                <div id="newItemInCart">
                                    <div class="itemCategory">
                                        ${cItem.getProduct().getProductName()}
                                    </div>
                                    <div class="priceCategory">
                                        <fmt:formatNumber value="${cItem.getProduct().getPrice()}" type="currency"/>

                                    </div>
                                    <div class="quantityCategory">
                                        <input value="${cItem.getQuantity()}" class="quantityTextBox" type="text" name="${cItem.getProduct().getProductCode()}">
                                    </div>
                                    <div class="totalCategory">
                                        <fmt:formatNumber value="${cItem.getTotal()}" type="currency"/>

                                    </div>
                                    <div class="clearBoth">

                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="subtotal">
                        <div class="subtotalLabel">
                            Subtotal:
                        </div>
                        <div class="cartSubtotalValue">
                            <fmt:formatNumber value="${total}" type="currency"/>
                        </div>
                    </div>
                    <div id="processingButtons">
                        <button id="checkOut"  type="submit" name="action" value="checkout">Check Out</button>
                        <button id="updateCart" type="submit" name="action" value="updateCart">Update Cart</button>
                    </div>
                </form>
            </div>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
