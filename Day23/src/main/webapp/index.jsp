

<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld"%>
<%@ page import="ga.veee.day23.daopack.ItemDAOImpl" %>
<%@ page import="ga.veee.day23.daopack.ItemDTO" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="Nav.jsp" %>

<!DOCTYPE html>
<%@page import="java.util.ResourceBundle" buffer="8kb" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Farmiest!</title>
</head>
<%
    ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
    if(rb == null){
        rb = ResourceBundle.getBundle("ga.veee.day23.control.Dictionary", new Locale("en"));
    }
%>
<body>
<section id="home" class="hero-container">
    <div class="hero-flex">
        <div class="hero-left-box">
            <h1><%=rb.getString("hero1") %> <span><%=rb.getString("hero2") %></span><br/><%=rb.getString("hero3") %></h1>
            <p>100 Healthy & Affortable</p>
            <button class="hero-button">Shop Now</button>
        </div>
        <div class="hero-round-bg"></div>
        <div class="hero-right-box">
            <img class="hero-image" src="https://i.imgur.com/wrqF9dW.png" alt=""/>
        </div>
        <img class="hero-leaf1" src="https://i.imgur.com/3uScmSk.png" alt=""/>
        <img class="hero-leaf2" src="https://i.imgur.com/3uScmSk.png" alt=""/>
        <img class="hero-leaf3" src="https://i.imgur.com/3uScmSk.png" alt=""/>
    </div>
    <div class="hero-card">
        <div class="hero-card-item">
            <img src="//i.imgur.com/LbuirYG.png"/>
            <div class="hero-card-item-info">
                <h2>Grocery</h1>
                    <p>Fresh grocery delivered</p>
            </div>
        </div>
        <div class="hero-card-item">
            <img src="//i.imgur.com/jMraJ3M.png"/>
            <div class="hero-card-item-info">
                <h2>Fruits</h1>
                    <p>Fresh fruits delivered</p>
            </div>
        </div>
        <div class="hero-card-item">
            <img src="//i.imgur.com/JsicNkv.png"/>
            <div class="hero-card-item-info">
                <h2>Cart Value</h1>
                    <p>Review your cart</p>
            </div>
        </div>
        <div class="hero-card-item">
            <img src="//i.imgur.com/ZMUQK9A.png"/>
            <div class="hero-card-item-info">
                <h2>Support</h1>
                    <p>Concern and quries</p>
            </div>
        </div>
    </div>
</section>

<section id="catogeries" class="category-section">
    <h2 class="category-text">Category List</h2>
    <div class="category-container">
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/WlqIF5A.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Bakery</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/16tkTxW.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Fruits</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/ilHGrcO.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Snaks</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/b5UiCNZ.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Vegetables</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/s4MXDaJ.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Spices</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
        <div class="category">
            <img class="category-image" src="https://i.imgur.com/qj32GAV.png" alt="">
            <div class="category-content">
                <h1 class="category-title">Beverages</h1>
                <a class="category-button" href="#">View All</a>
            </div>
        </div>
    </div>

</section>
<section id="products" class="product-section">
    <form action="shop.do" method="POST" id="main-form">

        <h2 class="category-text">Product List</h2>
        <input type="hidden" name="formId" value="Shop"/>
        <input type="hidden" name="shopId" value="shop1"/>
        <div class="product-items">
            <Shop:ItemList category="FRUIT"/>
        </div>
    </form>
</section>
<section id="about" class="about-container">
    <div class="about-1">
        <h2 class="about-text">About Us</h2>
        <h1 class="about-title">
            We make <br>Organic Food In <br> Market
        </h1>
        <p style="border-bottom:4px solid #64D7C6; width: 4rem;"></p>
        <p class="about-title-desc">Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua. Ut enim ad minim veniam.<br>
            Excepteur sint occaecat cupidatat non proident,<br> sunt in culpa qui officia deserunt mollit anim id est
            laborum.
        </p>
        <img style="width: 15rem;" src="//i.imgur.com/o5M9z2B.png" alt="">
    </div>
    <div class="about-2">
        <img width="100%" src="//i.imgur.com/n6QAWVg.png" alt="">
    </div>
    <div class="about-3">
        <img width="100%" src="//i.imgur.com/9oQjJi4.png" alt="">
    </div>
</section>
<div class="large-boy">

</div>
</body>

</html>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home</title>--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, Helvetica, sans-serif;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            background-color: #f7f7f7;--%>
<%--        }--%>

<%--        * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        input[type="number"] {--%>
<%--            -webkit-appearance: textfield;--%>
<%--            -moz-appearance: textfield;--%>
<%--            appearance: textfield;--%>
<%--        }--%>

<%--        input[type="number"]::-webkit-inner-spin-button,--%>
<%--        input[type="number"]::-webkit-outer-spin-button {--%>
<%--            -webkit-appearance: none;--%>
<%--        }--%>

<%--        .number-input {--%>
<%--            border: 2px solid #ddd;--%>
<%--            display: inline-flex;--%>

<%--            max-height: 42px;--%>
<%--            min-height: 42px;--%>
<%--        }--%>

