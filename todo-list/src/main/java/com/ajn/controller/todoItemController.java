package com.ajn.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	public todoItemController(todoItemService todoItemService) {
		this.todoItemService = todoItemService;
	}

	// == model attributes ==
	@ModelAttribute // Here the name of the model attribute will be todoData(green) (name of the
					// method name, not the type)
	public todoData todoData() {
		// return new todoData();
		return todoItemService.getData(); 
	}

	// == handler methods ==
	// http://localhost:8080/todo-list/items
	@GetMapping(Mappings.ITEMS)
	public String items() {
		return ViewNames.ITEMS_LIST;
	}

	@GetMapping(Mappings.ADD_ITEM) // First this method is called to show the webpage to add an item,
	public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {

		log.info("Editing id = {}", id);

		todoItem todoItem = todoItemService.getItem(id);

		if (todoItem == null) {
			todoItem = new todoItem("", "", LocalDate.now());
		}

		model.addAttribute(AttributeNames.TODO_ITEM, todoItem); // An empty instance is required for the client to add
																// values in it, then the instance goes
		// to POST request method after the user
		// clicks "Submit" with the initialized instance, hence the instance being added
		// inside todoData via
		// todoItemService
		return ViewNames.ADD_ITEM; // goes to add_item.jsp, where the details will be added
	}

	@PostMapping(Mappings.ADD_ITEM) // once we click "Submit", the form redirects to this POST method (add_item.jsp
									// --> @PostMapping(Mappings.ADD_ITEM))
	public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) todoItem todoItem) { // the name mentioned
																								// inside
																								// @ModelAttribute
		log.info("TodoItem From Form =  {}", todoItem); // should match to the name inside the form of add_item.jsp

		if (todoItem.getId() == 0) {

			todoItemService.addItem(todoItem); // the details are added to the service layer
			
		} else {
			todoItemService.updateItem(todoItem);
		}
		
		return "redirect:/" + Mappings.ITEMS; // the page redirects to the items url to get/display the items.jsp
												// ie the updated values with we added in addEditItem() Request
											// method

	}

	@GetMapping(Mappings.DELETE_ITEM)
	public String deleteItem(@RequestParam int id) {
		log.info("Deleting item with id = {}", id);
		todoItemService.removeItem(id);
		return "redirect:/" + Mappings.ITEMS;
	}
	
	@GetMapping(Mappings.VIEW_ITEM)
	public String viewItem(@RequestParam int id, Model model) {
		log.info("Viewing a single item of id = {}",id);
		model.addAttribute(AttributeNames.TODO_ITEM, todoItemService.getItem(id));	
		return ViewNames.VIEW_ITEM;
	}

}
