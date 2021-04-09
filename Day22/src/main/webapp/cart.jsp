<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Enumeration" %>
<%@ page import="java.util.Properties" %>
<%@ page import="ga.veee.day22.daopack.ItemDAOImpl" %>
<%@ page import="ga.veee.day22.daopack.ItemDTO" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
</head>
<body>

<%@ include file="Nav.jsp" %>
<h1>Invoice</h1>
<%
    Enumeration<String> e = session.getAttributeNames();
    ArrayList<Integer> ids = new ArrayList<>();
    while (e.hasMoreElements()) {
        String name = e.nextElement();
        if (!name.equals("uname")) {
            String value = (String) session.getAttribute(name);
            out.println(name + ":" + value);
            ids.add(Integer.parseInt(name.substring(name.length() - 1)));
        }
    }
//    System.out.println(ids.size());
//    Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
//    ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
//    Set<ItemDTO> items = itemDAOImpl.findInIds(ids);
//
//    for (ItemDTO item : items) {
//        out.println(item.getDescription());
//    }

%>
<form action="shopping.do" method="post">
    <input type="hidden" name="formid" value="GoShop">
    <input type="submit" value="Home">
</form>
</body>
</html>