package app.controller;


import app.model.LoginForm;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "showLoginPage", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelAndView mandv) {
        LoginForm loginForm = new LoginForm();
        mandv.addObject("loginForm", loginForm);
        mandv.setViewName("login");
        return mandv;
    }

    @RequestMapping(value = "submitform", method = RequestMethod.POST)
    public ModelAndView processLoginPage(ModelAndView mandv, @Valid LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            mandv.setViewName("login");
            return mandv;
        }
        userService.createUser(loginForm);
        System.out.println(loginForm.getUname() + ":" + loginForm.getUpass());
        mandv.addObject("loginBean", loginForm);
        mandv.setViewName("welcome");
        return mandv;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
