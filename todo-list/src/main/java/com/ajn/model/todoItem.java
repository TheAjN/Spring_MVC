package com.ajn.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"}) //specifies what fields to use in a hadhcode & equal
public class todoItem {					// removing "title" from the equals and hashcode parameter to avoid duplication of titles when
										//editing title field in webpage, since equality depends on these values( eg - id) the values
										//won't be allowed to edit and instead a duplicate row will be added
	
	
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
