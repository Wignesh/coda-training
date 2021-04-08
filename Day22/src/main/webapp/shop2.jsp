<%@ page import="java.util.Properties" %>
<%@ page import="ga.veee.day22.daopack.UserDAOImpl" %>
<%@ page import="ga.veee.day22.daopack.ItemDAOImpl" %>
<%@ page import="ga.veee.day22.daopack.ItemDAO" %>
<%@ page import="java.util.Set" %>
<%@ page import="ga.veee.day22.daopack.ItemDTO" %>
<%@ page import="java.text.MessageFormat" %><%--
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
    <style>
        .items {
            display: flex;
            flex-direction: row;
            height: 200px;
            flex-wrap: wrap;
        }

        .item {
            margin: 10px;
        }
    </style>
</head>
<body>
<h1>Fruit Shop</h1>
<%@ include file="logout.jsp" %>
<form action="shop.do" method="post">
    <input type="submit" value="Next Shop">
    <div class="items">
        <input type="hidden" name="formid" value="Shop">
        <input type="hidden" name="shopid" value="shop2">
        <%
            Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
            ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
            Set<ItemDTO> items = itemDAOImpl.findAllByCat("VEGE");
            for (ItemDTO item : items) {
                out.println(String.format("    <table class=\"item\" border=\"1\" cellpadding=\"10\" cellspacing=\"0\" width=\"200px\">\n" +
                        "      <tr align=\"center\">\n" +
                        "        <td>\n" +
                        "          <img width=\"100px\" height=\"100px\" src=\"%s\" alt=\"Image\" />\n" +
                        "        </td>\n" +
                        "      </tr>\n" +
                        "      <tr align=\"center\">\n" +
                        "        <td><b>%s</b> :<span>1 %s &#8377; %s</span></td>\n" +
                        "      </tr>\n" +
                        "      <tr align=\"center\">\n" +
                        "        <td>Quantity : <input name=\"I%s\" type=\"number\" min=\"0\" max=\"10\" value=\"0\"/></td>\n" +
                        "      </tr>\n" +
                        "    </table>", item.getImageUrl(), item.getDescription(), item.getUnit(), item.getPrice(), item.getItemId()));
            }
        %>
    </div>

</form>
</body>
</html>