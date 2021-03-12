//2.Write a Java program to check whether Java is installed on your computer. Hint: Use System Class
package Ex.Lab1;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("Java Version: " + System.getProperty("java.version"));
        String JAVA_VERSION = System.getProperty("java.version");
        if (JAVA_VERSION.equals("15.0.2")) {
            System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
            System.out.println("Java Home: " + System.getProperty("java.home"));
            System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
            System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
            System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
        } else {
            System.out.println("System preflight check failed.");
            System.out.println("You need to have JAVA version 15.0.2,");
            System.out.println("Install from oracle");
        }
    }
}
