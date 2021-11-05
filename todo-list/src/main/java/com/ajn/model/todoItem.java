package com.ajn.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id","title"}) //specifies what fields to use in a hadhcode & equals
public class todoItem {
	
	
	// == fields == 
	private int id;
	private String title;
	private String details;
	private LocalDate deadLine; //Gives the date
	
	
	// == constructor == 
	public todoItem(String title, String details, LocalDate deadLine) {
		this.title = title;
		this.details = details;
		this.deadLine = deadLine;
	}

	
	
}
