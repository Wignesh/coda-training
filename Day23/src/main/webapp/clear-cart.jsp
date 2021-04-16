<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Processing.....</title>
</head>
<body>
<%
    String id = request.getParameter("Id").toString();
    if (id.equals("*")) {

        Enumeration<String> e = pageContext.getSession().getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            ArrayList<String> whiteList = new ArrayList<String>(){{
                add("uname");
                add("lang");
                add("limit");
                add("rb");
                add("category");
                add("userId");
            }};
            if (!whiteList.contains(name)) {
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
