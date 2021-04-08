<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome Home</h1>
<form action="auth.do" method="post">
    <input type="hidden" name="formid" value="Home"/>
    <input type="hidden" name="actionid" value="login"/>
    <input type="submit" value="Login">
</form>

<form action="auth.do" method="post">
    <input type="hidden" name="formid" value="Home"/>
    <input type="hidden" name="actionid" value="register"/>
    <input type="submit" value="Register">
</form>
</body>
</html>
