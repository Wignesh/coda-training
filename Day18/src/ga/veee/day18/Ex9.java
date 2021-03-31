package ga.veee.day18;
/* Ex 9 Deleting a Table  		*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Ex9 {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
            Statement st = con.createStatement();
//            st.executeUpdate("drop table sam");
            ResultSet rs = st.executeQuery("select * from tab ");
            System.out.println("TNAME  \t\t TABTYPE  \t\t  CLUSTERID");
            while (rs.next()) {
                String name = rs.getString(1);
                String type = rs.getString(2);
                String clus = rs.getString(3);
                System.out.println(name + "\t \t" + type + "\t\t " + clus);
            }
            st.close();
            con.close();
            System.out.println("Customer Table Successufully Droped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
