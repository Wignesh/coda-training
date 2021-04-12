<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="Nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cart</title>
</head>
<body>

<section class="cart-section">

    <div class="cart-container">
        <h2 class="shopping-cart-text">Shopping Cart</h2>

        <div class="cart-header">
            <div class="cart-div-image">
                <h6>IMAGE</h6>
            </div>
            <div class="cart-div-description">
                <h6>DESCRIPTION</h6>
            </div>
            <div class="cart-div-unit-price">
                <h6>UNIT PRICE</h6>
            </div>
            <div class="cart-div-quantity">
                <h6>Quantity</h6>
            </div>
            <div class="cart-div-sub-total">
                <h6>SUBTOTAL</h6>
            </div>
            <div class="cart-div-action">
                <h6>REMOVE</h6>
            </div>
        </div>

        <Shop:CartList/>

    </div>
</section>
<%--<a href="clear-cart.jsp">Clear Cart</a>--%>
</body>
</html>