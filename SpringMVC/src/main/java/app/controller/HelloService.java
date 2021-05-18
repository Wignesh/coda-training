package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloService {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {
        return "welcome";
    }
}
