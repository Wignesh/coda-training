package ga.veee.day22.control;

import ga.veee.day22.daopack.UserDAOImpl;
import ga.veee.day22.servicepack.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        }

        return "logout.success";
    }
}