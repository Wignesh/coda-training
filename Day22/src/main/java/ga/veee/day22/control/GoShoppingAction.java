package ga.veee.day22.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class GoShoppingAction extends Action {
    public GoShoppingAction(Properties dbConfigProp) {
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object uname = session.getAttribute("uname");

        if (uname != null) {
            return "goshop.success";

        }
        return "login";
    }
}