package ga.veee.day16.RMIDyna.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException, NotBoundException, ClassNotFoundException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("service-config.properties"));
        int services = prop.size();
        List<Class> c = new ArrayList<>();
        List<Object> o = new ArrayList<>();
        System.out.println(services);

        Enumeration<Object> en = prop.elements();
        while (en.hasMoreElements()) {
            String serviceConfigFile = (String) en.nextElement();
            System.out.println("service files...:" + serviceConfigFile);
            Properties servicesProp = new Properties();
            servicesProp.load(new FileInputStream(serviceConfigFile));
            String url = servicesProp.getProperty("url");
            String interfacename = servicesProp.getProperty("interfacename");
            o.add(Naming.lookup(url));
            c.add(Class.forName(interfacename));
        }
    }
}

//class MyInvocationHandler implements InvocationHandler {
//    Object[] obj;
//
//    public MyInvocationHandler(Object[] obj) {
//        this.obj = obj;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Object ret = null;
//        for (Object o : obj) {
//            if (o != null) {
//                Method[] m = o.getClass().getDeclaredMethods();
//                for (Method mm : m) {
//                    mm.setAccessible(true);
//                }
//                try {
//                    System.out.println("method invoked...");
//                    ret = method.invoke(o, args);
//                } catch (Exception e) {
//                    //e.printStackTrace();
//                }
//            }
//        }
//        return ret;
//    }
//}