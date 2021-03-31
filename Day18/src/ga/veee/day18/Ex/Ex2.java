package ga.veee.day18.Ex;
/* Ex 2 To display information about a  database */

import ga.veee.day18.JDBC.DBUtility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

class Ex2 {
    public static void main(String[] args) {
//        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
//            DatabaseMetaData dbmd = con.getMetaData();
//            System.out.println("DatabaseProductName     :  " + dbmd.getDatabaseProductName());
//            System.out.println("DatabaseProductVersion  :" + dbmd.getDatabaseProductVersion());
//            System.out.println("getStringFunctions            : " + dbmd.getStringFunctions());
//            System.out.println("DriverMajorVersion          : " + dbmd.getDriverMajorVersion());
//            System.out.println("DriverMinorVersion          :" + dbmd.getDriverMinorVersion());
//            System.out.println("DriverName		    : " + dbmd.getDriverName());
//            System.out.println("SQLKeywords 		     : " + dbmd.getSQLKeywords());
//            con.close();
//        } catch (Exception e) {
//        }
        try {
            Connection connection = DBUtility.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("DatabaseProductName    : " + databaseMetaData.getDatabaseProductName());
            System.out.println("DatabaseProductVersion : " + databaseMetaData.getDatabaseProductVersion());
            System.out.println("getStringFunctions     : " + databaseMetaData.getStringFunctions());
            System.out.println("DriverMajorVersion     : " + databaseMetaData.getDriverMajorVersion());
            System.out.println("DriverMinorVersion     : " + databaseMetaData.getDriverMinorVersion());
            System.out.println("DriverName             : " + databaseMetaData.getDriverName());
            System.out.println("SQLKeywords 	       : " + databaseMetaData.getSQLKeywords());
            DBUtility.closeConnection(null, null);
        } catch (Exception e) {
            DBUtility.closeConnection(e, null);
            e.printStackTrace();
        }
    }
}
