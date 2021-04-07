package ga.veee.day21;

import ga.veee.day21.DB.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cks[] = request.getCookies();
        for (Cookie cookie : cks) {
            if (cookie.getName().equals("userId"))
                if (cookie.getValue() != null) {
                    try {
                        Connection connection = ConnectionManager.getConnection();
                        PreparedStatement statement = connection.prepareStatement("UPDATE USER SET FLAG=0 WHERE USER_ID=?");
                        statement.setInt(1, Integer.parseInt(cookie.getValue()));
                        int result = statement.executeUpdate();
                        ConnectionManager.closeConnection(null, null);
                    } catch (Exception e) {
                        ConnectionManager.closeConnection(e, null);
                    }
                }

        }
        Cookie ck = new Cookie("user", "");
        ck.setMaxAge(0);
        response.addCookie(ck);
        System.out.println("Bye bye");
        response.sendRedirect("/Day21_war_exploded");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
