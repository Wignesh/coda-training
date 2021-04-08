package ga.veee.day22.control;

import ga.veee.day22.daopack.UserDAO;
import ga.veee.day22.daopack.UserDAOImpl;
import ga.veee.day22.daopack.UserDTO;
import ga.veee.day22.servicepack.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class RegisterAction extends Action {
    private static Properties dbConfigProp;

    public RegisterAction(Properties dbConfigProp) {
        RegisterAction.dbConfigProp = dbConfigProp;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        LoginServiceImpl loginService = LoginServiceImpl.getLoginService();
        loginService.setUserDAO(UserDAOImpl.getUserDaoImpl(dbConfigProp));

        if (loginService.registerUser(0, uname, upass, 0) == 1) {
            return "register.success";
        } else {
            return "login.register";
        }
    }
}
