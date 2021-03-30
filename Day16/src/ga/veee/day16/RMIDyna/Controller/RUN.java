package ga.veee.day16.RMIDyna.Controller;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RUN {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        Controller controller = new Controller();
        LocateRegistry.createRegistry(4500);
        System.out.println("Controller service deployed....");
        Naming.bind("rmi://localhost:4500/services/get", controller);
    }
}
