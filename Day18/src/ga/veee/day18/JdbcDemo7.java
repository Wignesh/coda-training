package ga.veee.day18;

import ga.veee.day18.JDBC.DBUtility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

public class JdbcDemo7 {
    public static void main(String[] args) throws Exception {
        Connection connection = DBUtility.getConnection();

        CallableStatement callableStatement = connection.prepareCall("{CALL PROCEDURE1()}");

        int i = callableStatement.executeUpdate();

        System.out.println("No of rows updated...:" + i);

        Statement statement = connection.createStatement();
        boolean b = statement.execute("INSERT INTO USERS VALUES (3,'RAJA','Spid3r',0)");
        System.out.println(b);

        CallableStatement cs = connection.prepareCall("{CALL PROCEDURE2(?,?)}");
        cs.setString(1, "VIGNESH");
        cs.setInt(2, 1);

        cs.executeUpdate();

        CallableStatement callableStatement1 = connection.prepareCall("{CALL PROCEDURE3(?,?)}");
        callableStatement1.setString(1, "VIGNESH");
        callableStatement1.registerOutParameter(2, Types.INTEGER);

        callableStatement1.execute();

        System.out.println("The flag value of VIGNESH is...:" + callableStatement1.getInt(2));
        DBUtility.closeConnection(null, null);
    }
}