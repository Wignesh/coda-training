<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 14/05/21
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<spring:form method="post" action="submitLoginForm" commandName="loginForm">
    UserName:<spring:input path="uname"/>
    <spring:errors path="uname"/>
    PassWord:<spring:password path="upass"/>
    <spring:errors path="upass"/>
    <input type="submit" value="Login">
</spring:form>
</body>
</html>
