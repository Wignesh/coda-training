package ga.veee.day14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDeomo {
    public static void main(String[] args) throws FileNotFoundException {
        Properties properties = new Properties();

        properties.put("key1","value 1");
        properties.put("key2","value 2");

        Enumeration e = properties.elements();

        while (e.hasMoreElements()){
            String value = (String) e.nextElement();
            System.out.println(value);
        }
        System.out.println(properties.getProperty("key1"));

        Properties env = new Properties();

        env.load(new FileInputStream("env.properties"));
    }
}
