package ga.veee.day23.control;

import ga.veee.day23.daopack.UserDAOImpl;
import ga.veee.day23.servicepack.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Properties;

public class LogoutAction extends Action {
    private static Properties dbConfigProp;

    public LogoutAction(Properties dbConfigProp) {
        LogoutAction.dbConfigProp = dbConfigProp;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object uname = session.getAttribute("uname");

        if (uname != null) {

            LoginServiceImpl loginService = LoginServiceImpl.getLoginService();
            loginService.setUserDAO(UserDAOImpl.getUserDaoImpl(dbConfigProp));
            loginService.updateFlag(uname.toString(), 0);

            Enumeration<String> e = session.getAttributeNames();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                session.removeAttribute(name);
            }
        }

        return "logout.success";
    }
}