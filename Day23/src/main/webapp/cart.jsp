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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
</head>
<body>

<section class="cart-section">

    <div class="cart-container">
        <h2 class="shopping-cart-text">Shopping Cart</h2>

        <%
            if (count > 0) {
                out.println("        <div class=\"cart-header\">\n" +
                        "            <div class=\"cart-div-image\">\n" +
                        "                <h6>IMAGE</h6>\n" +
                        "            </div>\n" +
                        "            <div class=\"cart-div-description\">\n" +
                        "                <h6>DESCRIPTION</h6>\n" +
                        "            </div>\n" +
                        "            <div class=\"cart-div-unit-price\">\n" +
                        "                <h6>UNIT PRICE</h6>\n" +
                        "            </div>\n" +
                        "            <div class=\"cart-div-quantity\">\n" +
                        "                <h6>Quantity</h6>\n" +
                        "            </div>\n" +
                        "            <div class=\"cart-div-sub-total\">\n" +
                        "                <h6>SUBTOTAL</h6>\n" +
                        "            </div>\n" +
                        "            <div class=\"cart-div-action\">\n" +
                        "                <h6>REMOVE</h6>\n" +
                        "            </div>\n" +
                        "        </div>");
            }
        %>


        <Shop:CartList/>
        <%
            if (count == 0) {
                out.println("        <div class=\"empty-cart\">\n" +
                        "            <h1>Your cart is empty</h1>\n" +
                        "            <a href=\"welcome.jsp#catogeries\" class=\"hero-button\">Shop Now</a>\n" +
                        "\n" +
                        "        </div>");
            }

        %>

    </div>
</section>
</body>
</html>