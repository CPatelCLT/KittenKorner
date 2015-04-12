<%-- 
    Document   : payment
    Created on : Mar 30, 2015, 6:52:53 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kitten Korner</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
        <script type="text/javascript" src="../main.js">
        </script>
    </head>
    <body>
        <%@ include file="../include/header.jsp" %>
        <%@ include file="../include/user-navigation.jsp" %>
        <div id="pageContent"></div>
        <%@ include file="../include/site-navigation.jsp" %>
            <div id="main">
                <div class="breadCrumb">
                    <a class="breadCrumbLink" href="../index.jsp">Home</a>
                    >
                    <a class="breadCrumbLink" href="payment.jsp">Payment Options</a>
                </div>
                <h1>
                    Enter Your Payment Information
                </h1>
                <form action="orders" method="post">
                    <table>
                        <tr>
                            <td>
                                Credit Card Type: 
                            </td>
                            <td>
                                <input type="text" list="creditCardType">
                                <datalist id="creditCardType">
                                    <option>
                                        Visa
                                    </option>
                                    <option>
                                        Mastercard
                                    </option>
                                    <option>
                                        Discover
                                    </option>
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Card Number: 
                            </td>
                            <td>
                                <input type="text" name="creditCardNumber">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Expiration Date (MM/YYYY): 
                            </td>
                            <td>
                                <input type="text" list="monthSelect">
                                <datalist id="monthSelect">
                                    <option>
                                        January
                                    </option>
                                    <option>
                                        February
                                    </option>
                                    <option>
                                        March
                                    </option>
                                    <option>
                                        April
                                    </option>
                                    <option>
                                        May
                                    </option>
                                    <option>
                                        June
                                    </option>
                                    <option>
                                        July
                                    </option>
                                    <option>
                                        August
                                    </option>
                                    <option>
                                        September
                                    </option>
                                    <option>
                                        October
                                    </option>
                                    <option>
                                        November
                                    </option>
                                    <option>
                                        December
                                    </option>
                                </datalist>
                            </td>
                            <td>
                                <input type="text" list="yearSelect">
                                <datalist id="yearSelect">
                                    <option>
                                        2015
                                    </option>
                                    <option>
                                        2016
                                    </option>
                                    <option>
                                        2017
                                    </option>
                                    <option>
                                        2018
                                    </option>
                                    <option>
                                        2019
                                    </option>
                                    <option>
                                        2020
                                    </option>
                                    <option>
                                        2021
                                    </option>
                                    <option>
                                        2022
                                    </option>
                                    <option>
                                        2023
                                    </option>
                                    <option>
                                        2024
                                    </option>
                                    <option>
                                        2025
                                    </option>
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                CVV (3-digit): 
                            </td>
                            <td>
                                <input type="text" name="cvv">
                            </td>
                        </tr>
                    </table>
                    <p>
                        Your card will be charged a total of <fmt:formatNumber value="${sessionScope.thisOrder.getTotalCost()}" type="currency"/>.
                    </p>
                    <button type="submit" name="action" value="confirmOrder">Confirm Payment</button>
                </form>
            </div>
        <%@ include file="../include/footer.jsp" %>
    </body>
</html>
