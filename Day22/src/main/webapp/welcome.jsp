<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to our Shopping Site <%=session.getAttribute("uname") %>
</h1>
<%@ include file="logout.jsp" %>
<hr>
<h1>Go Shopping </h1>
<form action="shopping.do" method="post">
    <input type="hidden" name="formid" value="GoShop">
    <input type="submit" value="Shop">
</form>
</body>
</html>