<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
</head>
<body>
<h1>Invoice</h1>
<%@ include file="logout.jsp" %>
<%
    Enumeration<String> e = session.getAttributeNames();
    while (e.hasMoreElements()) {
        String name = e.nextElement();
        if (!name.equals("uname")) {
            String value = (String) session.getAttribute(name);
            out.println(name + ":" + value);
        }
    }

%>
</body>
</html>