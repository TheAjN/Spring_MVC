package com.ajn.service;

import com.ajn.model.todoData;
import com.ajn.model.todoItem;

public interface todoItemService {

	void addItem(todoItem todoItem);
	void removeItem(int id);
	todoItem getItem(int id);
	void updateItem(todoItem todoItem);
	todoData getData();
	
}
