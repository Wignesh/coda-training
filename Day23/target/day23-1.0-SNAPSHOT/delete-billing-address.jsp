<%@ page import="java.util.Properties" %>
<%@ page import="ga.veee.day23.daopack.BillingAddressDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 13/04/21
  Time: 12:36 AM
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
    <title>Deleting Billing Address</title>
</head>
<body>
<h1>Deleting Billing Address</h1>
<%
    if (request.getParameter("addressId") != null) {
        try {
            Integer.parseInt(request.getParameter("addressId"));
        } catch (Exception deleteBillException) {
            response.sendRedirect("cart.jsp");
        }
        Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
        BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
        billingAddressDAOImpl.deleteBillingAddress(Integer.parseInt(request.getParameter("addressId")));
    }
    response.sendRedirect("cart.jsp");
%>
</body>
</html>
