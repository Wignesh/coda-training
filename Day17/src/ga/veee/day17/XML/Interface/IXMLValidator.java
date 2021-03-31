package ga.veee.day17.XML.Interface;

import ga.veee.day17.XML.XMLValidator;

public interface IXMLValidator {

    String getMessage();


    boolean isValidXML();


    XMLValidator newValidation(String xsdPath, String xmlPath);


}
