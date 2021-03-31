package ga.veee.day17.XML.Interface;

import ga.veee.day17.XML.XMLToMap;

import java.util.Map;

public interface IXMLToMap {
    String getMessage();

    boolean isValidXML();

    XMLToMap newParser(String xsdPath, String xmlPath);

    Map<Object, Object> getMap();
}
