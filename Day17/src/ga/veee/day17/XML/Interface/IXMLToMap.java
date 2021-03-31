package ga.veee.day17.XML.Interface;

import ga.veee.day17.XML.XMLToMap;

import java.rmi.RemoteException;
import java.util.Map;

public interface IXMLToMap {
    String getMessage() throws RemoteException ;

    boolean isValidXML() throws RemoteException ;

    XMLToMap newParser(String xsdPath, String xmlPath) throws RemoteException;

    Map<Object, Object> getMap() throws RemoteException ;
}
