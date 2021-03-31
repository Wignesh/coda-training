package ga.veee.day17.XML;

import ga.veee.day17.XML.Interface.IXMLValidator;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

public class XMLValidator implements Serializable, IXMLValidator {
    private String message;
    private boolean isValid;

    @Override
    public String getMessage() throws RemoteException {
        return this.message;
    }

    @Override
    public boolean isValidXML() throws RemoteException {
        return this.isValid;
    }

    @Override
    public XMLValidator newValidation(String xsdPath, String xmlPath) throws RemoteException {
        validate(xsdPath, xmlPath);
        return this;
    }

    private void validate(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            this.isValid = true;
            this.message = "It's a valid XML file go ahead";
        } catch (IOException | SAXException e) {
            this.message = e.getMessage();
            this.isValid = false;
        }
    }

    public XMLValidator(String xsdPath, String xmlPath) {
        this.validate(xsdPath, xmlPath);
    }
}