package ga.veee.day22.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Properties;

public class ShoppingAction extends Action {

    private static Properties dbConfigProp;

    public ShoppingAction(Properties dbConfigProp) {
        ShoppingAction.dbConfigProp = dbConfigProp;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String shopid = request.getParameter("shopid");
        Enumeration<String> e = request.getParameterNames();
        HttpSession session = request.getSession();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getParameter(name);
            if (name.equals("formid") || name.equals("shopid")) {

            } else {
                if (Integer.parseInt(value) > 0)
                    session.setAttribute(name, value);
            }
        }
        return shopid;
    }
}
