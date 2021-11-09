package com.ajn.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ajn.model.todoData;
import com.ajn.model.todoItem;
import com.ajn.service.todoItemService;
import com.ajn.util.AttributeNames;
import com.ajn.util.Mappings;
import com.ajn.util.ViewNames;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class todoItemController {

	// == fields == 
	private final todoItemService todoItemService;
	
	
	
	public todoItemController(todoItemService todoItemService) {
		this.todoItemService = todoItemService;
	}

	// == model attributes ==
	@ModelAttribute //Here the name of the model attribute will be todoData(green) (name of the method name, not the type)
	public todoData todoData() {
	//	return new todoData();
		return todoItemService.getData();
	}

	// == handler methods == 	
	//http://localhost:8080/todo-list/items
	@GetMapping(Mappings.ITEMS)
	public String items() {
		return ViewNames.ITEMS_LIST;
	}
	
	@GetMapping(Mappings.ADD_ITEM) //First this method is called to show the webpage to add an ite,
	public String addEditItem(Model model) {
		todoItem todoItem = new todoItem("", "", LocalDate.now());
		model.addAttribute(todoItem);
		return ViewNames.ADD_ITEM; //goes to add_item.jsp, where the details will be added
	}
	
	@PostMapping(Mappings.ADD_ITEM) // once we click "Submit", the form redirects to this POST method
	public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) todoItem todoItem) { //the name mentioned inside @ModelAttribute
		log.info("TodoItem From Form =  {}",todoItem);								//should match to the name inside the form of add_item.jsp
		todoItemService.addItem(todoItem); //the details are added to the service layer
		return "redirect:/" + Mappings.ITEMS; //the page redirects to the items url to get/display the items.jsp
											// ie the updated values with we added in addEditItem() Request method
	}
	
	
	
	
	
	
	
	
	
	
	
}
