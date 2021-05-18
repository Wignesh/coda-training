package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {
	
	@RequestMapping(value="hai", method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("say Hello method called....");
	}
	
	@RequestMapping(value="hai2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("say Hello method called....");
		return "welcome";
	}
	
	@RequestMapping(value="hai3", method = RequestMethod.GET)
	public ModelAndView sayHello3() {
		System.out.println("say Hello method 333  called....");
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("welcome");
		mandv.addObject("msg","Welcome to spring...........MVC.....");
		return mandv;
	}
	
}
