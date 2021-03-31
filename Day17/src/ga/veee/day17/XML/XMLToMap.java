package ga.veee.day17.XML;

import ga.veee.day17.XML.Interface.IXMLToMap;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLToMap implements IXMLToMap {

    private static XMLValidator xmlValidator;
    private String message;
    private boolean isValid;
    private HashMap<Object, Object> map;

    public XMLToMap() {
    }

    public XMLToMap(String xsdPath, String xmlPath) {
        xmlValidator = new XMLValidator(xsdPath, xmlPath);
        this.isValid = xmlValidator.isValidXML();
        this.message = xmlValidator.getMessage();
        this.parse(xmlPath);
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    private void parse(String xmlPath) {
        try {
            map = new HashMap<>();
            if (this.isValid) {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setValidating(true);
                documentBuilderFactory.setIgnoringElementContentWhitespace(true);
                documentBuilderFactory.setIgnoringComments(true);
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                documentBuilder.setErrorHandler(new XMLParsingException());
                Document document = documentBuilder.parse(new FileInputStream(xmlPath));

                NodeList resultNodes = document.getChildNodes();
                ExtendedNodeList extendedNodeList = new ExtendedNodeList();
                String emptyNodeName = null, emptyNodeValue = null;

                for (int i = 0; i < resultNodes.getLength(); i++) {
                    Node tempNode = resultNodes.item(i);
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        extendedNodeList.addNode(tempNode);
                    }
                    emptyNodeName = tempNode.getNodeName();
                    emptyNodeValue = tempNode.getNodeValue();
                }

                if (extendedNodeList.getLength() == 0 && emptyNodeName != null && emptyNodeValue != null) {
                    map.put(emptyNodeName, emptyNodeValue);
                } else {
                    this.parseXMLNode(extendedNodeList, map);
                }

            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            this.message = e.getMessage();
        }
    }

    private void parseXMLNode(NodeList nodeList, HashMap<Object, Object> result) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.hasChildNodes()
                    && node.getFirstChild() != null
                    && (node.getFirstChild().getNextSibling() != null
                    || node.getFirstChild().hasChildNodes())) {
                NodeList childNodes = node.getChildNodes();
                ExtendedNodeList tempNodeList = new ExtendedNodeList();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node tempNode = childNodes.item(j);
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        tempNodeList.addNode(tempNode);
                    }
                }
                HashMap<Object, Object> dataHashMap = new HashMap<>();
                if (result.containsKey(node.getNodeName())) {
                    List<Object> counterList = new ArrayList<>();
                    counterList.add(result.get(node.getNodeName()));
                    counterList.add(dataHashMap);
                    result.put(node.getNodeName(), counterList);
                } else {
                    result.put(node.getNodeName(), dataHashMap);
                }
                this.parseXMLNode(tempNodeList, dataHashMap);
            } else if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.hasChildNodes() && node.getFirstChild() != null
                    && node.getFirstChild().getNextSibling() == null) {
                this.putXMLValue(result, node);
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                this.putXMLValue(result, node);
            }
        }
    }

    private void putXMLValue(HashMap<Object, Object> result, Node node) {
        Object putNode = null;
        if (node.getFirstChild() != null) {
            putNode = node.getFirstChild().getNodeValue();
            if (putNode != null) {
                putNode = putNode.toString().trim();
            }
        }
        if (result.containsKey(node.getNodeName())) {
            List<Object> counterList = new ArrayList<>();
            counterList.add(result.get(node.getNodeName()));
            counterList.add(putNode);
            result.put(node.getNodeName(), counterList);
        } else {
            result.put(node.getNodeName(), putNode);
        }
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isValidXML() {
        return this.isValid;
    }

    @Override
    public XMLToMap newParser(String xsdPath, String xmlPath) {
        xmlValidator = new XMLValidator(xsdPath, xmlPath);
        this.isValid = xmlValidator.isValidXML();
        this.message = xmlValidator.getMessage();
        this.parse(xmlPath);
        return this;
    }
}

class XMLParsingException implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) {

    }

    @Override
    public void error(SAXParseException exception) {

    }

    @Override
    public void fatalError(SAXParseException exception) {

    }
}

class ExtendedNodeList implements NodeList {
    List<Node> nodes = new ArrayList<>();
    int length = 0;

    public ExtendedNodeList() {
    }

    public void addNode(Node node) {
        nodes.add(node);
        length++;
    }

    @Override
    public Node item(int index) {
        try {
            return nodes.get(index);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLength() {
        return length;
    }
}