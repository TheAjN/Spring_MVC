package com.ajn.dao;

import com.ajn.config.DataSource;

import java.util.List;

public interface todoDataDAO {

    void setDatasouce(DataSource dataSource);
    List<todoItem> getItems();
    todoItem getItem(int id);
    void addItem(todoItem todoItem);
    void updateItem(todoItem todoItem);
    void removeItem(int id);


}
