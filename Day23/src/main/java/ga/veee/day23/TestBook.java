package ga.veee.day23;

import com.itextpdf.html2pdf.HtmlConverter;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;

public class TestBook {

    public static void main(String[] args) throws IOException, MessagingException {

        Invoice invoice = new Invoice();
        invoice.addCompanyInfo("ABC CORP", "123, A Street,", "CHENNAI", "TAMILNADU", "INDIA", "600900", "9087654321", "abc-corp@abc.com");
        invoice.addBillToInfo("A Person", "BCD CORP", "123, B Street,", "CHENNAI", "TAMILNADU", "INDIA", "900800", "8790654321", "bcd-corp@bcd.com");
        invoice.addShipToInfo("B Person", "BCD CORP", "123, C Street,", "COIMBATORE", "TAMILNADU", "INDIA", "500600", "7098654321", "bcd-corp-cbe@bcd.com");
        invoice.addInvoiceInfo(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), 1, "PAY ASAP", "Remarks");
        invoice.setTax(9, 9);
        invoice.addItem(new InvoiceItem("PEN", "https://d2cb0q3n10x0un.cloudfront.net/assets/images/product-images/banana-morris.jpg", 1, 1, 25));
        invoice.addItem(new InvoiceItem("PAPER", "https://d2cb0q3n10x0un.cloudfront.net/assets/images/product-images/banana-morris.jpg", 1, 2, 5));
        invoice.setDiscountAmount(2);
        invoice.setShippingCharges(12);
        System.out.println(invoice.getTotalPayable());

        sendMail(invoice, "thewignesh@gmail.com");

//        HtmlConverter.convertToPdf(HTML.toString(), new FileOutputStream("string-to-pdf.pdf"));
//        System.out.println("PDF Created!");

    }

    private static void sendMail(Invoice invoice, String mailTo) throws MessagingException, UnsupportedEncodingException {

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.port", "465");
        prop.setProperty("mail.smtp.ssl.enable", "true");
        prop.setProperty("mail.smtp.auth", "true");

        String from = "farmiest.india@gmail.com";
        String password = "Farmiest@2680";

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("farmiest.india@gmail.com", "Farmiest India - Order Placed", "UTF-8"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(mailTo));
        message.setSubject("Order Placed");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        String HTML = String.format("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Invoice</title></head><body style=\"position: relative;width: 21cm;height: 29.7cm;margin: 0 auto;color: #001028;background: #FFFFFF;font-family: 'Rubik', sans-serif;font-size: 12px;\"><header style=\"padding: 5px 0;background-color: #f1f1f1;border-top: 5px solid #438343;\"><div style=\"padding: 1em\"><table style=\"width: 100%%\"><tr><td><h1>Invoice # %s</h1><h3>%s</h3></td><td style=\"text-align: right\"> <img style=\"width: 90px\" src=\"https://i.imgur.com/7VaLspM.png\"/></td></tr></table></div><div style=\"padding: 0 1em; background-color: #f1f1f1;border-top: 2px solid #438343;\"><table style=\"width: 100%%\"><tr style=\"width: 100%%;\"><td style=\"width: 65%%\"><table><tr><td><h3 style=\"line-height: 1;margin: 8px 0\"> Farmiest PVT LTD</h3></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> 123, A Street,</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> Coimbatore, TamilNadu,</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> INDIA - 641050</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> <a href=\"mailto:info@formiest.com\">info@formiest.com</a></h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> PAN No: AALCA0171E</h4></td></tr><tr><td><h4 style=\"margin: 3px 0;line-height: 1;\"> GST Registration No: 36AALCA0171E1Z0</h4></td></tr></table></td><td style=\"width: 35%%\"><table><tr><td><h4>Invoice No</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Invoice Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Due Date</h4></td><td>:</td><td><h4>%s</h4></td></tr><tr><td><h4>Comment</h4></td><td>:</td><td><h4>%s</h4></td></tr></table></td></tr></table></div><div style=\"padding: 0 1em; background-color: #f1f1f1;border-top: 2px solid #438343;\"><table style=\"width: 100%%\"><tr><td style=\"width: 50%%\"><table style=\"width: 100%%\"><tr><td><h3 style=\"line-height: 1;margin: 8px 0\">Billing Address</h3></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s, %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s - %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"tel:%s\">%s</a></h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"mailto:%s\">%s</a></h4></td></tr></table></td><td style=\"width: 50%%\"><table style=\"width: 100%%\"><tr><td><h3 style=\"line-height: 1;margin: 8px 0\">Shipping Address</h3></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s, %s,</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> %s - %s</h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"tel:%s\">%s</a></h4></td></tr><tr><td><h4 style=\"line-height: 1;margin: 3px 0\"> <a href=\"mailto:%s\">%s</a></h4></td></tr></table></td></tr></table></div> </header><main style=\"background-color: #FFFFFF;border-top: 2px solid #438343;\"><table style=\"width: 100%%;border-bottom: 2px solid #438343;border-spacing: 0\"><tbody>",
                "1", invoice.getInvoiceDate(), "1", invoice.getInvoiceDate(), invoice.getInvoiceDueDate(), invoice.getInvoiceComment(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail(), invoice.getBillToContactName(), invoice.getBillToStreet(), invoice.getBillToCity(), invoice.getBillToState(), invoice.getBillToCountry(), invoice.getBillToZip(), invoice.getBillToPhone(), invoice.getBillToPhone(), invoice.getBillToEmail(), invoice.getBillToEmail()) + String.format("<tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SUBTOTAL</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">DISCOUNT</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: red\"> - %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">CGST 9.0%%</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SGST 9.0%%</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"font-weight: 500;padding: 20px;text-align: right;font-size: 1.2em\">SHIPPING</td><td colspan=\"1\" style=\"font-weight: 500;padding: 20px;text-align: center;font-size: 1.4em;color: green\"> + %s</td></tr><tr><td colspan=\"5\" style=\"border-top: 1px solid #5D6975;padding: 20px;text-align: right;border-bottom: 1px solid #5D6975;color: #222222;font-size: 1.2em !important;font-weight: bolder !important;\"> GRAND TOTAL</td><td colspan=\"1\" style=\"border-top: 1px solid #5D6975;padding: 20px;text-align: center;border-bottom: 1px solid #5D6975;color: #EB7057;font-size: 1.2em !important;font-weight: bolder !important;\"> %s</td></tr></tbody></table> </main> <footer style=\"color: #5D6975;width: 100%%;height: 30px;position: absolute;bottom: 0;right: 0;left: 0;border-top: 1px solid #C1CED9;padding: 8px 0;text-align: center;\"> <h1>  Thank You!  </h1> <p>Download full invoice from the attachment of this mail</p></footer></body></html>",
                25, 0, 2.50, 2.50, 0, 30);
        mimeBodyPart.setContent(HTML, "text/html; charset=UTF-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

    public static String formatPrice(double value) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(value);
    }
}
