package ga.veee.day16.RMIDyna.Test;

import ga.veee.day16.RMIDyna.BilPay.BillPayment;
import ga.veee.day16.RMIDyna.BilPay.ZapBillPay;
import ga.veee.day16.RMIDyna.NumberPort.NumberPortability;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RUN {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Object object = (Object) Naming.lookup("rmi://localhost:4500/services/get");

        BillPayment billPay = (BillPayment) object;
        billPay.payBill(100);

//        NumberPortability np = (NumberPortability) object;
//        np.portNumber(89898943, "airtel");


    }
}
