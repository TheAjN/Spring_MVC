package com.ajn.service;

import org.springframework.stereotype.Service;

import com.ajn.dao.todoDataDAOImpl;
import com.ajn.dao.todoItem;

import lombok.Getter;


@Service
public class todoItemServiceImpl implements todoItemService{

	@Getter
	private final todoDataDAOImpl Data = new todoDataDAOImpl();  //Delegation of classes
	
	@Override
	public void addItem(todoItem todoItem) {
		Data.addItem(todoItem);
	}

	@Override
	public void removeItem(int id) {
		Data.removeItem(id);
		
	}

	@Override
	public todoItem getItem(int id) {
		
		return Data.getItem(id);
	}

	@Override
	public void updateItem(todoItem todoItem) {
		Data.updateItem(todoItem);
		
	}

//	@Override
//	public todoData getData() {
//		return new todoData();
//	}
//	
	
}
