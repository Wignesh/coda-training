package ga.veee.day16.RMIDyna.AddressChange;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddService extends Remote{
	public void changeAddress(Address add)throws RemoteException;
}


