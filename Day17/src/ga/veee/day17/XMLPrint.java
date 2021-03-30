package ga.veee.day17;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class XMLPrint {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document dom = db.parse(new FileInputStream("invoice.xml"));

        Element e = dom.getDocumentElement();

        printAll(e);

    }

    public static void printAll(Element e) {
        NodeList nodeList = e.getChildNodes();
        printNodes(nodeList);
    }

    public static void printNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            printNode(nodeList.item(i));
        }
    }

    public static void printNode(Node node) {
        if (node.hasChildNodes()) {
            printNodes(node.getChildNodes());
        } else {
            System.out.println(node.getNodeValue().strip());
        }
    }
}
