<%-- 
    Document   : orders
    Created on : Feb 16, 2015, 4:06:02 PM
    Author     : Eric
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
    <body>
        <fmt:setLocale value="en_US"/>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="include/site-navigation.jsp" %>
        <div id="main">
            <div class="breadCrumb">
                    <a class="breadCrumbLink" href="index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="orders">Orders</a>
            </div>
            <div id="cartWrapper">
                <h1>
                    Invoice
                </h1>
                <h3>Date: ${orderItems.getDate()}</h3>
                <h4 style="text-decoration: underline">Ship To / Bill To:</h4>
                <p>${orderItems.getUser().getFirstName()} ${orderItems.getUser().getLastName()}<br/>
                    ${orderItems.getUser().getAddress1()}<br/>
                    ${orderItems.getUser().getAddress2()}<br/>
                    ${orderItems.getUser().getCity()}, ${orderItems.getUser().getState()} ${orderItems.getUser().getPostCode()} ${orderItems.getUser().getCountry()}</p>
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
                    <c:set var="total" value="${0.00}"/>
                    <c:choose>
                        <c:when test="${sessionScope.orderItems!=null}">
                            <c:forEach items="${sessionScope.orderItems.getItems()}" var="orderItem"> 
                                <c:set var="total" value="${total+orderItem.getTotal()}"/>
                                <div class="orderItem orderRow">
                                    <div class="orderItemName orderCol">
                                        ${orderItem.getProduct().getProductName()}
                                    </div>
                                    <div class="orderItemPrice orderCol">
                                        <fmt:formatNumber value="${orderItem.getProduct().getPrice()}" type="currency"/>
                                    </div>
                                    <div class="orderItemQuantity orderCol">
                                        ${orderItem.getQuantity()}
                                    </div>
                                    <div class="orderItemSubtotal orderCol">
                                        <fmt:formatNumber value="${orderItem.getTotal()}" type="currency"/>
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
                                <fmt:formatNumber value="${total}" type="currency"/>
                            </div>
                        </div>
                        <div class="tax">
                            <div class="taxLabel">
                                Tax:
                            </div>
                            <div class="orderTax">
                                <c:set var="orderTax" value="${orderItems.getTaxRate()*total}"/>
                                <fmt:formatNumber value="${orderTax}" type="currency"/>
                            </div>
                        </div>
                        <div class="total">
                            <div class="totalLabel">
                                Total:
                            </div>
                            <div class="orderTotal">
                                <c:set var="totalCostOfOrder" value="${orderTax+total}"/>
                                <fmt:formatNumber value="${totalCostOfOrder}" type="currency"/>
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

