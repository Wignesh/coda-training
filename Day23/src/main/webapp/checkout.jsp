<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 12/04/21
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Nav.jsp" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
<%
    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    } else {
        int cartItemCount = 0;
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            if (!name.equals("uname")) {
                cartItemCount += 1;
            }
        }
        if (cartItemCount == 0)
            response.sendRedirect("index.jsp");
    }
%>
<section class="checkout-section" id="checkout">
    <h1>Billing Details</h1>
    <form action="process-order.jsp" method="GET">

        <div class="checkout-container">
            <div class="checkout-left-pane">
                <div class="checkout-nameContainer">
                    <div>
                        <label class="checkout-input-label" for="firstName">First Name </label>
                        <input class="checkout-input" type="text" id="firstName">
                    </div>
                    <div>
                        <label class="checkout-input-label" for="lastName">Last Name</label>
                        <input class="checkout-input" type="text" name="lastName">
                    </div>
                </div>

                <div class="checkout-nameContainer">
                    <div>
                        <label class="checkout-input-label" for="streetAddress1">Street Address</label>
                        <input class="checkout-input" type="text" id="streetAddress1"
                               placeholder="House number and street name">

                    </div>
                    <div>
                        <label class="checkout-input-label" for="streetAddress2">&emsp;</label>

                        <input class="checkout-input" type="text" id="streetAddress2"
                               placeholder="Apartment, suite, unit etc.">
                    </div>
                </div>


                <div class="checkout-nameContainer">
                    <div>
                        <label class="checkout-input-label" for="region">Region/State</label>
                        <select class="checkout-input" name="region" id="region">
                            <option value="TAMILNADU">TAMILNADU</option>
                        </select>
                    </div>
                    <div>
                        <label class="checkout-input-label" for="District">District</label>
                        <select class="checkout-input" name="district" id="district">
                            <option value="Coimbatore">Coimbatore</option>
                            <option value="Chennai">Chennai</option>
                        </select>
                    </div>
                </div>
                <div class="checkout-nameContainer">
                    <div>
                        <label class="checkout-input-label" for="phone">Phone</label>
                        <input class="checkout-input" type="text" id="phone">
                    </div>
                    <div>
                        <label class="checkout-input-label" for="email">Email</label>
                        <input class="checkout-input" type="email" id="email">
                    </div>
                </div>


            </div>
            <div class="checkout-right-pane">
                <div class="ckeckout-right-container">

                    <div class="ckeckout-right-header checkout-border-bottom ">
                        <div>
                            <h3>Product</h3>
                        </div>
                        <div>
                            <h3>Price</h3>
                        </div>
                    </div>

                    <Shop:OrderList/>


                    <button type="submit" class="cart-button cart-button-checkout place-order-button"><i
                            class="fa fa-check" aria-hidden="true"></i> Place Order
                    </button>
                </div>
            </div>
        </div>
    </form>

</section>
</body>
</html>
