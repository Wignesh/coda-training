package ga.veee.day16.RMIDyna.NumberPort;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RUN {
    public static void main(String[] args) throws Exception {
        NumberPortability number = new ZapNumberPort();

        LocateRegistry.createRegistry(4000);

        System.out.println("Number Portability service deployed....");
        Naming.bind("rmi://localhost:4000/numberport/zapnumber", number);
    }
}
