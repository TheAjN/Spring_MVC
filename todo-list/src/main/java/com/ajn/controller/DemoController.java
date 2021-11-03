package com.ajn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajn.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DemoController {
	
	//== Fields ==
	private final DemoService demoService;
	
	
	//== Constructors ==
	
	@Autowired
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}


	// == Request Methods == 
	
	// http://localhost:8080/todo-list/hello
	@GetMapping("Hello")
//	@RequestMapping(value = "/Hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello";   // Return value should be same as that of inside @GetMapping(_)
	}
	
	
	// http://localhost:8080/todo-list/welcome
	// http://localhost:8080/todo-list/welcome?user=Abhishek_J&age=24  //user and age here are query/Request parameters
	
	@GetMapping("welcome") // here "/" is not needed because it is mentioned in the .addMapping in WebAppInitializer.class (DispatcherServlet)
	public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
		
	//	model.addAttribute("user","Abhishek J");  //"user" is key , "Abhishek J" is value. Here "user" will be mapped to the user in welcome.jsp
		
		model.addAttribute("name", demoService.getHelloMessage(user));
		model.addAttribute("age", age);
		
		// prefix + name + suffix
		// /WEB-INF/view/welcome.jsp
		return "welcome"; // In this case,  welcome returned here is the name of the .jsp file,
						//ie, "welcome" won't be displayed in the browser, but the contents of welcome.jsp will be displayed
	}
	
	// == Model Attributes == 
	
	@ModelAttribute("welcomeMessage") //Another way of adding attributes to the model is by @ModelAttribute, 
	public String welcomeMessage() {  //Where "welcomeMessage" acts as a key and the returned value is the value which will be displayed in the webpage
									//Since this Model attribute method is outside/not encapsulated in any Request method
									// this attribute can be used in any .jsp file 
		log.info("welcomeMessage() called"); 
		
	//	return "Welcome to this Demo Application.";
		return demoService.getWelcomeMessage();
	}
	
}
