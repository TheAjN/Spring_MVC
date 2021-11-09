package com.ajn.model;

import java.time.LocalDate;
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
		
		// add some dummy data, using the add item method so it sets the id field
		addItem(new todoItem("first", "first details", LocalDate.now()));
		addItem(new todoItem("second", "second details", LocalDate.now()));
		addItem(new todoItem("third", "third details", LocalDate.now()));
		addItem(new todoItem("fourth", "fourth details", LocalDate.now()));
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

		while(listIterator.hasNext()) {
			todoItem item = listIterator.next();
			
			if(item.getId() == id) {
				listIterator.remove();
				break;
			}
		}
		
	}
	
	public todoItem getItem(int id) {
		
		for(todoItem item: items) {
			if(item.getId() == id) {
				return item;
				
			}
		}
		return null;
	}
	
	public void updateItem(@NonNull todoItem toupdate) {
		
		ListIterator<todoItem> listIterator = items.listIterator();

		while(listIterator.hasNext()) {
			todoItem item = listIterator.next();
			
			if(item.equals(toupdate)) { // Here, the @EqualsAndHashcode annotation, we have specified an id to check if items are 
										//equal or not, if the ids are same, then the existing todoitem instance can be replace/updated
				listIterator.set(toupdate);
				break;
			}
		}
	}
	
	

}
















