package ga.veee.day23.Tag;

import com.itextpdf.html2pdf.HtmlConverter;
import ga.veee.day23.Excel;
import ga.veee.day23.Invoice;
import ga.veee.day23.InvoiceItem;
import ga.veee.day23.daopack.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessOrderTag extends TagSupport {
    private ExecutorService executor;

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            Enumeration<String> attributeNames = pageContext.getSession().getAttributeNames();
            HashMap<Integer,String> attributesKV = new HashMap<>();

            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<String> whiteList = new ArrayList<String>() {{
                add("uname");
                add("lang");
                add("rb");
                add("userId");
                add("limit");
                add("category");
            }};
            Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");

            while (attributeNames.hasMoreElements()) {
                String name = attributeNames.nextElement();
                if (!whiteList.contains(name)) {
                    String value = (String) pageContext.getSession().getAttribute(name);
                    ids.add(Integer.parseInt(name));
                    attributesKV.put(Integer.parseInt(name),value);
                }
            }

            if (!ids.isEmpty()) {

                InvoiceMasterDTOImpl invoiceMasterDTOImpl = InvoiceMasterDTOImpl.getInvoiceMasterDTOImpl(dbConfigProp);
                BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
                InvoiceTransactionDTOImpl invoiceTransactionDTOImpl = InvoiceTransactionDTOImpl.getInvoiceTransactionDTOImpl(dbConfigProp);
                ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
                UserDAOImpl userDaoImpl = UserDAOImpl.getUserDaoImpl(dbConfigProp);

                System.out.println(pageContext.getRequest().getParameter("addressId"));
                BillingAddressDTO billingAddress = billingAddressDAOImpl.findById(Integer.parseInt(pageContext.getRequest().getParameter("addressId")));
                int invoiceId = getInvoiceId(invoiceMasterDTOImpl);
                String username = getUsername();
                int customerId = getCustomerId(userDaoImpl, username);
                int addressId = Integer.parseInt(pageContext.getRequest().getParameter("addressId"));
                if(addressId == 0){
                    pageContext.forward("checkout.jsp");
                }
                String rootPath = pageContext.getServletContext().getRealPath("/");

                out.println("Invoice ID : " + invoiceId);

                executor = Executors.newCachedThreadPool();
                executor.submit(() -> {
                    try {
                        int insertInvoiceMaster = insertInvoiceMaster(invoiceMasterDTOImpl, invoiceId, customerId,addressId);

                        Invoice invoice = getInvoice(ids, itemDAOImpl, billingAddress, invoiceId, attributesKV);

                        int insertInvoiceTransaction = insertInvoiceTransaction(ids, invoiceTransactionDTOImpl, invoiceId,attributesKV);

                        String excelPath = genExcel(invoiceId, invoice, rootPath);

                        String pdfPath = genPDF(invoiceId, invoice,rootPath);

                        int saveBlob = saveBlob(dbConfigProp, excelPath, pdfPath, invoiceId);

                        sendMail(invoice, invoiceId, excelPath, pdfPath);

                        System.out.println("Success");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
                executor.shutdown();

            } else {
                pageContext.forward("index.jsp");
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            try {
                pageContext.forward("checkout.jsp");
            } catch (ServletException | IOException servletException) {
                servletException.printStackTrace();
            }

        }
        return super.doEndTag();
    }

    private int insertInvoiceTransaction(ArrayList<Integer> ids, InvoiceTransactionDTOImpl invoiceTransactionDTOImpl, int invoiceId, HashMap<Integer,String> attributesKV) {
        for (Integer id : ids) {
            String value = attributesKV.get(id);
            InvoiceTransactionDTO invoiceTransactionDTO = new InvoiceTransactionDTO(invoiceId, id, Integer.parseInt(value), 0.0F);
            invoiceTransactionDTOImpl.insertInvoiceTransaction(invoiceTransactionDTO);
        }
        return 0;
    }


    private String getUsername() {
        return pageContext.getSession().getAttribute("uname").toString();
    }


    private int getInvoiceId(InvoiceMasterDAO invoiceMasterDTOImpl) {
        return invoiceMasterDTOImpl.getLastInvoiceId() + 1;
    }

    private int getCustomerId(UserDAOImpl userDaoImpl, String uname) {
        UserDTO userDTO = userDaoImpl.findByName(uname);
        return userDTO.getUid();
    }

    private int insertInvoiceMaster(InvoiceMasterDTOImpl invoiceMasterDTOImpl, int invoiceId, int cutId, int addressId) {
        InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO(invoiceId, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()), cutId, addressId);
        return invoiceMasterDTOImpl.insertInvoiceMaster(invoiceMasterDTO);
    }

    private Invoice getInvoice(ArrayList<Integer> ids, ItemDAOImpl itemDAOImpl, BillingAddressDTO billingAddress, int invoiceId, HashMap<Integer,String> attributesKV) {
        Invoice invoice = new Invoice();
        invoice.addCompanyInfo("Farmiest PVT LTD", "123, A Street,", "Coimbatore", "TamilNadu", "INDIA", "641050", "9003660624", "info@formiest.com");

        invoice.addBillToInfo(String.format("%s %s", billingAddress.getFname(), billingAddress.getLaname()), "", String.format("%s, %s", billingAddress.getAddress1(), billingAddress.getAddress2()), billingAddress.getTown(), billingAddress.getRegion(), "INDIA", billingAddress.getZip(), billingAddress.getPhone(), billingAddress.getEmail());
        invoice.addShipToInfo(String.format("%s %s", billingAddress.getFname(), billingAddress.getLaname()), "", String.format("%s, %s", billingAddress.getAddress1(), billingAddress.getAddress2()), billingAddress.getTown(), billingAddress.getRegion(), "INDIA", billingAddress.getZip(), billingAddress.getPhone(), billingAddress.getEmail());
        invoice.addInvoiceInfo(LocalDate.now(), null, invoiceId, "PAID", "");
        invoice.setTax(9, 9);
        invoice.setDiscountAmount(0);
        invoice.setShippingCharges(0);

        Set<ItemDTO> items = itemDAOImpl.findInIds(ids);
        for (ItemDTO item : items) {
            invoice.addItem(new InvoiceItem(item.getDescription(), item.getImageUrl(), Integer.parseInt(attributesKV.get(item.getItemId())), item.getItemId(), item.getPrice()));
        }
        return invoice;
    }

    private String genPDF(int invoiceId, Invoice invoice, String rootPath) {
        try {
            String pdfPath = rootPath + String.format("Invoice_%s.pdf", invoiceId);
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
            HTML += String.format("<tr><td colspan=\"4\" class=\"price-breakdown\">SUBTOTAL</td><td colspan=\"2\" class=\"total price\">%s</td></tr><tr><td colspan=\"4\">DISCOUNT</td><td colspan=\"2\" class=\"total discount\"> - %s</td></tr><tr><td colspan=\"4\">CGST 9.0%%</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\">SGST 9.0%%</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\">SHIPPING&emsp14;</td><td colspan=\"2\" class=\"total price\"> + %s</td></tr><tr><td colspan=\"4\" class=\"grand total grand-total-text\">GRAND TOTAL</td><td colspan=\"2\" class=\"grand total grand-total\">%s</td></tr><tr style=\"background-color: #FFFFFF\"><td colspan=\"3\"></td><td colspan=\"3\"> <img width=\"180px\" src=\"http://i.imgur.com/o5M9z2B.png\" alt=\"Authorized Signatory\"><p style=\"text-align: center\">Authorized Signatory</p></td></tr></tbody></table> </main> <footer> <h1>Thank You!</h1> </footer></body></html>",
                    formatPrice(invoice.getSubTotal()), formatPrice(invoice.getDiscountAmount()), formatPrice(invoice.getcGSTAmount()), formatPrice(invoice.getsGSTAmount()), formatPrice(invoice.getShippingCharges()), formatPrice(invoice.getTotalPayable()));
            HtmlConverter.convertToPdf(HTML, new FileOutputStream(pdfPath));
            return pdfPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String genExcel(int invoiceId, Invoice invoice, String rootPath) {
        try {
            Excel excel = new Excel();
            excel.setInvoice(invoice);
            String excelPath = rootPath + String.format("Invoice_%s.xlsx", invoiceId);
            String logoPath = rootPath + "logo.png";
            excel.printInvoice(excelPath, logoPath);
            return excelPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private int saveBlob(Properties dbConfigProp, String excelPath, String pdfPath, int invoiceId) {
        try {
            File excelFile = new File(excelPath);
            FileInputStream excelInput = new FileInputStream(excelFile);

            File pdfFile = new File(pdfPath);
            FileInputStream pdfInput = new FileInputStream(pdfFile);

            Connection connection = ConnectionManager.getConnection(dbConfigProp);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICE_BLOB VALUES (?,?,?);");
            statement.setInt(1, invoiceId);
            statement.setBinaryStream(2, excelInput);
            statement.setBinaryStream(3, pdfInput);

            int result = statement.executeUpdate();

            statement.close();

            excelInput.close();
            pdfInput.close();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
            e.printStackTrace();
        }
        return 0;
    }

    private static void sendMail(Invoice invoice, int invoiceId, String excelPath, String pdfPath) {
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.port", "465");
            prop.setProperty("mail.smtp.ssl.enable", "true");
            prop.setProperty("mail.smtp.auth", "true");

            String from = "farmiest.india@gmail.com";
            String password = "Farmiest@gmil.com";

            Session session = Session.getInstance(prop, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("farmiest.india@gmail.com", "Farmiest India - Order Placed", "UTF-8"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(invoice.getBillToEmail()));
            message.setSubject("Order Placed");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            String HTML = String.format("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Invoice</title></head><body style=\"position: relative;width: 21cm;height: 29.7cm;margin: 0 auto;color: #001028;background: #FFFFFF;font-family: 'Rubik', sans-serif;font-size: 12px;\"><header style=\"padding: 5px 0;background-color: #f1f1f1;border-top: 5px solid #438343;\"><div style=\"padding: 1em\"><table style=\"width: 100%%\"><tr><td><h1>Invoice # %s</h1><h3>%s</h3></td><td style=\"text-align: right\"> <img style=\"width: 90px\" src=\"https://i.imgur.com/7VaLspM.png\"/></td></tr></table></div><div style=\"padding: 0 1em; background-color: #f1f1f1;border-top: 2px solid #438343;\"><table style=\"width: 100%%\"><tr style=\"width: 100%%;\"><td style=\"width: 65%%\"><table><tr><td><h3 style=\"line-height: 1;margin: 8px 0\"> Farmiest PVT LTD</h3></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> 123, A Street,</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> Coimbatore, TamilNadu,</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> INDIA - 641050</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> <a href=\"mailto:farmiest.india@gmail.com\">farmiest.india@gmail.com</a></h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> PAN No: AALCA0171E</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> GST Registration No: 36AALCA0171E1Z0</h4></td></tr></table></td><td style=\"width: 35%%\"><table><tr><td><h4>Invoice No</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Invoice Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Due Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Comment</h4></td><td>:</td><td><h4>%s</h4></td></tr></table></td></tr></table></div><div style=\"padding: 0 1em; background-color: #f1f1f1;border-top: 2px solid #438343;\"><table style=\"width: 100%%\"><tr><td style=\"width: 50%%\"><table style=\"width: 100%%\"><tr><td><h3 style=\"line-height: 1;margin: 8px 0\">Billing Address</h3></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s, %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s - %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"tel:%s\">%s</a></h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"mailto:%s\">%s</a></h4></td></tr></table></td><td style=\"width: 50%%\"><table style=\"width: 100%%\"><tr><td><h3 style=\"line-height: 1;margin: 8px 0\">Shipping Address</h3></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s, %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s - %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"tel:%s\">%s</a></h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"mailto:%s\">%s</a></h4></td></tr></table></td></tr></table></div> </header><main style=\"background-color: #FFFFFF;border-top: 2px solid #438343;\"><table style=\"width: 100%%;border-bottom: 2px solid #438343;border-spacing: 0\"><tbody>",
                    invoiceId, invoice.getInvoiceDate(), invoiceId, invoice.getInvoiceDate(), invoice.getInvoiceDueDate(), invoice.getInvoiceComment(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail()) + String.format("<tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SUBTOTAL</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">DISCOUNT</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: red\"> - %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">CGST 9.0%%</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SGST 9.0%%</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SHIPPING</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"border-top: 1px solid #5D6975;padding: 20px;text-align: right;border-bottom: 1px solid #5D6975;color: #222222;font-size: 1.2em !important;font-weight: bolder !important;\"> GRAND TOTAL</td><td colspan=\"1\" style=\"border-top: 1px solid #5D6975;padding: 20px;text-align: center;border-bottom: 1px solid #5D6975;color: #EB7057;font-size: 1.2em !important;font-weight: bolder !important;\"> %s</td></tr></tbody></table> </main> <footer style=\"color: #5D6975;width: 100%%;height: 30px;position: absolute;bottom: 0;right: 0;left: 0;border-top: 1px solid #C1CED9;padding: 8px 0;text-align: center;\"> <h1>  Thank You!  </h1> <p>Download full invoice from the attachment of this mail</p></footer></body></html>",
                    formatPrice(invoice.getSubTotal()), formatPrice(invoice.getDiscountAmount()), formatPrice(invoice.getcGSTAmount()), formatPrice(invoice.getsGSTAmount()), formatPrice(invoice.getShippingCharges()), formatPrice(invoice.getTotalPayable()));
            mimeBodyPart.setContent(HTML, "text/html; charset=UTF-8");

            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile(pdfPath);

            MimeBodyPart excelAttachment = new MimeBodyPart();
            excelAttachment.attachFile(excelPath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(pdfAttachment);
            multipart.addBodyPart(excelAttachment);

            message.setContent(multipart);

            Transport.send(message);

            Files.deleteIfExists(Paths.get(excelPath));
            Files.deleteIfExists(Paths.get(pdfPath));

            System.out.println("Mail Send");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatPrice(double value) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(value);
    }
}


//            statement = connection.prepareStatement("SELECT EXCEL FROM INVOICE_BLOB WHERE INVOICE_ID = ?");
//            statement.setInt(1, invoiceId);
//
//            ResultSet rs = statement.executeQuery();
//
//            File blobFile = new File(filePath);
//            FileOutputStream output = new FileOutputStream(blobFile);
//
//            System.out.println("Writing to file " + file.getAbsolutePath());
//            while (rs.next()) {
//                Blob excel = rs.getBlob("EXCEL");
//                byte[] byteArray = excel.getBytes(1, (int) excel.length());
//                output.write(byteArray);
//            }
