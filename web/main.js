/* 
 * Eric Knowles
 * Assignement 1
 * ITIS-4166
 */
window.onload = function () {
    checkCookie();
    setSizes();
};

window.onresize = function(){
    //alert("this ran");
    setSizes();
};
/*
window.onscroll = function(){
    scroll();
};*/


function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ')
            c = c.substring(1);
        if (c.indexOf(name) == 0)
            return c.substring(name.length, c.length);
    }
    return "";
}

function checkCookie() {
    var cart = getCookie("cart");
    if (cart != "") {
        //for later use
    } else {
        cart = "empty";
        if (cart != "" && cart != null) {
            setCookie("cart", cart, 365);
        }
    }
}

function addToCart(item) {
    var cart = getCookie("cart");
    if (cart == "empty") {
        setCookie("cart", (item + ".1"), 365);
    }
    else if (checkDuplicate(cart, item)) {
        //alert("duplicate check ran");

    }
    else {
        cart = (cart + "," + item + ".1");
        setCookie("cart", cart, 365);
    }
}

function checkDuplicate(cart, item) {
    var splitCookie = cart.split(',');
    for (x = 0; x < splitCookie.length; x++) {
        var cookValue = splitCookie[x].split('.');
        var quan = cookValue[1];
        cookValue = cookValue[0];
        if (cookValue == item) {
            quan = (parseFloat(quan) + 1)
            increaseQuantity(cart, item, quan);
            return true;
        }
    }
    return false;
}

function increaseQuantity(cart, item, quan) {
    var index = cart.search(item);
    index = (parseInt(index) + item.length + 1);
    if (quan <= 10) {
        cart = (cart.substr(0, index) + quan + cart.substr((index + 1), cart.length));
    }
    else {
        cart = (cart.substr(0, index) + quan + cart.substr((index + 2), cart.length));
    }
    setCookie("cart", cart, 365);
}

function getQuantity(item) {
    var cart = getCookie("cart");
    var splitCookie = cart.split(',');
    for (x = 0; x < splitCookie.length; x++) {
        var cookValue = splitCookie[x].split('.');
        if (item == cookValue[0]) {
            var q = cookValue[1];
            return q;
        }
    }
}

function updateCatalog() {
    var e = document.getElementById("categorySelector");
    var val = e.options[e.selectedIndex].value;
    catalogDisplay(val);
}


function catalogDisplay(value) {
    var all = ["product1", "product2", "product3", "product4", "product5", "product6"];
    var cute = ["product1", "product2", "product4", "product6"];
    var ferocious = ["product2", "product3", "product5", "product6"];
    var crazy = ["product1", "product3", "product4", "product5"];
    for (x = 0; x < all.length; x++) {
        var curItemBox = ("item" + (x + 1));
        var d = document.getElementById(all[x]);
        document.getElementById('hiddenItems').appendChild(d);
    }
    if (value == "all") {
        ;
        for (x = 0; x < all.length; x++) {
            var curItemBox = ("item" + (x + 1));
            var d = document.getElementById(all[x]);
            document.getElementById(curItemBox).appendChild(d);
        }
    }
    if (value == "cute") {
        for (x = 0; x < cute.length; x++) {
            var curItemBox = ("item" + (x + 1));
            var d = document.getElementById(cute[x]);
            document.getElementById(curItemBox).appendChild(d);
        }
    }
    if (value == "ferocious") {
        for (x = 0; x < ferocious.length; x++) {
            var curItemBox = ("item" + (x + 1));
            var d = document.getElementById(ferocious[x]);
            document.getElementById(curItemBox).appendChild(d);
        }
    }
    if (value == "crazy") {
        for (x = 0; x < crazy.length; x++) {
            var curItemBox = ("item" + (x + 1));
            var d = document.getElementById(crazy[x]);
            document.getElementById(curItemBox).appendChild(d);
        }
    }
}

