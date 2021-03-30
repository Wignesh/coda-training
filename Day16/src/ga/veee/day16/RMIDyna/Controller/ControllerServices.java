package ga.veee.day16.RMIDyna.Controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControllerServices extends Remote {
    public Object getObject() throws IOException, NotBoundException, ClassNotFoundException, RemoteException;

}
