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
    <title>Grocery Shop</title>
</head>
<body>
<h1>Grocery Shop</h1>
<%@ include file="logout.jsp" %>
<form action="shop.do" method="post">
    <input type="hidden" name="formid" value="shop">
    <input type="hidden" name="shopid" value="shop3">
    Rice:<input type="checkbox" name="c7" value="rice">
    Daal:<input type="checkbox" name="c8" value="daal">
    Oil:<input type="checkbox" name="c9" value="oil">

    <input type="submit" value="Next Shop">
</form>
</body>
</html>