function getCart() {
    var cook = document.cookie;
    var splitCook = cook.split('=');
    splitCook = splitCook[1];
    splitCook = splitCook.split(',');
    if (splitCook[0] == "empty") {
        var d = document.getElementById("emptyCart");
        document.getElementById("itemsInCart").appendChild(d);
    }
    else {
        for (x = 0; x < splitCook.length; x++) {
            splitCookStripped = splitCook[x].split('.');
            splitCookStripped = splitCookStripped[0];
            var newItemEle = document.getElementById("newItemInCart");
            var cln = newItemEle.cloneNode(true);
            //set Title with        cln.firstElementChild.innerHTML=
            //set Price with        cln.firstElementChild.nextElementSibling.innerHTML=
            //set Quantity with     cln.firstElementChild.nextElementSibling.nextElementSibling.innerHTML=
            //set Total with        cln.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML=
            var title = document.getElementById(splitCookStripped).firstElementChild.nextElementSibling.firstElementChild.innerHTML;
            var price = (document.getElementById(splitCookStripped).lastElementChild.innerHTML);
            var quantity = getQuantity(splitCookStripped);
            quantity = ("" + quantity);
            var total = ("$" + ((parseFloat(quantity) * parseFloat(price)).toFixed(2)));
            price = ("$" + price);
            cln.firstElementChild.innerHTML = title;
            cln.firstElementChild.nextElementSibling.innerHTML = price;
            cln.firstElementChild.nextElementSibling.nextElementSibling.firstElementChild.firstElementChild.setAttribute("value", quantity);
            cln.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML = total;
            document.getElementById("itemsInCart").appendChild(cln);
        }
    }
}

function checkOut() {
    window.location.href = "catalog.jsp";
}

function updateCart() {
    for (x = 0; x < (document.getElementsByClassName("quantityTextBox").length - 1); x++) {
        var u = document.getElementsByClassName("quantityTextBox")[x];
        var y = document.getElementsByClassName("itemContainer")[x];
        var newQuan = (u.value);
        var itemName = (y.getAttribute("id"));
        var cartCookie = getCookie("cart");
        increaseQuantity(cartCookie, itemName, newQuan);
        window.location.href = "cart.jsp";
    }
}

function setSizes(){
    //alert("this ran");
    var body = document.body, html = document.documentElement;
    var h = Math.max( body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight );
    var s = document.getElementById("headerPic").width;
    s=s+5;
    s=s+"px";
    document.getElementById("headerTitleDiv").style.marginLeft=s;
    s = document.getElementById("header").offsetHeight;
    s = s + document.getElementsByClassName("userNav")[0].offsetHeight;
    var t=s+"px";
    document.getElementById("genNav").style.paddingTop=t;
    //document.getElementById("pageContent").style.paddingTop=t;
    document.getElementById("pageContent").style.height=(((h-s)-25)+"px");
    document.getElementById("main").style.height=(((h-s)-25)+"px");
    document.getElementById("footer").style.bottom="0"; 
    /*document.getElementById("main").style.paddingTop=t;
    var v = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);
    if(v==="catalog.jsp"){
        var u=s+25;
        u=u+"px";
        document.getElementById("itemHolder").style.paddingTop=u;
    }*/
    
    /*var f = h-25;
    f=f+"px";
    //alert(f);
    document.getElementById("footer").style.paddingTop=f;
    document.getElementById("footer").style.height=h;*/
    
    
    
    /*s = document.getElementById("footer").offsetHeight;
    t = s+"px";
    document.getElementById("pageContent").style.paddingBottom=t;
    document.getElementById("genNav").style.paddingBottom=t;
    document.getElementById("main").style.paddingBottom=t;
    /*alert(t);
    /*t = (document.getElementById("pageContent").offsetHeight);
    t = t-s;
    //alert(t);
    t=t+"px";
    document.getElementById("pageContent").style.minHeight = t;
    document.getElementById("genNav").style.height = t;
    //document.getElementById("genNav").style.height = window.innerHeight;*/
}
/*
function scroll () {
 //alert("scroll event detected! " + window.pageXOffset + " " + window.pageYOffset);
 if(window.pageYOffset >= document.getElementById("header").offsetHeight){
    document.getElementsByClassName("userNav")[0].style.id="userNav2";
 }
 else{
    document.getElementsByClassName("userNav")[0].style.id="userNav1";
 }
 // note: you can use window.innerWidth and window.innerHeight to access the width and height of the viewing area
}
*/