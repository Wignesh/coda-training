package ga.veee.day23.daopack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class ConnectionManager {
    private ConnectionManager() {
        // TODO Auto-generated constructor stub
    }

//    private static String url, username, password;

//    static {
//        try {
//            Properties prop = new Properties();
//            prop.load(new FileInputStream("dbconfig.properties"));
//            String driver = prop.getProperty("driver");
//            url = prop.getProperty("url");
//            username = prop.getProperty("username");
//            password = prop.getProperty("password");
//            Class.forName(driver);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
    private static Connection con;

    synchronized public static Connection getConnection(Properties dbConfigProp) {
        con = tlocal.get();
        if (con == null) {
            try {
                Class.forName(dbConfigProp.getProperty("driver"));
                con = DriverManager.getConnection(dbConfigProp.getProperty("url"), dbConfigProp.getProperty("username"), dbConfigProp.getProperty("password"));
                con.setAutoCommit(false);
                tlocal.set(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    synchronized public static void closeConnection(Exception e, Savepoint sp) {
        con = tlocal.get();
        if (con != null) {
            try {
                if (e == null) {
                    con.commit();//manual commit
                } else {
                    if (sp == null) {
                        con.rollback();
                    } else {
                        con.rollback(sp);
                        con.commit();
                    }
                }
                con.close();
                tlocal.remove();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}
