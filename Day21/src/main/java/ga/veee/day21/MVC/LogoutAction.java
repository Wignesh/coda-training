package ga.veee.day21.MVC;

import ga.veee.day21.DB.ConnectionManager;
import ga.veee.day21.MVC.DTO.UserDTO;
import ga.veee.day21.MVC.Table.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogoutAction extends Action {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthService authService = new AuthService();
        Map<String, String> cookies = new HashMap<>();
        for (Cookie cookie : request.getCookies()) {
            cookies.put(cookie.getName(), cookie.getValue());
        }
        String userId = cookies.get("userId");
        if (userId != null) {
            System.out.println("Logging out..");
            User user = new User();
            UserDTO userDTO = user.findByID(Integer.valueOf(userId));
            userDTO.setFLAG(0);
            user.updateUser(userDTO);
        }
        Cookie ck = new Cookie("userId", "");
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.sendRedirect("/Day21_war_exploded");
        return super.execute(request, response);
    }
}
