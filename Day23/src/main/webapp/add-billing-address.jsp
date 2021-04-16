<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 12/04/21
  Time: 9:34 PM
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
    <title>Add Billing Address</title>
</head>
<body>
<section class="add-billing-address-section" id="add-billing-address">
    <h1 class="shopping-cart-text">Add Billing Address To Proceed</h1>
    <form action="add-biiling-address.do" method="GET">
        <div class="checkout-container">
            <div class="checkout-left-pane">
                <input type="hidden" name="formId" value="Address">
                <input type="hidden" name="actionId" value="add">
                <div class="checkout-input-group">
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="firstName">First Name </label>
                        <input required placeholder="Firstname" class="checkout-input" type="text" name="firstName"
                               id="firstName">
                    </div>
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="lastName">Last Name</label>
                        <input required placeholder="Lastname" class="checkout-input" type="text" name="lastName"
                               id="lastName">
                    </div>
                </div>

                <div class="checkout-input-group">
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="streetAddress1">Street Address</label>
                        <input class="checkout-input" name="streetAddress1" type="text" id="streetAddress1"
                               placeholder="House number and street name">
                    </div>
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="streetAddress2">&emsp;</label>
                        <input class="checkout-input" type="text" name="streetAddress2" id="streetAddress2"
                               placeholder="Apartment, suite, unit etc.">
                    </div>
                </div>


                <div class="checkout-input-group">
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="region">Region / State</label>
                        <input required placeholder="Region / State" class="checkout-input" type="text" name="region"
                               id="region">
                    </div>
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="district">Town / City</label>
                        <input required placeholder="Town / City" class="checkout-input" type="text" name="district"
                               id="district">
                    </div>
                </div>
                <div class="checkout-input-group">
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="phone">Phone</label>
                        <input required placeholder="Phone" pattern="[789][0-9]{9}" class="checkout-input" type="tel"
                               id="phone" name="phone">
                    </div>
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="email">Email</label>
                        <input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required placeholder="Email"
                               class="checkout-input" type="email" id="email" name="email">
                    </div>
                </div>
                <div class="checkout-input-group">
                    <div class="checkout-input-half-container">
                        <label class="checkout-input-label" for="zip"> Zip / Postal Code</label>
                        <input required placeholder=" Zip / Postal Code" pattern="[0-9]{6}" class="checkout-input"
                               type="text" id="zip" name="zip">
                    </div>
                </div>
                <button type="submit" class="cart-button add-address-button"><i
                        class="fa fa-plus" aria-hidden="true"></i> Add Address
                </button>

            </div>


        </div>
    </form>

</section>
</body>
</html>
