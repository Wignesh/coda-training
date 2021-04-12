package ga.veee.day23.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class OrderAction extends Action {
    private static Properties dbConfigProp;

    public OrderAction(Properties dbConfigProp) {
        OrderAction.dbConfigProp = dbConfigProp;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object uname = session.getAttribute("uname");

        if (uname != null) {}

            return null;
    }
}
