<%-- 
    Document   : header
    Created on : Feb 16, 2015, 4:03:19 PM
    Authors    : Eric Knowles
               : Chirag Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="header">
    <img src="/4166_Assignment_2/pictures/pic5.jpg" id="headerPic" alt="ferocious monster pic goes here">
    <div id="headerTitleDiv">
        <h1 id="pageTitle">Kitten Korner</h1>
        <p id="description">The ultimate place to purchase a little furry friend!</p>
    </div>
    <div id="headerRightInfo">
        <div id="loggedIn">
            <c:choose>
                <c:when test="${sessionScope.theUser != null}">
                    ${sessionScope.theUser}
                </c:when>
                <c:otherwise>
                    <a href="/4166_Assignment_2/secure/checkoutChoice.jsp">Click here to sign up/in!</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>