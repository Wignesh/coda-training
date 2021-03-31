package ga.veee.day17;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class XMLProcessing {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document dom = db.parse(new FileInputStream("books.xml"));

        Element e = dom.getDocumentElement();

        System.out.println("Root Element Name...:" + e.getNodeName());
        System.out.println("has child nodes...:" + e.hasChildNodes());
        Node n = e.getFirstChild();
        System.out.println(n.getFirstChild().getNodeType());
        for (int i = 0; i < e.getChildNodes().getLength(); i++) {
            for (int j = 0; j < e.getChildNodes().item(i).getChildNodes().getLength(); j++) {
                System.out.println(e.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
            }
        }


    }
}