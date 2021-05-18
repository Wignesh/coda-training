package com.example.SpringWeb4_0.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = "showLoginPage", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelAndView mv) {
        LoginForm loginForm = new LoginForm();
        mv.addObject("loginForm", loginForm);
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "submitLoginForm", method = RequestMethod.POST)
    public ModelAndView submitForm(ModelAndView mv, @Valid LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            mv.setViewName("login");
            return mv;
        }
        System.out.println(loginForm.getUname() + " " + loginForm.getUpass());
        mv.addObject("loginBean", loginForm);
        mv.setViewName("welcome");
        return mv;
    }
}
