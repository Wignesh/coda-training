<%@ page import="ga.veee.day23.daopack.BillingAddressDTO" %>
<%@ page import="ga.veee.day23.daopack.BillingAddressDAOImpl" %>
<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 13/04/21
  Time: 12:35 AM
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
    <title>Edit Billing Address</title>
</head>
<body>
<section class="add-billing-address-section" id="add-billing-address">
    <h1 class="shopping-cart-text">Edit Billing Address</h1>
    <form action="update-biiling-address.do" method="POST">
        <div class="checkout-container">
            <div class="checkout-left-pane">

                <input type="hidden" name="formId" value="Address">
                <input type="hidden" name="actionId" value="update">


                <%
                    Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
                    BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
                    BillingAddressDTO billingAddressDTO = billingAddressDAOImpl.findById(Integer.parseInt(request.getParameter("addressId")));


                    out.println(String.format(" <input type=\"hidden\" name=\"addressId\" value=\"%s\">               <div class=\"checkout-input-group\">\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"firstName\">First Name </label>\n" +
                            "                        <input value=\"%s\" required placeholder=\"Firstname\" class=\"checkout-input\" type=\"text\" name=\"firstName\"\n" +
                            "                               id=\"firstName\">\n" +
                            "                    </div>\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"lastName\">Last Name</label>\n" +
                            "                        <input value=\"%s\" required placeholder=\"Lastname\" class=\"checkout-input\" type=\"text\" name=\"lastName\"\n" +
                            "                               id=\"lastName\">\n" +
                            "                    </div>\n" +
                            "                </div>", request.getParameter("addressId"), billingAddressDTO.getFname(), billingAddressDTO.getLaname()));
                    out.println(String.format("                <div class=\"checkout-input-group\">\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"streetAddress1\">Street Address</label>\n" +
                            "                        <input value=\"%s\" class=\"checkout-input\" name=\"streetAddress1\" type=\"text\" id=\"streetAddress1\"\n" +
                            "                               placeholder=\"House number and street name\">\n" +
                            "                    </div>\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"streetAddress2\">&emsp;</label>\n" +
                            "                        <input value=\"%s\"  class=\"checkout-input\" type=\"text\" name=\"streetAddress2\" id=\"streetAddress2\"\n" +
                            "                               placeholder=\"Apartment, suite, unit etc.\">\n" +
                            "                    </div>\n" +
                            "                </div>", billingAddressDTO.getAddress1(), billingAddressDTO.getAddress2()));

                    out.println(String.format("                <div class=\"checkout-input-group\">\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"region\">Region / State</label>\n" +
                            "                        <input value=\"%s\"  required placeholder=\"Region / State\" class=\"checkout-input\" type=\"text\" name=\"region\"\n" +
                            "                               id=\"region\">\n" +
                            "                    </div>\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"district\">Town / City</label>\n" +
                            "                        <input value=\"%s\"  required placeholder=\"Town / City\" class=\"checkout-input\" type=\"text\" name=\"district\"\n" +
                            "                               id=\"district\">\n" +
                            "                    </div>\n" +
                            "                </div>", billingAddressDTO.getRegion(), billingAddressDTO.getTown()));
                    out.println(String.format("                <div class=\"checkout-input-group\">\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"phone\">Phone</label>\n" +
                            "                        <input value=\"%s\"  required placeholder=\"Phone\" pattern=\"[789][0-9]{9}\" class=\"checkout-input\" type=\"tel\"\n" +
                            "                               id=\"phone\" name=\"phone\">\n" +
                            "                    </div>\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"email\">Email</label>\n" +
                            "                        <input value=\"%s\" required placeholder=\"Email\"\n" +
                            "                               class=\"checkout-input\" type=\"email\" id=\"email\" name=\"email\">\n" +
                            "                    </div>\n" +
                            "                </div>", billingAddressDTO.getPhone(), billingAddressDTO.getEmail()));
                    out.println(String.format("                <div class=\"checkout-input-group\">\n" +
                            "                    <div class=\"checkout-input-half-container\">\n" +
                            "                        <label class=\"checkout-input-label\" for=\"zip\"> Zip / Postal Code</label>\n" +
                            "                        <input value=\"%s\"  required placeholder=\" Zip / Postal Code\" pattern=\"[0-9]{6}\" class=\"checkout-input\"\n" +
                            "                               type=\"text\" id=\"zip\" name=\"zip\">\n" +
                            "                    </div>\n" +
                            "                </div>", billingAddressDTO.getZip()));
                %>


                <button type="submit" class="cart-button add-address-button"><i
                        class="fa fa-check" aria-hidden="true"></i> Update Address
                </button>

            </div>


        </div>
    </form>

</section>
</body>
</html>
