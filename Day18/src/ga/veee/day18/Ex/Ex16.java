package ga.veee.day18.Ex;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Ex16 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Enumeration e = DriverManager.getDrivers();
        System.out.println(" " + DriverManager.getLoginTimeout());
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
