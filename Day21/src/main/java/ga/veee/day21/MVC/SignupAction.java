package ga.veee.day21.MVC;

import ga.veee.day21.MVC.DTO.UserDTO;
import ga.veee.day21.MVC.Table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupAction extends Action {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("password") != null && request.getParameter("username") != null) {
            UserDTO userDTO = UserDTO.getUserDTO();
            userDTO.setUSER_ID(Integer.parseInt(request.getParameter("id")));
            userDTO.setUSER_NAME(request.getParameter("username"));
            userDTO.setUSER_NAME(request.getParameter("password"));
            userDTO.setFLAG(0);
            int result = new User().insertUser(userDTO);
            if (result > 0) {
                System.out.println("Signup Success");
                response.sendRedirect("home.html");
            } else {
                System.out.println("User exist");
                response.sendRedirect("register.html");

            }
        }
        return super.execute(request, response);
    }
}
