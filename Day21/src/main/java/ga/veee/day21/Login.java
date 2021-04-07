package ga.veee.day21;

import ga.veee.day21.DB.ConnectionManager;
import ga.veee.day21.DB.Table.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.UUID;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username")
        );
        System.out.println(request.getParameter("password"));
        if (request.getParameter("password") != null && request.getParameter("username") != null) {
            try {
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE USER_NAME = ? AND USER_PASSWORD =? AND FLAG=0");
                statement.setString(1, request.getParameter("username"));
                statement.setString(2, request.getParameter("password"));
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    statement = connection.prepareStatement("UPDATE USER SET FLAG=1 WHERE USER_NAME=? AND USER_PASSWORD=? AND USER_ID=?");
                    statement.setString(1, request.getParameter("username"));
                    statement.setString(2, request.getParameter("password"));
                    statement.setInt(3, resultSet.getInt("USER_ID"));
                    int result = statement.executeUpdate();
                    Cookie ck = new Cookie("userId", String.valueOf(resultSet.getInt("USER_ID")));
                    response.addCookie(ck);
                    RequestDispatcher rd = request.getRequestDispatcher("home.html");
                    rd.forward(request, response);
                    System.out.println("Welcome");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("signup.html");
                    rd.forward(request, response);
                    System.out.println("Please Signup");
                }
                ConnectionManager.closeConnection(null, null);
            } catch (Exception e) {
                ConnectionManager.closeConnection(e, null);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