<%--        .number-input,--%>
<%--        .number-input * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        .number-input button {--%>
<%--            outline: none;--%>
<%--            -webkit-appearance: none;--%>
<%--            background-color: transparent;--%>
<%--            border: none;--%>
<%--            align-items: center;--%>
<%--            justify-content: center;--%>
<%--            width: 1.5rem;--%>
<%--            max-height: 42px;--%>
<%--            min-height: 42px;--%>
<%--            cursor: pointer;--%>
<%--            margin: 0;--%>
<%--            position: relative;--%>
<%--        }--%>

<%--        .number-input button:before,--%>
<%--        .number-input button:after {--%>
<%--            display: inline-block;--%>
<%--            position: absolute;--%>
<%--            content: "";--%>
<%--            width: 1rem;--%>
<%--            height: 2px;--%>
<%--            background-color: #212121;--%>
<%--            transform: translate(-50%, -50%);--%>
<%--        }--%>

<%--        .number-input button.plus:after {--%>
<%--            transform: translate(-50%, -50%) rotate(90deg);--%>
<%--        }--%>

<%--        .number-input input[type="number"] {--%>
<%--            font-family: sans-serif;--%>
<%--            max-width: 5rem;--%>
<%--            padding: 0.2rem;--%>
<%--            margin-top: -2px;--%>
<%--            border: solid #ddd;--%>
<%--            border-width: 2px 2px;--%>
<%--            font-size: 1rem;--%>
<%--            max-height: 42px;--%>
<%--            min-height: 42px;--%>
<%--            font-weight: bold;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .header {--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            justify-content: space-between;--%>
<%--            width: 90%;--%>
<%--            margin: auto;--%>
<%--            margin-top: 12px;--%>
<%--        }--%>

<%--        .items {--%>
<%--            display: flex;--%>
<%--            flex-wrap: wrap;--%>
<%--            width: 90%;--%>
<%--            margin: auto;--%>
<%--        }--%>

<%--        .item-image {--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            align-content: center;--%>
<%--        }--%>

<%--        .item {--%>
<%--            padding: 1%;--%>
<%--            flex-grow: 1;--%>
<%--            display: flex;--%>
<%--            flex-direction: column;--%>
<%--            box-shadow: 0 0px 2px 0 rgba(0, 0, 0, 0.2);--%>
<%--            transition: 0.3s;--%>
<%--            background-color: #fff;--%>
<%--            min-width: 200px;--%>
<%--            max-width: 200px;--%>
<%--            margin: 6px;--%>
<%--            margin-bottom: 8px;--%>
<%--        }--%>

<%--        .item:hover {--%>
<%--            box-shadow: 0 16px 16px 0 rgba(0, 0, 0, 0.2);--%>
<%--        }--%>

<%--        .item-info {--%>
<%--            margin: auto;--%>
<%--            width: 100%;--%>
<%--            min-height: 200px;--%>
<%--            max-height: 200px;--%>
<%--        }--%>

<%--        .image {--%>
<%--            width: 100px;--%>
<%--            height: 100px;--%>
<%--            margin: auto;--%>
<%--        }--%>

<%--        .checked {--%>
<%--            color: orange;--%>
<%--        }--%>

<%--        .item-title {--%>
<%--            text-align: center;--%>
<%--            margin: 10px 0;--%>
<%--        }--%>

<%--        .item-price {--%>
<%--            text-align: center;--%>
<%--            margin: 10px 0;--%>
<%--        }--%>

<%--        .rating {--%>
<%--            text-align: center;--%>
<%--            margin: 10px 0;--%>
<%--        }--%>

<%--        .qty {--%>
<%--            margin: 0 0;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .add {--%>
<%--            background-color: #fff;--%>
<%--            color: #50b07e;--%>
<%--            font-size: 14px;--%>
<%--            padding: 14px 20px;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            width: 100px;--%>
<%--            margin-top: 10px;--%>
<%--            border-radius: 10%;--%>
<%--        }--%>

<%--        .add:hover {--%>
<%--            opacity: 1;--%>
<%--        }--%>

<%--        .add:focus {--%>
<%--            opacity: 1;--%>
<%--            outline: none;--%>
<%--        }--%>

<%--        .title {--%>
<%--            color: #2e2222;--%>
<%--        }--%>

<%--        .addTo {--%>
<%--            background-color: #759c6c;--%>
<%--            color: #fff;--%>
<%--            font-size: 14px;--%>
<%--            padding: 14px 20px;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            opacity: 0.9;--%>
<%--        }--%>

<%--        .addTo:hover {--%>
<%--            opacity: 1;--%>
<%--        }--%>

<%--        .addTo:focus {--%>
<%--            opacity: 1;--%>
<%--            outline: none;--%>
<%--        }--%>
<%--        .header h1 {--%>
<%--            font-size: 28px;--%>
<%--            font-weight: 500;--%>
<%--            padding-bottom: 15px;--%>
<%--            position: relative;--%>
<%--        }--%>
<%--        .header h1:before {--%>
<%--            content: "";--%>
<%--            position: absolute;--%>
<%--            left: 0;--%>
<%--            bottom: 0;--%>
<%--            height: 5px;--%>
<%--            width: 65px;--%>
<%--            background-color: #111;--%>
<%--        }--%>
<%--        .header h1:after {--%>
<%--            content: "";--%>
<%--            position: absolute;--%>
<%--            left: 0;--%>
<%--            bottom: 2px;--%>
<%--            height: 1px;--%>
<%--            width: 95%;--%>
<%--            max-width: 255px;--%>
<%--            background-color: #333;--%>
<%--        }--%>
<%--        .grocery {--%>
<%--            border-top: 4px solid #ad562c !important;--%>
<%--        }--%>
<%--        .vegetable {--%>
<%--            border-top: 4px solid #5d9050 !important;--%>
<%--        }--%>
<%--        .fruit {--%>
<%--            border-top: 4px solid crimson !important;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@ include file="Nav.jsp" %>--%>
<%--<form action="shop.do" method="POST" id="main-form">--%>
<%--    <header class="header">--%>
<%--        <h1 class="title">Shop All</h1>--%>
<%--        <input type="hidden" name="formId" value="Shop"/>--%>
<%--        <input type="hidden" name="shopId" value="shop3"/>--%>
<%--        <button type="submit" class="addTo">Add to Cart</button>--%>
<%--    </header>--%>
<%--    <div class="items">--%>
<%--        <Shop:ItemList  category="*"/>--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8" />--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
<%--    <title>Home</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, Helvetica, sans-serif;--%>
<%--            background-image: url("https://login.oracle.com/mysso/sso_loginui/sso-f17v2-bgimg.jpg");--%>
<%--        }--%>
<%--        * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>
<%--        hr {--%>
<%--            border: 1px double #f1f1f1;--%>
<%--            margin-bottom: 25px;--%>
<%--        }--%>
<%--        .login-button,--%>
<%--        .signup-button {--%>
<%--            background-color: #759c6c;--%>
<%--            color: white;--%>
<%--            font-size: 16px;--%>
<%--            padding: 14px 20px;--%>
<%--            margin: 40px 20px;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            opacity: 0.9;--%>
<%--        }--%>
<%--        .login-button:hover,--%>
<%--        .signup-button:hover {--%>
<%--            opacity: 1;--%>
<%--        }--%>
<%--        .signup-button {--%>
<%--            background-color: #000000;--%>
<%--        }--%>
<%--        .forms {--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            justify-content: space-around;--%>
<%--        }--%>

<%--        .container {--%>
<%--            border: 6px solid;--%>
<%--            border-color: #f1f1f1;--%>
<%--            background-color: #fff;--%>
<%--            border-radius: 2%;--%>
<%--            width: 30%;--%>
<%--            margin: auto;--%>
<%--            margin-top: 30px;--%>
<%--            padding: 24px;--%>
<%--        }--%>
<%--        .welcome {--%>
<%--            font-size: xx-large;--%>
<%--            margin: 0;--%>
<%--            width: 100%;--%>
<%--            text-align: center;--%>
<%--            text-decoration: underline wavy;--%>
<%--            text-underline-position: under;--%>
<%--        }--%>
<%--        .link {--%>
<%--            color: #ad562c;--%>
<%--            background: none;--%>
<%--            border: none;--%>
<%--            padding: 0;--%>
<%--            font: inherit;--%>
<%--            cursor: pointer;--%>
<%--            outline: inherit;--%>
<%--            text-decoration: underline;--%>
<%--        }--%>

<%--        .help {--%>
<%--            display: block;--%>
<%--            margin-left: auto;--%>
<%--            margin-right: auto;--%>
<%--            margin-top: 12px;--%>
<%--        }--%>

<%--        /* Smartphones (portrait and landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 98%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (portrait and landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: landscape) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (portrait) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: portrait) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* Desktops and laptops ----------- */--%>
<%--        @media only screen and (min-width: 1224px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 30%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* Large screens ----------- */--%>
<%--        @media only screen and (min-width: 1824px) {--%>
<%--            .container {--%>
<%--                width: 40%;--%>
<%--            }--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h3 class="welcome">Welcome!</h3>--%>
<%--    <div class="forms">--%>
<%--        <form action="auth.do" method="POST">--%>
<%--            <input type="hidden" name="formId" value="Home" />--%>
<%--            <input type="hidden" name="actionId" value="login" />--%>
<%--            <button type="submit" class="login-button">Sign In</button>--%>
<%--        </form>--%>

<%--        <form action="auth.do" method="POST">--%>
<%--            <input type="hidden" name="formId" value="Home" />--%>
<%--            <input type="hidden" name="actionId" value="register" />--%>
<%--            <button type="submit" class="signup-button">Sign Up</button>--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <button type="button" class="link help">Need Help?</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

