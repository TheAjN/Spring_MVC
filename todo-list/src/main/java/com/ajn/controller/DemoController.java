package com.ajn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	// http://localhost:8080/todo-list/hello
	@GetMapping("Hello")
//	@RequestMapping(value = "/Hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello";   // Return value should be same as that of inside @GetMapping(_)
	}
	
	
	// http://localhost:8080/todo-list/welcome
	// prefix + name + suffix
	// /WEB-INF/view/welcome.jsp
	@GetMapping("welcome") // here "/" is not needed because it is mentioned in the .addMapping in WebAppInitializer.class (DispatcherServlet)
	public String welcome() {
		return "welcome"; // In this case,  welcome returned here is the name of the .jsp file,
						//ie, "welcome" won't be displayed in the browser, but the contents of welcome.jsp
	}
	
}
