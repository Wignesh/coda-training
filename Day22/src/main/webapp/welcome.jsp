<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<%@ include file="Nav.jsp" %>
<h1>Welcome <%=session.getAttribute("uname") %>!</h1>
</body>
</html>