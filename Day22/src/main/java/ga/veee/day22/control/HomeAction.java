package ga.veee.day22.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class HomeAction extends Action {
    public HomeAction(Properties dbConfigProp) {
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String formid = request.getParameter("actionid");
        return formid.equals("login") ? "login" : "register";
    }
}
