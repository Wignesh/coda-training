package ga.veee.day17.XML.Interface;

import ga.veee.day17.XML.XMLValidator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IXMLValidator extends Remote {

    String getMessage() throws RemoteException;


    boolean isValidXML() throws RemoteException;


    XMLValidator newValidation(String xsdPath, String xmlPath) throws RemoteException;


}
