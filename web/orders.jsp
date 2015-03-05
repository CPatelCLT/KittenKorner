<%-- 
    Document   : orders
    Created on : Feb 16, 2015, 4:06:02 PM
    Author     : Eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div id="yourCart">

            </div>
            <div id="cartWrapper">
                <h1>
                    Invoice
                </h1>
                <p>Date: ${order.orderDate}March 2nd</p>
                <p style="text-decoration: underline">Ship To / Bill To:</p>
                <h4>${user.name}Chirag Patel<br/>
                    ${user.address1}4017 Sawmill Trace Dr<br/>
                    ${user.address2}<br/>
                    ${user.city}Charlotte, ${user.state}NC ${user.postCode}28213 ${user.country}USA</h4>
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
                    <!-- Each item will have an orderItem div -->

                    <c:set var="totals" value="${0.00}"/>
                    <c:choose>
                        <c:when test="${sessionScope.orderItems!=null}">
                            <c:forEach items="${sessionScope.orderItems.getItems()}" var="orderItem"> 
                                <c:set var="totals" value="${totals+orderItem.getTotalCost()}"/>
                                <div class="orderItem orderRow">
                                    <div class="orderItemName orderCol">
                                        ${orderItem.getProduct().getProductName()}
                                    </div>
                                    <div class="orderItemPrice orderCol">
                                        ${orderItem.getProduct().getPrice()}
                                    </div>
                                    <div class="orderItemQty orderCol">
                                        ${orderItem.getQuantity()}
                                    </div>
                                    <div class="orderItemSubtotal orderCol">
                                        ${orderItem.getTotal()}
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="orderItem orderRow">
                                <div class="orderItemName orderCol">
                                    No Items in Cart.
                                </div>
                                <div class="orderItemPrice orderCol">
                                    $0.00
                                </div>
                                <div class="orderItemQty orderCol">
                                    0
                                </div>
                                <div class="orderItemSubtotal orderCol">
                                    $0.00
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <!--<div class="orderItem orderRow">
                        <div class="orderItemName orderCol">
                            Kitten 1
                        </div>
                        <div class="orderItemPrice orderCol">
                            $1.00
                        </div>
                        <div class="orderItemQty orderCol">
                            2
                        </div>
                        <div class="orderItemSubtotal orderCol">
                            $2.00
                        </div>
                    </div>
                    <div class="orderItem orderRow">
                        <div class="orderItemName orderCol">
                            Kitten 1
                        </div>
                        <div class="orderItemPrice orderCol">
                            $1.00
                        </div>
                        <div class="orderItemQty orderCol">
                            2
                        </div>
                        <div class="orderItemSubtotal orderCol">
                            $2.00
                        </div>
                    </div>
                    <div class="orderItem orderRow">
                        <div class="orderItemName orderCol">
                            Kitten 1
                        </div>
                        <div class="orderItemPrice orderCol">
                            $1.00
                        </div>
                        <div class="orderItemQty orderCol">
                            2
                        </div>
                        <div class="orderItemSubtotal orderCol">
                            $2.00
                        </div>
                    </div>-->



                </div>

                <div id="processingButtons">
                    <div class="finalCosts">
                        <div class="subtotal">
                            <div class="subtotalLabel">
                                Subtotal:
                            </div>
                            <div class="orderSubtotal">
                                $2.00
                            </div>
                        </div>
                        <div class="tax">
                            <div class="taxLabel">
                                Tax:
                            </div>
                            <div class="orderTax">
                                $0.14
                            </div>
                        </div>
                        <div class="total">
                            <div class="totalLabel">
                                Total:
                            </div>
                            <div class="orderTotal">
                                $${totals}
                            </div>
                        </div>    
                    </div>
                    <button id="checkOut" onclick="checkOut()">Check Out</button>
                </div>
            </div>
        </div>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>

