package ga.veee.day17.XML;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        XMLToMap xmlToMap = (XMLToMap) Naming.lookup("rmi://localhost:1099/service/xmlToMap");
        xmlToMap.newParser("invoice.xsd", "invoice.xml");
        Map<Object, Object> map = xmlToMap.getMap();

        System.out.println("The stock price of coda is...:" + map);
    }
}
