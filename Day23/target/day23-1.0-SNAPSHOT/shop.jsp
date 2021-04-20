<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 12/04/21
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="Nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>

<section id="products" class="product-section">
    <form action="shop.do" method="POST" id="main-form">
        <%

            String category = request.getParameter("category");
            String limit = request.getParameter("limit");
            if (limit == null) limit = "25";
            else if (limit.equals("")) limit = "25";
            else {
                try {
                    limit = String.valueOf(Integer.parseInt(limit));
                } catch (Exception exception) {
                    limit = "25";
                }
            }

            if (category == null) {
                category = "FRUIT";
            } else if (category.equals("")) {
                category = "*";
            }
            session.setAttribute("category", category);
            session.setAttribute("limit", limit);

        %>

        <h2 class="category-text"><% out.print(category.equals("*") ? "All Products" : category.toUpperCase()); %></h2>
        <input type="hidden" name="formId" value="Shop"/>
        <input type="hidden" name="shopId" value="shop2"/>
        <div class="product-items">

            <Shop:ItemList category="${sessionScope.category.toUpperCase()}" limit="${sessionScope.limit}"/>
        </div>
    </form>
</section>

</body>
</html>
