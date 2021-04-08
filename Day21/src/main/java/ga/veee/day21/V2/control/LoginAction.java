package ga.veee.day21.V2.control;

import ga.veee.day21.V2.daopack.UserDAOImpl;
import ga.veee.day21.V2.servicepack.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginAction extends Action {
    public LoginAction() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        LoginServiceImpl loginService = LoginServiceImpl.getLoginService();
        loginService.setUserDAO(UserDAOImpl.getUserDaoImpl());

        if (loginService.checkUser(uname, upass)) {
            if (loginService.checkFlag(uname)) {
                loginService.updateFlag(uname, 1);
                return "login.success";
            } else {
                return "login.already";
            }
        } else {
            return "login.register";
        }
    }
}
