package ga.veee.day23.Tag;

import ga.veee.day23.Invoice;
import ga.veee.day23.InvoiceItem;
import ga.veee.day23.daopack.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class HTMLInvoiceTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
            ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);

            if (pageContext.getRequest().getParameter("invoiceId") != null) {
                int invoiceId = Integer.parseInt(pageContext.getRequest().getParameter("invoiceId"));

                Invoice invoice = new Invoice();
                PreparedStatement statement = connection.prepareStatement("SELECT INVOICE_DATE,BILLING_ADDRESS FROM INVOICE_MASTER WHERE INVOICE_ID = ?;");
                statement.setInt(1, invoiceId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Date invoiceDate = resultSet.getDate(1);
                    int billId = resultSet.getInt(2);
                    BillingAddressDTO billingAddress = billingAddressDAOImpl.findById(billId);
                    HashMap<Integer, Integer> itemsKV = new HashMap<>();
                    Set<ItemDTO> items = new HashSet<>();


                    invoice.addCompanyInfo("Farmiest PVT LTD", "123, A Street,", "Coimbatore", "TamilNadu", "INDIA", "641050", "9003660624", "info@formiest.com");
                    invoice.addBillToInfo(String.format("%s %s", billingAddress.getFname(), billingAddress.getLaname()), "", String.format("%s, %s", billingAddress.getAddress1(), billingAddress.getAddress2()), billingAddress.getTown(), billingAddress.getRegion(), "INDIA", billingAddress.getZip(), billingAddress.getPhone(), billingAddress.getEmail());
                    invoice.addShipToInfo(String.format("%s %s", billingAddress.getFname(), billingAddress.getLaname()), "", String.format("%s, %s", billingAddress.getAddress1(), billingAddress.getAddress2()), billingAddress.getTown(), billingAddress.getRegion(), "INDIA", billingAddress.getZip(), billingAddress.getPhone(), billingAddress.getEmail());
                    invoice.addInvoiceInfo(LocalDate.now(), null, 1, "PAID", "");
                    invoice.setTax(9, 9);
                    invoice.setDiscountAmount(0);
                    invoice.setShippingCharges(0);
                    ConnectionManager.closeConnection(null, null);

                    connection = ConnectionManager.getConnection(dbConfigProp);
                    statement = connection.prepareStatement("SELECT ITEM_ID,QTY FROM INVOICE_TRANSACTION WHERE INVOICE_ID = ?");
                    statement.setInt(1, invoiceId   );
                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        itemsKV.put(resultSet.getInt(1), resultSet.getInt(2));
                    }
                    items = itemDAOImpl.findInIds(new ArrayList<>(itemsKV.keySet()));
                    for (ItemDTO item : items) {
                        invoice.addItem(new InvoiceItem(item.getDescription(), item.getImageUrl(), itemsKV.get(item.getItemId()), item.getItemId(), item.getPrice()));
                    }
                    String HTML;
                    int sId = 1;
                    StringBuilder HTMLBuilder = new StringBuilder(String.format("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Invoice</title><style>*{box-sizing:border-box}body{position:relative;width:21cm;height:29.7cm;margin:0 auto;color:#001028;background:#FFF;font-family:'Rubik',sans-serif;font-size:12px}header{padding:5px 0;background-color:#f1f1f1;border-top:5px solid #438343}.border-top{background-color:#f1f1f1;border-top:2px solid #438343}a{color:#5D6975;text-decoration:underline}.clearfix:after{content:\"\";display:table;clear:both}.flex{padding:1em}.invoiceLogo{text-align:right}.invoiceInfo{float:left;vertical-align:center}.invoiceInfo h1{font-size:2em}.invoiceInfo h3{font-size:1em;color:#514b4b}.invoiceLogo img{width:90px}.company h4{line-height:1;margin:8px 0;color:#514b4b}.billAddress h4{line-height:1;margin:8px 0;color:#514b4b}.shipAddress h4{line-height:1;margin:8px 0;color:#514b4b}.billAddress{float:left;text-align:left}.shipAddress{float:right;text-align:left;margin-right:20px;width:40%%}.company{float:left;text-align:left}.invoiceDetails{float:right;text-align:left;margin-right:20px;width:40%%}.invoiceDetails table{width:100%%}.invoiceDetails h4{margin:4px 0;color:#514b4b;line-height:1}main table{width:100%%;border-collapse:collapse;border-spacing:0;margin-bottom:20px}main table tr:nth-child(2n-1) td{background:#F5F5F5}main table th, main table td{text-align:center}main table th{padding:5px 20px;color:#2e2222;font-size:1.2em;font-weight:bold;border-bottom:2px solid #438343;white-space:nowrap}main table .image, main table .desc{text-align:left}main table td{padding:20px;text-align:right}main table td.image, main table td.desc{vertical-align:center}main table td{font-weight:500;color:#5D6975}main table td.unit, main table td.qty, main table td.total{font-size:1.2em;vertical-align:center;text-align:right}main table td.grand{border-top:1px solid #5D6975;;border-bottom:1px solid #5D6975;}.image img{width:60px}.price{color:green}.discount{color:red}.grand-total{color:#EB7057;font-size:1.2em !important;font-weight:bolder !important}.grand-total-text{color:#222;font-weight:bold;font-size:1.2em !important}footer{color:#5D6975;width:100%%;height:30px;position:absolute;bottom:0;right:0;left:0;border-top:1px solid #C1CED9;padding:8px 0;text-align:center}</style></head><body><header><div class=\"flex clearfix\"><div class=\"invoiceInfo\"><h1>Invoice # %s</h1><h3>%s</h3></div><div class=\"invoiceLogo\"> <img src=\"https://i.imgur.com/7VaLspM.png\"/></div></div><div class=\"flex clearfix border-top\"><div class=\"company\"><h3> Farmiest PVT LTD</h3><h4> 123, A Street,</h4><h4> Coimbatore, TamilNadu,</h4><h4> INDIA - 641050</h4><h4> <a href=\"tel:9003660624\">9003660624</a></h4><h4> <a href=\"mailto:info@formiest.com\">info@formiest.com</a></h4><h4> PAN No: AALCA0171E</h4><h4> GST Registration No: 36AALCA0171E1Z0</h4></div><div class=\"invoiceDetails\"><table><colgroup><col><col><col></colgroup><tbody><tr><td><h4>&emsp;</h4></td><td>&emsp;</td><td><h4>&emsp;</h4></td></tr><tr><td><h4>&emsp;</h4></td><td>&emsp;</td><td><h4>&emsp;</h4></td></tr><tr><td><h4>&emsp;</h4></td><td>&emsp;</td><td><h4>&emsp;</h4></td></tr><tr><td><h4>Invoice No</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Invoice Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Due Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Comment</h4></td><td>:</td><td><h4>%s</h4></td></tr></tbody></table></div></div><div class=\"flex clearfix border-top\"><div class=\"billAddress\"><h3>Billing Address</h3><h4> %s</h4><h4> %s,</h4><h4> %s, %s,</h4><h4> %s - %s</h4><h4> <a href=\"tel:%s\">%s</a></h4><h4> <a href=\"mailto:%s\">%s</a></h4></div><div class=\"shipAddress\"><h3>Shipping Address</h3><h4> %s</h4><h4> %s,</h4><h4> %s, %s,</h4><h4> %s - %s</h4><h4> <a href=\"tel:%s\">%s</a></h4><h4> <a href=\"mailto:%s\">%s</a></h4></div></div></header><main class=\"border-top\"><table><thead><tr><th>SI</th><th class=\"image\">IMAGE</th><th class=\"desc\">DESCRIPTION</th><th>PRICE</th><th>QTY</th><th>TOTAL</th></tr></thead><tbody>",
                            invoiceId, invoice.getInvoiceDate(), invoiceId, invoice.getInvoiceDate(), invoice.getInvoiceDueDate() == null ? "" : invoice.getInvoiceDueDate(), invoice.getInvoiceComment(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail()));
                    for (InvoiceItem item : invoice.getInvoiceItems()) {
                        HTMLBuilder.append(String.format("<tr><td>%s</td><td class=\"image\"> <img src=\"%s\" alt=\"%s\"></td><td class=\"desc\">%s</td><td class=\"unit\">%s</td><td class=\"qty\">%s</td><td class=\"total\">%s</td></tr>",
                                sId, item.getImageURL(), item.getDescription(), item.getDescription(), formatPrice(item.getUnitPrice()), item.getQuantity(), formatPrice(item.getTotal())));
                        sId += 1;
                    }
                    HTML = HTMLBuilder.toString();
                    HTML += String.format("<tr><td colspan=\"4\" class=\"price-breakdown\">SUBTOTAL</td><td colspan=\"2\" class=\"total price\">%s</td></tr><tr><td colspan=\"4\">DISCOUNT</td><td colspan=\"2\" class=\"total discount\"> - %s</td></tr><tr><td colspan=\"4\">CGST 9.0%%</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\">SGST 9.0%%</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\">SHIPPING&emsp14;</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\" class=\"grand total grand-total-text\">GRAND TOTAL</td><td colspan=\"2\" class=\"grand total grand-total\">%s</td></tr><tr style=\"background-color: #FFFFFF\"><td colspan=\"3\"></td><td colspan=\"3\"> <img width=\"180px\" src=\"http://i.imgur.com/o5M9z2B.png\" alt=\"Authorized Signatory\"><p style=\"text-align: center\">Authorized Signatory</p></td></tr></tbody></table> </main></body></html>",
                            formatPrice(invoice.getSubTotal()), formatPrice(invoice.getDiscountAmount()), formatPrice(invoice.getcGSTAmount()), formatPrice(invoice.getsGSTAmount()), formatPrice(invoice.getShippingCharges()), formatPrice(invoice.getTotalPayable()));
                    statement.close();
                    ConnectionManager.closeConnection(null, null);
                    out.println(HTML);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionManager.closeConnection(e, null);
        }
        return super.doEndTag();
    }

    public static String formatPrice(double value) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(value);
    }
}
