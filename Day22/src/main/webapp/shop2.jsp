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
    <title>Fruit Shop</title>
</head>
<body>
<h1>Fruit Shop</h1>
<%@ include file="logout.jsp" %>
<form action="shop.do" method="post">
    <input type="hidden" name="formid" value="shop">
    <input type="hidden" name="shopid" value="shop2">
    Mango:<input type="checkbox" name="c4" value="mango">
    Banana:<input type="checkbox" name="c5" value="banana">
    PineApple:<input type="checkbox" name="c6" value="pineapple">

    <input type="submit" value="Next Shop">
</form>
</body>
</html>