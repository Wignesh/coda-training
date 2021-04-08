<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Vegetable Shop</title>
</head>
<body>
<h1>Vegetable Shop</h1>
<%@ include file="logout.jsp" %>
<form action="shop.do" method="post">
    <input type="hidden" name="formid" value="shop">
    <input type="hidden" name="shopid" value="shop1">
    Brinjal:<input type="checkbox" name="c1" value="brinjal">
    Potato:<input type="checkbox" name="c2" value="potato">
    Carrot:<input type="checkbox" name="c1" value="carrot">

    <input type="submit" value="Next Shop">
</form>
</body>
</html>