package ga.veee.day8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflrctionDemo {
    public static void main(String[] args) throws Exception {
        PoliceStation policeStation = new PoliceStation();
        Politician ramu = new Politician();
        Doctor2 prakash = new Doctor2();
        policeStation.arrest(ramu);
    }
}

class PoliceStation {
    public void arrest(Object p) throws Exception {
        //Politician pol=(Politician)p;
        //System.out.println(pol.name);
        //pol.doWork();
        //interrogation
        Class c = p.getClass();
        Field f = c.getField("name");
        System.out.println(f.get(p));

        Method m = c.getMethod("doWork");
        m.invoke(p);

        //torture cell
        f = c.getDeclaredField("secretName");
        // Set field accessible because of access modifier
        f.setAccessible(true);
        System.out.println(f.get(p));

        m = c.getDeclaredMethod("secretWork");
        // Set field accessible because of access modifier
        m.setAccessible(true);
        // Invoke the method
        m.invoke(p);
    }
}

class Politician {
    public String name = "good man";
    private String secretName = "thief";

    public void doWork() {
        System.out.println("I do social work...........");
    }

    private void secretWork() {
        System.out.println("I trouble people and steal there money....");
    }
}

class Doctor2 {

}