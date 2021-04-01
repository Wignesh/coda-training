package ga.veee.day19.DB.Util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class ConnectionManager {
    private ConnectionManager() {
    }

    private static String url, username, password;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));
            String driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("user");
            password = prop.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static Connection con;

    synchronized public static Connection getConnection() {
        con = threadLocal.get();
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, username, password);
                con.setAutoCommit(false);
                threadLocal.set(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    synchronized public static void closeConnection(Exception exception, Savepoint savepoint) {
        con = threadLocal.get();
        if (con != null) {
            try {
                if (exception == null)
                    con.commit(); // manual commit
                else {
                    if (savepoint == null)
                        con.rollback();
                    else {
                        con.rollback(savepoint);
                        con.commit();
                    }
                }
                con.close();
                threadLocal.remove();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}