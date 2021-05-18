<%@ page import="com.example.SpringWeb.controllers.LoginForm" %><%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 14/05/21
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome</h1>
<%
    LoginForm loginForm = (LoginForm) request.getAttribute("loginBean");
    out.println(loginForm.getUname());
    out.println(loginForm.getUpass());
%>
</body>
</html>
