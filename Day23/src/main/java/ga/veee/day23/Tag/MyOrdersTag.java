package ga.veee.day23.Tag;

import ga.veee.day23.daopack.ConnectionManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;

public class MyOrdersTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            if (pageContext.getSession().getAttribute("userId") != null) {
                Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
                Connection connection = ConnectionManager.getConnection(dbConfigProp);
                PreparedStatement statement = connection.prepareStatement("SELECT IT.INVOICE_ID, IM.INVOICE_DATE, COUNT(IT.ITEM_ID) AS COUNT, SUM(PRICE) PRICE FROM INVOICE_TRANSACTION IT INNER JOIN INVOICE_MASTER IM ON IM.INVOICE_ID = IT.INVOICE_ID WHERE IM.CUSTOMER_ID = ? GROUP BY IM.INVOICE_ID;\n");
                statement.setInt(1, Integer.parseInt(pageContext.getSession().getAttribute("userId").toString()));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int invoiceId = resultSet.getInt(1);
                    System.out.println(invoiceId);
                    out.println(String.format("<div class=\"my-order-row\">\n" +
                            "            <h5>%s</h5>\n" +
                            "            <h5>%s</h5>\n" +
                            "            <h5>%s</h5>\n" +
                            "            <h5>%s</h5>\n" +
                            "            <h5>\n" +
                            "                <form action=\"view-invoice.jsp\" method=\"POST\" name=\"view-invoice-%s\" id=\"view-invoice-%s\">\n" +
                            "                    <input type=\"hidden\" name=\"invoiceId\" value=\"%s\" form=\"view-invoice-%s\">\n" +
                            "                    <button form=\"view-invoice-%s\" type=\"submit\" class=\"view-invoice\"><i class=\"fa fa-eye\"></i></button>\n" +
                            "                </form>\n" +
                            "            </h5>\n" +
                            "            <h5>\n" +
                            "                <form action=\"view-pdf.jsp\" method=\"POST\" name=\"view-pdf-%s\" id=\"view-pdf-%s\">\n" +
                            "                    <input type=\"hidden\" name=\"invoiceId\" value=\"%s\" form=\"view-pdf-%s\">\n" +
                            "                    <button form=\"view-pdf-%s\" type=\"submit\" class=\"view-invoice\"><i class=\"fa fa-eye\"></i></button>\n" +
                            "                </form>\n" +
                            "            </h5>\n" +
                            "            <h5>\n" +
                            "                <form action=\"view-excel.jsp\" method=\"POST\" name=\"view-excel-%s\" id=\"view-excel-%s\">\n" +
                            "                    <input type=\"hidden\" name=\"invoiceId\" value=\"%s\" form=\"view-excel-%s\">\n" +
                            "                    <button form=\"view-excel-%s\" type=\"submit\" class=\"view-invoice\"><i class=\"fa fa-eye\"></i></button>\n" +
                            "                </form>\n" +
                            "            </h5>\n" +
                            "        </div>", invoiceId, resultSet.getDate(2), resultSet.getInt(3), formatPrice(resultSet.getFloat(4)), invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId, invoiceId));
                }
            } else {
                out.println("No orders yet");
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }

    public static String formatPrice(double value) {
        String price = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(value);
        return price.substring(1, price.length());
    }
}
