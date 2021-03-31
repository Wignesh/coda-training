package ga.veee.day18.Ex;
/*  Ex 10 For PreparedStatement 		*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Ex10 {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott", "tiger");
            PreparedStatement ps = con.prepareStatement("select * from sam where age>= ?");
            ps.setInt(1, 20);
            ResultSet rs = ps.executeQuery();
            System.out.println("empno \t\t empname ");
            while (rs.next()) {
                String e1 = rs.getString(1);
                int e = rs.getInt(2);
                System.out.println("name = " + e1 + "\t age = " + e);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
