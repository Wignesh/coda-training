package ga.veee.day21;

import ga.veee.day21.DB.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Signup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        if (request.getParameter("password") != null && request.getParameter("username") != null) {
            try {
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?)");
                statement.setInt(1, Integer.parseInt(request.getParameter("id")));
                statement.setString(2, request.getParameter("username"));
                statement.setString(3, request.getParameter("password"));
                statement.setInt(4, 0);
                int result = statement.executeUpdate();
                RequestDispatcher rd;
                if (result > 0) {
                    rd = request.getRequestDispatcher("home.html");
                    System.out.println("Welcome");
                } else {
                    rd = request.getRequestDispatcher("/");
                    System.out.println("Invalid");
                }
                rd.forward(request, response);
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
