package com.ajn.dao;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import com.ajn.config.DataSource;
import com.ajn.config.todoItemRowMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//This class is immutable
@Repository
public class todoDataDAOImpl implements todoDataDAO {

	// == fields ==
//	private static int idValue = 1;

	// private final List<todoItem> items = new ArrayList<todoItem>();

	private JdbcTemplate jdbcTemplate;

	// constructor
	public todoDataDAOImpl() {
		
		// add some dummy data, using the add item method so it sets the id field
		/*addItem(new todoItem("first", "first details", Date.from(Instant.now())));
		addItem(new todoItem("second", "second details", Date.from(Instant.now())));
		addItem(new todoItem("third", "third details", Date.from(Instant.now())));
		addItem(new todoItem("fourth", "fourth details", Date.from(Instant.now())));*/
	}

	// == public methods
	@Autowired
	@Override
	public void setDatasouce(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<todoItem> getItems() {
		String sql = "SELECT * FROM todoitem";

		return jdbcTemplate.query(sql, new todoItemRowMapper());

		//return Collections.unmodifiableList(items); // doesn't allow methods outside this class to modify
													// this list, this is because getter method are prone to
													// modifications
		// through Shallow copy, this will prevent it by throwing an unsupported
		// operation exception
	}

	@Override
	public void addItem(@NonNull todoItem toAdd) { // Similar to the commented code below (use the lombok.NonNull)

//		if(toAdd == null) {
//			throw new NullPointerException("toAdd is a required Parameter");
//		}

		//toAdd.setId(idValue);
	//	items.add(toAdd);
	//	idValue++;

		String sql = "INSERT INTO todoitem(title,details,deadLine) VALUES(?, ?, ?, ?, ?)";
		Object[] args = {toAdd.getTitle(),toAdd.getDetails(),toAdd.getDeadLine()};

		jdbcTemplate.update(sql,args);

	}

	@Override
	public void removeItem(int id) {

		String sql = "DELETE FROM todoitem WHERE id =" + id;

		jdbcTemplate.update(sql);

		/*ListIterator<todoItem> listIterator = items.listIterator();

		while(listIterator.hasNext()) {
			todoItem item = listIterator.next();
			
			if(item.getId() == id) {
				listIterator.remove();
				break;
			}
		}*/
		
	}

	@Override
	public todoItem getItem(int id) {

		String sql = "SELECT * from todoitem WHERE id = " + id;

		/*for(todoItem item: items) {
			if(item.getId() == id) {
				return item;
				
			}
		}
		return null;*/

		return jdbcTemplate.queryForObject(sql,new todoItemRowMapper());
	}

	@Override
	public void updateItem(@NonNull todoItem toupdate) {

		String sql = "UPDATE todoitem WHERE id = ?"+ toupdate.getId() ;

		jdbcTemplate.update(sql);

		/*ListIterator<todoItem> listIterator = items.listIterator();

		while(listIterator.hasNext()) {
			todoItem item = listIterator.next();
			
			if(item.equals(toupdate)) { // Here, the @EqualsAndHashcode annotation, we have specified an id to check if items are 
										//equal or not, if the ids are same, then the existing todoitem instance can be replace/updated
				listIterator.set(toupdate);
				break;
			}
		}*/
	}
	
	

}
















