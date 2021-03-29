package ga.veee.day16.RMIDyna.Test;


import ga.veee.day16.RMIDyna.AddressChange.AddService;
import ga.veee.day16.RMIDyna.AddressChange.Address;
import ga.veee.day16.RMIDyna.BilPay.BillPayment;
import ga.veee.day16.RMIDyna.Controller.Controller;
import ga.veee.day16.RMIDyna.Controller.Telco;
import ga.veee.day16.RMIDyna.NumberPort.NumberPortability;

public class Test {
    public static void main(String[] args) throws Exception {
        Telco telco = new Telco();
        Object obj = Controller.getTelecomAppObject(telco);

        BillPayment billPay = (BillPayment) obj;
        billPay.payBill(100);

        NumberPortability np = (NumberPortability) obj;
        np.portNumber(89898943, "airtel");

        AddService ads = (AddService) obj;
        ads.changeAddress(new Address());
    }
}
