package com.ajn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ajn.model.todoData;
import com.ajn.util.Mappings;
import com.ajn.util.ViewNames;

@Controller
public class todoItemController {

	// == model attributes ==
	@ModelAttribute //Here the name of the model attribute will be todoData(green) (name of the method name, not the type)
	public todoData todoData() {
		return new todoData();
	}
	
	// == handler methods == 	
	//http://localhost:8080/todo-list/items
	@GetMapping(Mappings.ITEMS)
	public String items() {
		return ViewNames.ITEMS_LIST;
	}
	
}
