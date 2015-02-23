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
                        <img class="itemPicture" src="pictures/pic1.jpg" alt="item 1 picture">
                    </div>
                    <div class="itemInfoDiv">
                        <h1>
                            Lucy
                        </h1>
                        <p>
                            Categories: Ferocious, Cute, and Crazy!
                        </p>
                        <p>
                            Price: Priceless
                        </p>
                    </div>
                    <div class="itemButtonHolderDiv">
                        <button class="addItemToCart" onclick="addToCart('product1')">Add To Cart</button>
                        <button class="addItemToCart" onclick="parent.location = 'catalog.jsp'">Back</button>
                    </div>
                    <div class="itemDetailsDiv">
                        <p>
                            This crazy little monster's favorite past times are sleeping, eating, and terrorizing the local mousie, fishie, and birdie population!  She has mastered the art of being a cutie and her beauty is unmatched.  Be careful though, while she looks innocent her ferociousness is renown!
                        </p>
                    </div>
                </div>  
            </div>    
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
