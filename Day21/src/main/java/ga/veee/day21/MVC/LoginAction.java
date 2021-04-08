package ga.veee.day21.MVC;

import ga.veee.day21.MVC.DTO.UserDTO;
import ga.veee.day21.MVC.Table.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAction extends Action {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthService authService = new AuthService();
        UserDTO user = authService.checkUser(request.getParameter("username"), request.getParameter("password"));
        if (user != null) {
            if (user.getFLAG() == 1) {
                response.sendRedirect("already.html");
            } else {
                user.setFLAG(1);
                authService.updateFlag(user);
                Cookie ck = new Cookie("userId", String.valueOf(user.getUSER_ID()));
                response.addCookie(ck);
                response.sendRedirect("home.html");
            }
            System.out.println(user);

        } else {
            response.sendRedirect("register.html");
        }
        return super.execute(request, response);
    }
}
