package com.ajn.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import lombok.NonNull;

//This class is immutable
public class todoData {

	// == fields ==
	private static int idValue = 1;

	private final List<todoItem> items = new ArrayList<todoItem>();

	// constructor
	public todoData() {
	}

	// == public methods
	public List<todoItem> getItems() {
		return Collections.unmodifiableList(items); // doesn't allow methods outside this class to modify
													// this list, this is because getter method are prone to
													// modifications
		// through Shallow copy, this will prevent it by throwing an unsupported
		// operation exception
	}

	public void addItem(@NonNull todoItem toAdd) { // Similar to the commented code below (use the lombok.NonNull)

//		if(toAdd == null) {
//			throw new NullPointerException("toAdd is a required Parameter");
//		}

		toAdd.setId(idValue);
		items.add(toAdd);
		idValue++;
	}

	public void removeItem(int id) {
		ListIterator<todoItem> listIterator = items.listIterator();	
		boolean quit = false;

		while(listIterator.hasNext()) {
			todoItem item = listIterator.next();
			
			if(item.getId() == id) {
				listIterator.remove();
				break;
			}
		}
		
	}
	
	

}
