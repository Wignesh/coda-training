package ga.veee.day18.Ex;/* Eg., 13			 thin Driver 		*/

import java.sql.Connection;
import java.sql.Statement;

public class Ex13 {
    Connection con;
    Statement st;

//    public Ex13() {
//        try {
//            DriverManager.registerDriver(new OracleDriver());
//            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
//            st = con.createStatement();
//            st.execute("create table t30(no number(2))");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public static void main(String st[]) {
        new Ex13();
    }
}
