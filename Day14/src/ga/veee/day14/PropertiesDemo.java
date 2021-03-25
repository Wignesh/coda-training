package ga.veee.day14;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        properties.put("key1", "value 1");
        properties.put("key2", "value 2");

        Enumeration e = properties.elements();

        while (e.hasMoreElements()) {
            String value = (String) e.nextElement();
            System.out.println(value);
        }
        System.out.println(properties.getProperty("key1"));

        Properties env = new Properties();

        env.load(new FileInputStream("env.properties"));
        Enumeration en = env.elements();

        while (en.hasMoreElements()) {
            String value = (String) en.nextElement();
            System.out.println(value);
        }
        System.out.println(env.getProperty("key1"));

    }
}
