package com.ajn.service;

import com.ajn.dao.todoDataDAOImpl;
import com.ajn.dao.todoItem;

public interface todoItemService {

	void addItem(todoItem todoItem);
	void removeItem(int id);
	todoItem getItem(int id);
	void updateItem(todoItem todoItem);
	todoDataDAOImpl getData();
	
}
