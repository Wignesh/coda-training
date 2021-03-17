package ga.veee.day8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemo2 {
    public static void main(String[] args) {
        AlopathyMedicalCollege0 stanley = new AlopathyMedicalCollege0();
        AyurvedMedicalCollege0 imcops = new AyurvedMedicalCollege0();

        JetAcademy jet = new JetAcademy();

        Object shoiab = new Human0();//1974

        shoiab = Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
                new Class[]{Doctor0.class, Pilot.class},
                new MyInvocationHandler0(new Object[]{shoiab, jet, stanley}));

        Doctor0 doctorShoiab = (Doctor0) shoiab;
        doctorShoiab.doCure();

        Pilot pilot = (Pilot) shoiab;
        pilot.doFly();
        Scanner scan = new Scanner(System.in);
        System.out.println("waiting..............");
        String s = scan.next();

        StewardAcademy sa = new StewardAcademy();
        shoiab = Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
                new Class[]{Doctor0.class, Pilot.class, Steward.class},
                new MyInvocationHandler0(new Object[]{shoiab, sa}));

        Steward stewardShoiab = (Steward) shoiab;
        stewardShoiab.serve();

        doctorShoiab = (Doctor0) shoiab;
        doctorShoiab.doCure();

        pilot = (Pilot) shoiab;
        pilot.doFly();
    }
}

class MyInvocationHandler0 implements InvocationHandler {
    Object obj[];

    public MyInvocationHandler0(Object obj[]) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnObject = null;
        for (Object o : obj) {
            Method m[] = o.getClass().getDeclaredMethods();
            for (Method met : m) {
                if (met.getName().equals(method.getName())) {
                    met.setAccessible(true);
                    returnObject = method.invoke(o, args);
                }
            }
        }
        return returnObject;
    }
}

interface Steward {
    public void serve();
}

interface Pilot {
    public void doFly();
}

class StewardAcademy implements Steward {
    @Override
    public void serve() {
        System.out.println("serving...................");
    }
}

class JetAcademy implements Pilot {
    @Override
    public void doFly() {
        System.out.println("flying.................");
    }
}

interface Doctor0 {
    public void doCure();
}

class Human0 {
}

class AlopathyMedicalCollege0 implements Doctor0 {
    @Override
    public void doCure() {
        System.out.println("alopathy cure logic implemented...");
    }
}

class AyurvedMedicalCollege0 implements Doctor0 {
    @Override
    public void doCure() {
        System.out.println("ayurved cure logic implemented....");
    }
}