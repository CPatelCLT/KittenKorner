<%-- 
    Document   : orders
    Created on : Feb 16, 2015, 4:06:02 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>        
        <title>Kitten Korner</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/4166_Assignment_2/styles/main.css" type="text/css"/>
        <script type="text/javascript" src="/4166_Assignment_2/main.js">
        </script>
    </head>
    <body>
        <fmt:setLocale value="en_US"/>
        <%@ include file="../include/header.jsp" %>
        <%@ include file="../include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="../include/site-navigation.jsp" %>
        <div id="main">
            <div class="breadCrumb">
                <a class="breadCrumbLink" href="/4166_Assignment_2/index.jsp">Home</a>
                >
                <a class="breadCrumbLink" href="order">Orders</a>
            </div>
            <div id="cartWrapper">
                <c:set var="total" value="${0.00}"/>
                <c:choose>
                    <c:when test="${sessionScope.currentOrder!=null}">
                        <h1>
                            Invoice #<c:out value="${sessionScope.currentOrder.getOrderNumber()}"/>
                        </h1>
                        <h3>Date: <c:out value="${currentOrder.getDate()}"/></h3>
                        <h4 style="text-decoration: underline">Ship To / Bill To:</h4>
                        <p><c:out value="${currentOrder.getUser().getFirstName()}"/> <c:out value="${currentOrder.getUser().getLastName()}"/><br/>
                            <c:out value="${currentOrder.getUser().getAddress1()}"/><br/>
                            <c:out value="${currentOrder.getUser().getAddress2()}"/><br/>
                            <c:out value="${currentOrder.getUser().getCity()}"/>, <c:out value="${currentOrder.getUser().getState()}"/> <c:out value="${currentOrder.getUser().getPostCode()}"/> <c:out value="${currentOrder.getUser().getCountry()}"/></p>
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

                            <c:forEach items="${sessionScope.currentOrder.getItems()}" var="orderItem"> 
                                <c:set var="total" value="${total+orderItem.getTotal()}"/>
                                <div class="orderItem orderRow">
                                    <div class="orderItemName orderCol">
                                        <c:out value="${orderItem.getProduct().getProductName()}"/>
                                    </div>
                                    <div class="orderItemPrice orderCol">
                                        <c:out value='<fmt:formatNumber value="${orderItem.getProduct().getPrice()}" type="currency"/>'/>
                                    </div>
                                    <div class="orderItemQuantity orderCol">
                                        <c:out value="${orderItem.getQuantity()}"/>
                                    </div>
                                    <div class="orderItemSubtotal orderCol">
                                        <c:out value='<fmt:formatNumber value="${orderItem.getTotal()}" type="currency"/>'/>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <h1>
                                There are currently no orders for your account. Go buy a kitten!
                            </h1>

                        </c:otherwise>
                    </c:choose>
                </div>

                <div id="processingButtons2">
                    <div class="finalCosts">
                        <div class="subtotal">
                            <div class="subtotalLabel">
                                Subtotal:
                            </div>
                            <div class="orderSubtotal">
                                <c:out value='<fmt:formatNumber value="${total}" type="currency"/>'/>
                            </div>
                        </div>
                        <div class="tax">
                            <div class="taxLabel">
                                Tax:
                            </div>
                            <div class="orderTax">
                                <c:set var="orderTax" value="${currentOrder.getTaxRate()*total}"/>
                                <fmt:formatNumber value="${orderTax}" type="currency"/>
                            </div>
                        </div>
                        <div class="total">
                            <div class="totalLabel">
                                Total:
                            </div>
                            <div class="orderTotal">
                                <c:set var="totalCostOfOrder" value="${orderTax+total}"/>
                                <c:out value='<fmt:formatNumber value="${totalCostOfOrder}" type="currency"/>'/>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../include/footer.jsp" %>
    </body>
</html>
