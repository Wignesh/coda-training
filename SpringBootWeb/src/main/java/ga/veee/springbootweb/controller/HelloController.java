package ga.veee.springbootweb.controller;


import ga.veee.springbootweb.component.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserComponent userComponent;

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public void setUserComponent(UserComponent userComponent) {
        this.userComponent = userComponent;
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {
        userComponent.addUser();
        return "welcome";
    }

}
