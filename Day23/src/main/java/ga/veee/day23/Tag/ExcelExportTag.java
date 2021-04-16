package ga.veee.day23.Tag;

import ga.veee.day23.daopack.ConnectionManager;

import javax.servlet.ServletOutputStream;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ExcelExportTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            if (pageContext.getRequest().getParameter("invoiceId") != null) {
                int invoiceId = Integer.parseInt(pageContext.getRequest().getParameter("invoiceId"));
                Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
                Connection connection = ConnectionManager.getConnection(dbConfigProp);
                PreparedStatement statement = connection.prepareStatement("SELECT EXCEL FROM INVOICE_BLOB WHERE INVOICE_ID = ?");
                statement.setInt(1, invoiceId);

                ResultSet rs = statement.executeQuery();
                ServletOutputStream outputStream = pageContext.getResponse().getOutputStream();
                pageContext.getResponse().setContentType("application/octet-stream");
                String rootPath = pageContext.getServletContext().getRealPath("/") + "idf.xlsx";

//                File blobFile = new File(rootPath);
//                FileOutputStream output = new FileOutputStream(blobFile);
                while (rs.next()) {
                    Blob pdf = rs.getBlob("EXCEL");
                    byte[] byteArray = pdf.getBytes(1, (int) pdf.length());
                    outputStream.write(byteArray);
                    outputStream.flush();
                }
                outputStream.flush();
//                output.flush();

            }
        } catch (Exception viewPdfException) {
            viewPdfException.printStackTrace();
        }
        return super.doEndTag();
    }
}
