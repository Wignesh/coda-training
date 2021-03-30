package ga.veee.day16.RMIDyna.BilPay;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class ZapBillPay extends UnicastRemoteObject implements BillPayment,Serializable{
	public ZapBillPay() throws RemoteException{

	}
	@Override
	public void payBill(int amt)throws RemoteException {
		System.out.println("bill payment logic written and executed...");
		System.out.println("bill payment done....");
	}
}