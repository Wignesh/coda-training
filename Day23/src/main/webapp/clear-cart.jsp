<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing.....</title>
</head>
<body>
<%
    String id = request.getParameter("Id").toString();
    if (id.equals("*")) {

        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            if (!name.equals("uname")) {
                String value = (String) session.getAttribute(name);
                session.removeAttribute(name);
            }
        }
    } else {
        session.removeAttribute(id);
    }

    response.sendRedirect("cart.jsp");

%>
</body>
</html>
