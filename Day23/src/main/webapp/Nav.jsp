<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
    <script src="script.js"></script>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<nav>
    <ul class="nav-items">
        <li>
            <a class="nav-title" style="text-decoration: none;" href="welcome.jsp">
                <h1>Farmiest!</h1>
            </a>
        </li>
        <li class="nav-item"><a class="${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'welcome.jsp' ? 'active-nav-item' : ''} nav-link" href="welcome.jsp#">Home</a></li>
        <li class="nav-item nav-dropdown"><a class="nav-link hover-none" href="javascript:void(0)">Shop <i
                class="fa fa-chevron-circle-down" aria-hidden="true"></i></a>
            <div class="nav-dropdown-content">
                <a href="welcome.jsp#catogeries">Catogeries</a>
                <a href="veggie.jsp">Vegetables</a>
                <a href="fruits.jsp">Fruits</a>
                <a href="grocery.jsp">Dairy</a>
            </div>
        </li>


        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
        <li class="nav-item"><a class="nav-link" href="welcome.jsp#about">About</a></li>

        <li class="nav-item"
            style="<% out.print(session.getAttribute("uname") != null ? "display:block;" : "display:none;"); %>">
            <form action="logout.do" method="POST">
                <input type="hidden" name="formId" value="Logout"/>
                <input class="nav-link" type="submit" value="Logout"/>
            </form>
        </li>

        <li class="right-nav-item "><a href="<% out.print(session.getAttribute("uname") != null ? "profile.jsp" :  "login.jsp"); %>" class="nav-lg"><i class="fa fa-user" aria-hidden="true"></i>
            <% out.print(session.getAttribute("uname") != null ? "Hello, " + session.getAttribute("uname").toString().toUpperCase() : "My Account"); %>
        </a></li>

        <li class="right-nav-item "><a href= "<c:url value = "cart.jsp"/>" class="nav-lg"><i class="fa fa-shopping-cart"
                                                                         aria-hidden="true"></i></a></li>
        <li class="right-nav-item "><a href="#about" class="nav-lg"><i class="fa fa-heart" aria-hidden="true"></i></a>
        </li>
        <li class="right-nav-item">
            <form action="lang.do" method="POST" id="lang">
                <input type="hidden" name="formId" value="lang">
                <select name="language" onchange="this.parentNode.submit();" class="lang-select nav-lg">
                    <option value="en" <% out.print( session.getAttribute("lang") != null ? session.getAttribute("lang").toString().equals("en") ? "selected" : "123" : "456" ); %>>English</option>
                    <option value="ta" <% out.print( session.getAttribute("lang") != null ? session.getAttribute("lang").toString().equals("ta") ? "selected" : "123" : "456" ); %>>Tamil</option>
                    <option value="te" <% out.print( session.getAttribute("lang") != null ? session.getAttribute("lang").toString().equals("te") ? "selected" : "123" : "456" ); %>>Telugu</option>
                    <option value="hi" <% out.print( session.getAttribute("lang") != null ? session.getAttribute("lang").toString().equals("hi") ? "selected" : "123" : "456" ); %>>Hindi</option>
                </select>
            </form>
        </li>
    </ul>
</nav>
</body>
</html>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <title>Nav</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, Helvetica, sans-serif;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--        }--%>

<%--        * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        ul {--%>
<%--            list-style-type: none;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            overflow: hidden;--%>
<%--            background-color: #333;--%>
<%--            background-image: url("data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABLAAD/4QMxaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0NSA3OS4xNjM0OTksIDIwMTgvMDgvMTMtMTY6NDA6MjIgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkE2QTYxQUNDQUMyNzExRTlBMTcxOUEwRkREQkRDNEMzIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkE2QTYxQUNEQUMyNzExRTlBMTcxOUEwRkREQkRDNEMzIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QTZBNjFBQ0FBQzI3MTFFOUExNzE5QTBGRERCREM0QzMiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QTZBNjFBQ0JBQzI3MTFFOUExNzE5QTBGRERCREM0QzMiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAADAgICAgIDAgIDBQMD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");--%>
<%--            background-repeat: repeat-x;--%>
<%--            background-size: 30%;--%>
<%--            background-clip: padding-box;--%>
<%--        }--%>

<%--        li {--%>
<%--            float: left;--%>
<%--        }--%>

<%--        .active {--%>
<%--            border-bottom: 1px solid wheat !important;--%>
<%--        }--%>

<%--        .right {--%>
<%--            float: right;--%>
<%--        }--%>

<%--        .button {--%>
<%--            background-color: transparent;--%>
<%--            color: white;--%>
<%--            font-size: 16px;--%>
<%--            margin: 24px 24px;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            opacity: 0.9;--%>
<%--        }--%>

<%--        .button:hover {--%>
<%--            border-bottom: 1px solid wheat;--%>
<%--            outline: none;--%>
<%--        }--%>

<%--        .button:active {--%>
<%--            outline: none;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav>--%>
<%--    <ul>--%>
<%--        <li>--%>
<%--            <form action="home.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Home"/>--%>
<%--                <input type="hidden" name="actionId" value="home"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'welcome.jsp' ? 'active' : ''}"--%>
<%--                       type="submit" value="Home"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <form action="shopping.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Shop"/>--%>
<%--                <input type="hidden" name="shopId" value="nav-shop1"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'veggie.jsp' ? 'active' : ''}"--%>
<%--                       type="submit" value="Veggie"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <form action="shopping.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Shop"/>--%>
<%--                <input type="hidden" name="shopId" value="nav-shop2"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'fruits.jsp' ? 'active' : ''}"--%>
<%--                       type="submit" value="Fruits"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <form action="shopping.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Shop"/>--%>
<%--                <input type="hidden" name="shopId" value="nav-shop3"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'grocery.jsp' ? 'active' : ''}"--%>
<%--                       type="submit" value="Grocery"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li class="right">--%>
<%--            <form action="profile.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Home"/>--%>
<%--                <input type="hidden" name="actionId" value="profile"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'profile.jsp' ? 'active' : ''}"--%>
<%--                       type="submit"--%>
<%--                       value="Hello, <% out.print(session.getAttribute("uname").toString().toUpperCase()); %>"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li class="right">--%>
<%--            <form action="shopping.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Shop"/>--%>
<%--                <input type="hidden" name="shopId" value="cart"/>--%>
<%--                <input class="button ${pageContext.request.requestURI.substring( pageContext.request.requestURI.lastIndexOf('/') + 1) eq 'cart.jsp' ? 'active' : ''}"--%>
<%--                       type="submit" value="Cart"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li class="right">--%>
<%--            <form action="logout.do" method="POST">--%>
<%--                <input type="hidden" name="formId" value="Logout"/>--%>
<%--                <input class="button" type="submit" value="Logout"/>--%>
<%--            </form>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<%--</body>--%>
<%--</html>--%>

