<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 13/04/21
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Placed</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="style.css"/>
    <style>
        body {
            overflow: hidden;
            background-color: #306D84;
        }

        .order-placed-container {
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .order-placed-icon {
            color: wheat;
            font-size: 10rem;
            margin-bottom: 3rem;
            margin-top: 3rem;
        }

        .order-placed-amount {
            color: antiquewhite;
            font-size: 4rem;
            font-weight: bolder;
            margin-bottom: 1rem;
            font-family: "Rubik", sans-serif;
        }

        .order-payment-text {
            color: white;
            font-size: 1.2rem;
            text-align: center;
            font-weight: bold;
            font-family: "Poppins", sans-serif;
            line-height: 1;
        }

        .order-actions {
            display: flex;
            flex-direction: column;
            padding-top: 4rem;
        }

        .order-actions a {
            text-decoration: none;
            color: #306D84;
            background-color: wheat;
            padding: 1rem 6rem;
            margin: .5rem;
            text-align: center;
            font-size: 1.2rem;
            font-weight: bold;
        }

        .order-actions a:hover {
            background-color: #eccc90;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }


    </style>
</head>
<body>
<section>
    <div class="order-placed-container">
        <i class="fa fa-check-circle order-placed-icon"></i>
        <div class="order-placed-amount">
        </div>
        <div class="order-payment-text">
            <p>Your payment is complete.</p>
            <p>Please check your mail for invoice</p>
            <p>Chek your orders in My Orders section</p>
        </div>
        <div class="order-actions">
            <a href="welcome.jsp" class="order-continue-shopping">Continue Shopping</a>
            <a href="my-orders.jsp" class="order-my-orders-action">My Orders</a>
        </div>
    </div>
</section>
</body>
</html>
