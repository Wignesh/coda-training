package ga.veee.day18.Ex;
/* Ex 3 selecting rows from emp table */

import ga.veee.day18.JDBC.DBUtility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

class Ex3 {
    public static void main(String[] args) throws Exception {
//        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
//            Statement st = con.createStatement();
//            st.executeUpdate("create table sam(name varchar(15),age int)");
//            st.close();
//            con.close();
//            System.out.println("table created");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Connection connection = DBUtility.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS USERS (\n" +
                    "    UIS INT(5),\n" +
                    "    UNAME VARCHAR(30),\n" +
                    "    UPASS VARCHAR(8),\n" +
                    "    FLAG INT(1)\n" +
                    ");");
            statement.close();
            System.out.println("Table Created");
            DBUtility.closeConnection(null, null);
        } catch (Exception e) {
            DBUtility.closeConnection(e, null);
            e.printStackTrace();
        }

    }
}
	
