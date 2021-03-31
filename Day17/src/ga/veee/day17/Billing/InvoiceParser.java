package ga.veee.day17.Billing;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;

public class InvoiceParser {
    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        SAXParser sp = spf.newSAXParser();
        sp.parse(new FileInputStream("invoice.xml"), new InvoiceProcessor());
    }
}

class InvoiceProcessor extends DefaultHandler {

    private static Invoice invoice;

    Invoice getInvoice() {
        return invoice;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("parsing started....");
        invoice = new Invoice();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("parsing finished....");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName);
//        System.out.print("<" + qName + ">");
//        int length = attributes.getLength();
//        for (int i = 0; i < length; i++) {
//            System.out.print(attributes.getQName(i) + "=\"");
//            System.out.print(attributes.getValue(i) + "\"");
//        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
//        System.out.print(s.strip());
    }
}
