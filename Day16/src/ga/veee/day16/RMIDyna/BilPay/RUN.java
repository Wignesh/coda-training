package ga.veee.day16.RMIDyna.BilPay;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RUN {
	public static void main(String[] args)throws Exception {
		ZapBillPay billpay=new ZapBillPay();
		
		LocateRegistry.createRegistry(3000);
		
		System.out.println("Bill service deployed....");
		Naming.bind("rmi://localhost:3000/billpay/zappay", billpay);
				
	}
}
