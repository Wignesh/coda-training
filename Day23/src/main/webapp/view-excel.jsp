<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 15/04/21
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="application/octet-stream;" %>
<%
    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    }
    response.setContentType("application/octet-stream;");
    response.setHeader("Content-Disposition", "attachment; filename=Invoice.xlsx");


//    response.setHeader("Content-Disposition", "attachment; filename=filename.xls");
%>

<Shop:ExcelExport/>
