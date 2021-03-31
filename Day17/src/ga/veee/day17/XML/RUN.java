package ga.veee.day17.XML;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RUN {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        XMLToMap xmlToMap = new XMLToMap();

        LocateRegistry.createRegistry(1099);

        System.out.println("XML To Map Service Deployed....");

        Naming.bind("rmi://localhost:1099/service/xmlToMap", xmlToMap);
    }
}
