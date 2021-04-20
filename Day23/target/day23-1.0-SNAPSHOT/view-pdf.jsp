<%@ page import="java.util.Properties" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="ga.veee.day23.daopack.ConnectionManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.sql.Blob" %>
<%@ taglib prefix="Shop" uri="/WEB-INF/Shop.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 15/04/21
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="1024kb" autoFlush="true" %>
<%
    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%
    try {
        if (pageContext.getRequest().getParameter("invoiceId") != null) {
            int invoiceId = Integer.parseInt(pageContext.getRequest().getParameter("invoiceId"));
            Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT PDF FROM INVOICE_BLOB WHERE INVOICE_ID = ?");
            statement.setInt(1, invoiceId);

            ResultSet rs = statement.executeQuery();
            ServletOutputStream outputStream = pageContext.getResponse().getOutputStream();
            pageContext.getResponse().setContentType("application/pdf");
            String rootPath = pageContext.getServletContext().getRealPath("/") + "idf.pdf";

//            File blobFile = new File(rootPath);
//            FileOutputStream output = new FileOutputStream(blobFile);
            while (rs.next()) {
                Blob pdf = rs.getBlob("PDF");
                byte[] byteArray = pdf.getBytes(1, (int) pdf.length());
                outputStream.write(byteArray);
                outputStream.flush();
//                output.write(byteArray);
            }
            outputStream.flush();
//                output.flush();

        }
    } catch (Exception viewPdfException) {
        viewPdfException.printStackTrace();
    }
%>