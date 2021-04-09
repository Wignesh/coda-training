package ga.veee.day22.control;

import ga.veee.day22.daopack.UserDAOImpl;
import ga.veee.day22.servicepack.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;


public class LoginAction extends Action {
    private static Properties dbConfigProp;

    public LoginAction(Properties dbConfigProp) {
        LoginAction.dbConfigProp = dbConfigProp;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String uname = request.getParameter("username");
        String upass = request.getParameter("password");

        LoginServiceImpl loginService = LoginServiceImpl.getLoginService();
        loginService.setUserDAO(UserDAOImpl.getUserDaoImpl(dbConfigProp));
        HttpSession session = request.getSession();

        if (loginService.checkUser(uname, upass)) {
            if (loginService.checkFlag(uname)) {
                loginService.updateFlag(uname, 1);
                session.setAttribute("uname", uname);

                return "login.success";
            } else {
                return "login.already";
            }
        } else {
            return "login.register";
        }
    }
}
