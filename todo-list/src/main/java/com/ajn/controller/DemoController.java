package com.ajn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	// http://localhost:8080/todo-list/hello
	@GetMapping("/Hello")
//	@RequestMapping(value = "/Hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello";   // Return value should be same as that of inside @GetMapping(_)
	}
	
}
