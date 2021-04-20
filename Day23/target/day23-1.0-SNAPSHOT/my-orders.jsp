<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 12/04/21
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Nav.jsp" %>
<%
    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders</title>
    <style>
        .my-orders-container {
            display: flex;
            flex-direction: column;
            width: 100%;
        }

        .myorder-row-header {
            display: flex;
            align-items: center;
            justify-content: space-evenly;
            width: 100%;
            background-color: #f9f9f9;
            box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.2);
            margin-top: 10px;
            color: #222;
            font-size: 1.5rem;
            font-weight: bold;
            font-family: "Poppins", sans-serif;
        }

        .myorder-row-header h5 {
            width: 14%;
            text-align: center;
        }

        .my-order-row {
            display: flex;
            width: 100%;
            background-color: #ffffff;
            box-shadow: 0 0 1px 0 rgba(0, 0, 0, 0.2);
            /* border: 1px solid #ddd; */
            border-top: 0;
            color: #222;
            font-size: 1.2rem;
            font-weight: bold;
            font-family: "Poppins", sans-serif;
            align-items: center;

            justify-content: space-evenly
        }

        .my-order-row h5 {
            width: 14%;
            text-align: center;
        }

        .view-invoice {
            background-color: #FFFFFF;
            cursor: pointer;
            outline: none;
            border: none;
        }

        .view-invoice:active {
            outline: none;
            border: none;
        }

        .view-invoice:focus {
            outline: none;
            border: none;
        }
    </style>
</head>
<body>
<section class="my-order-section">
    <h2 class="shopping-cart-text">My Orders</h2>
    <div class="my-orders-container">
        <div class="myorder-row-header">
            <h5>INVOICE ID</h5>
            <h5>DATE</h5>
            <h5>ITEMS</h5>
            <h5>AMOUNT</h5>
            <h5>VIEW</h5>
            <h5>PDF</h5>
            <h5>EXCEL</h5>
        </div>

        <Shop:MyOrders/>
    </div>
</section>
</body>
</html>
