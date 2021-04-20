<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%@ page import="java.util.*" %>
<%@ page import="ga.veee.day23.daopack.BillingAddressDAOImpl" %>
<%@ page import="ga.veee.day23.daopack.BillingAddressDTO" %>
<%@ page import="ga.veee.day23.daopack.UserDTO" %>
<%@ page import="ga.veee.day23.daopack.UserDAOImpl" %><%--
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
</head>
<body>
<%
    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    } else {
        int cartItemCount = 0;
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (!whiteList.contains(name)) {
                cartItemCount += 1;
            }
        }
        if (cartItemCount == 0)
            response.sendRedirect("index.jsp");
    }
%>
<section class="checkout-section" id="checkout">
    <h1 class="shopping-cart-text">Billing Details</h1>
    <form action="processOrder.do" method="GET" id="process-order" name="process-order">

        <div class="checkout-container">
            <div class="checkout-left-pane">
                <div class="delivery-addresses">
                    <form action=""></form>
                    <%
                        if (session.getAttribute("uname") != null) {
                            java.util.Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
                            UserDAOImpl userDaoImpl = UserDAOImpl.getUserDaoImpl(dbConfigProp);
                            String uname = session.getAttribute("uname").toString();
                            UserDTO userDTO = userDaoImpl.findByName(uname);
                            int cutId = userDTO.getUid();
                            BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
                            Set<BillingAddressDTO> addresses = billingAddressDAOImpl.findByCustomerId(cutId);
                            if (addresses.size() == 0) {
                                response.sendRedirect("add-billing-address.jsp");
                            }
                            for (BillingAddressDTO address : addresses) {
                                out.println(String.format("                    <div class=\"deleivery-address\">\n" +
                                        "                        <div class=\"delivery-address-info\">\n" +
                                        "                            <h4>%s %s</h4>\n" +
                                        "                            <p>%s</p>\n" +
                                        "                            <p>%s</p>\n" +
                                        "                            <p>%s, %s %s</p>\n" +
                                        "                            <p>%s</p>\n" +
                                        "                            <p>%s</p>\n" +
                                        "                            <p>India</p>\n" +
                                        "                        </div>\n" +
                                        "                        <div class=\"delivery-address-use\">\n" +
                                        "                            <button type=\"button\"\n" +
                                        "                                    onclick=\"this.parentNode.parentNode.querySelector('input[type=radio]').checked ^= 1;\"\n" +
                                        "                                    class=\"cart-button deliver-button\"><i class=\"fa fa-location-arrow\"\n" +
                                        "                                                                          aria-hidden=\"true\"></i>\n" +
                                        "                                Select this address\n" +
                                        "                            </button>\n" +
                                        "                        </div>\n" +
                                        "                        <div class=\"delivery-address-actions\">\n" +
                                        "                            \n" +
                                        "\n" +
                                        "                            <form action=\"edit-billing-address.jsp\" method=\"POST\"  id=\"edit-bill-%s\">\n" +
                                        "                                <input form=\"edit-bill-%s\" type=\"hidden\" name=\"addressId\" value=\"%s\">\n" +
                                        "                                <button type=\"submit\" form=\"edit-bill-%s\" class=\"cart-button deliver-button\"><i\n" +
                                        "                                        class=\"fa fa-pencil\" aria-hidden=\"true\"></i>\n" +
                                        "                                    Edit\n" +
                                        "                                </button>\n" +
                                        "                            </form>\n" +
                                        "\n" +
                                        "                            <form action=\"delete-billing-address.jsp\" method=\"POST\" id=\"delete-bill-%s\">\n" +
                                        "                                <input form=\"delete-bill-%s\" type=\"hidden\" name=\"addressId\" value=\"%s\">\n" +
                                        "                                <button type=\"submit\" form=\"delete-bill-%s\" class=\"cart-button deliver-button\"><i\n" +
                                        "                                        class=\"fa fa-trash-o\" aria-hidden=\"true\"></i>\n" +
                                        "                                    Delete\n" +
                                        "                                </button>\n" +
                                        "                            </form>\n" +
                                        "\n" +
                                        "                        </div>\n" +
                                        "                        <input required form=\"process-order\" class=\" delivery-address-radio hidden-radio\" type=\"radio\" value=\"%s\" name=\"addressId\">\n" +
                                        "                    </div>", address.getFname(), address.getLaname(), address.getAddress1(), address.getAddress2(), address.getTown(), address.getRegion(), address.getZip(), address.getPhone(), address.getEmail(), address.getId(), address.getId(), address.getId(), address.getId(), address.getId(), address.getId(), address.getId(), address.getId(), address.getId()));
                            }
                        }

                    %>


                </div>

                <form action="add-biiling-address.do" method="POST" id="add-bill-address" name="add-bill-address">

                    <input form="add-bill-address" type="hidden" name="formId" value="Address">
                    <input form="add-bill-address" type="hidden" name="actionId" value="add">
                    <h1 class="shopping-cart-text">Add New Address</h1>

                    <div class="checkout-input-group">
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="firstName">First Name </label>
                            <input form="add-bill-address" required placeholder="Firstname" class="checkout-input"
                                   type="text"
                                   name="firstName" id="firstName">
                        </div>
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="lastName">Last Name</label>
                            <input form="add-bill-address" required placeholder="Lastname" class="checkout-input"
                                   type="text"
                                   name="lastName" id="lastName">
                        </div>
                    </div>

                    <div class="checkout-input-group">
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="streetAddress1">Street Address</label>
                            <input form="add-bill-address" class="checkout-input" name="streetAddress1" type="text"
                                   id="streetAddress1"
                                   placeholder="House number and street name">
                        </div>
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="streetAddress2">&emsp;</label>
                            <input form="add-bill-address" class="checkout-input" type="text" name="streetAddress2"
                                   id="streetAddress2"
                                   placeholder="Apartment, suite, unit etc.">
                        </div>
                    </div>


                    <div class="checkout-input-group">
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="region">Region / State</label>
                            <input form="add-bill-address" required placeholder="Region / State" class="checkout-input"
                                   type="text"
                                   name="region" id="region">
                        </div>
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="district">Town / City</label>
                            <input form="add-bill-address" required placeholder="Town / City" class="checkout-input"
                                   type="text"
                                   name="district" id="district">
                        </div>
                    </div>
                    <div class="checkout-input-group">
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="phone">Phone</label>
                            <input form="add-bill-address" required placeholder="Phone" pattern="[789][0-9]{9}"
                                   class="checkout-input"
                                   type="tel" id="phone" name="phone">
                        </div>
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="email">Email</label>
                            <input form="add-bill-address" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required
                                   placeholder="Email"
                                   class="checkout-input" type="email" id="email" name="email">
                        </div>
                    </div>
                    <div class="checkout-input-group">
                        <div class="checkout-input-half-container">
                            <label class="checkout-input-label" for="zip"> Zip / Postal Code</label>
                            <input form="add-bill-address" required placeholder=" Zip / Postal Code" pattern="[0-9]{6}"
                                   class="checkout-input" type="text" id="zip" name="zip">
                        </div>
                    </div>

                    <button form="add-bill-address" type="submit" class="cart-button add-address-button"><i
                            class="fa fa-plus" aria-hidden="true"></i> Add Address
                    </button>


                </form>

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

                    <input type="hidden" name="formId" value="Order" form="process-order">

                    <button form="process-order" type="submit"
                            class="cart-button cart-button-checkout place-order-button"><i
                            class="fa fa-check" aria-hidden="true"></i> Place Order
                    </button>
                </div>
            </div>
        </div>
    </form>

</section>
</body>
</html>
