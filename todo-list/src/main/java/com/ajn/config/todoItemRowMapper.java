package com.ajn.config;


import com.ajn.dao.todoItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class todoItemRowMapper implements RowMapper<todoItem> {

    todoItem td = new todoItem();

    @Override
    public todoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        td.setId(rs.getInt("id"));
        td.setTitle(rs.getString("title"));
        td.setDetails(rs.getString("details"));
        td.setDeadLine(rs.getDate("deadLine"));

        return td;
    }
}
