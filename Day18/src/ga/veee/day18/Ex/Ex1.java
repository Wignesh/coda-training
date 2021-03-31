package ga.veee.day18.Ex;

import ga.veee.day18.JDBC.DBUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class Ex1 {
    public static void main(String[] args) throws Exception {
//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("select * from coda");
//        ResultSetMetaData rsmd = rs.getMetaData();
//        System.out.println("No. of Cols =" + rsmd.getColumnCount());
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            String c = rsmd.getColumnName(i);
//            String c1 = rsmd.getColumnTypeName(i);
//
//            String c2 = rsmd.getColumnLabel(i);
//            System.out.println("columne name " + c + "type name " + c1 + "label" + c2);
//        }

        try {
            Connection connection = DBUtility.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println("No of Columns : " + resultSetMetaData.getColumnCount());
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("\nColumn Name : %s Type : %s Label : %s", resultSetMetaData.getColumnName(i), resultSetMetaData.getColumnTypeName(i), resultSetMetaData.getColumnLabel(i));
            }
            DBUtility.closeConnection(null, null);
        } catch (Exception e) {
            DBUtility.closeConnection(e, null);
            e.printStackTrace();
        }
    }
}
