/* 
 * Eric Knowles
 * Chirag Patel
 * Assignement 2
 * ITIS-4166
 */
window.onload = function () {
    setSizes();
};

window.onresize = function () {
    setSizes();
};

function setSizes() {
    var body = document.body, html = document.documentElement;
    var h = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
    var s = document.getElementById("headerPic").width;
    s = s + 5;
    s = s + "px";
    document.getElementById("headerTitleDiv").style.marginLeft = s;
    s = document.getElementById("header").offsetHeight;
    s = s + document.getElementsByClassName("userNav")[0].offsetHeight;
    var t = s + "px";
    document.getElementById("genNav").style.paddingTop = t;
    document.getElementById("pageContent").style.height = (((h - s) - 25) + "px");
    document.getElementById("main").style.height = (((h - s) - 25) + "px");
    document.getElementById("footer").style.bottom = "0";
}