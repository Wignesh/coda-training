package ga.veee.day18;

import ga.veee.day18.JDBC.DBUtility;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCDemo4 {
    public static void main(String[] args) {
        Connection con = DBUtility.getConnection();
        Savepoint savepoint = null;
        try {

            Statement stmt = con.createStatement();

            int i = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS USERS (UIS INT(5),UNAME VARCHAR(30),UPASS VARCHAR(8),FLAG INT(1))");
            System.out.println(i + " TABLE CREATED....");

            i = stmt.executeUpdate("INSERT INTO USERS VALUES (1,'VIGNESH J','Vig@123',0)");
            System.out.println(i + " ROWS INSERTED....");

            savepoint = con.setSavepoint("firstSavepoint");

            i = stmt.executeUpdate("INSERT INTO USERS VALUES (2,'RENDU','Rend@123',0)");
            System.out.println(i + " ROWS INSERTED....");

            savepoint = con.setSavepoint("secondSavepoint");

            i = stmt.executeUpdate("INSERT INTO USERS VALUES (3,'MOONU','Moon@123)");
            System.out.println(i + " ROWS INSERTED....");

            savepoint = con.setSavepoint("thirdSavepoint");

            DBUtility.closeConnection(null, null);

        } catch (Exception exception) {
            DBUtility.closeConnection(exception, savepoint);
            exception.printStackTrace();
        }
    }

}
