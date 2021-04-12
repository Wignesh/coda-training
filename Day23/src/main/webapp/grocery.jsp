<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
<%--&ndash;%&gt;--%>
<%@ include file="Nav.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Dairy</title>
</head>

<body>
<section id="products" class="product-section">
    <form action="shop.do" method="POST" id="main-form">
        <h2 class="category-text">Dairy</h2>
            <input type="hidden" name="formId" value="Shop"/>
            <input type="hidden" name="shopId" value="shop3"/>
        <div class="product-items">
            <Shop:ItemList category="DAIRY"/>
        </div>
    </form>
</section>

<div class="large-boy">

</div>
</body>

</html>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Groceries</title>--%>
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
<%--            border-top: 4px solid #ad562c;--%>
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
<%--        <h1 class="title">Groceries</h1>--%>
<%--        <input type="hidden" name="formId" value="Shop"/>--%>
<%--        <input type="hidden" name="shopId" value="shop3"/>--%>
<%--        <button type="submit" class="addTo">Add to Cart</button>--%>
<%--    </header>--%>
<%--    <div class="items">--%>
<%--        <Shop:ItemList  category="GROCERY"/>--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>