package com.ajn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@GetMapping("welcome") // here "/" is not needed because it is mentioned in the .addMapping in WebAppInitializer.class (DispatcherServlet)
	public String welcome(Model model) {
		
		model.addAttribute("user","Abhishek J");  //"user" is key , "Abhishek J" is value. Here "user" will be mapped to the user in welcome.jsp
		
		// prefix + name + suffix
		// /WEB-INF/view/welcome.jsp
		return "welcome"; // In this case,  welcome returned here is the name of the .jsp file,
						//ie, "welcome" won't be displayed in the browser, but the contents of welcome.jsp will be displayed
	}
	
	@ModelAttribute("welcomeMessage") //Another way of adding attributes to the model is by @ModelAttribute, 
	public String welcomeMessage() {  //Where "welcomeMessage" acts as a key and the returned value is the value which will be displayed in the webpage
		
		log.info("welcomeMessage() called"); 
		
		return "Welcome to this Demo Application.";
	}
	
}
