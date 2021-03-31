package ga.veee.day18.Ex;
/* Ex 7 using execute 	*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Ex7 {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
            Statement st = con.createStatement();
            st.execute("insert into sam values('hapa',111)");
            st.execute("delete from sam where age=21");
            st.close();
            con.close();
            System.out.println(" success�.. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

