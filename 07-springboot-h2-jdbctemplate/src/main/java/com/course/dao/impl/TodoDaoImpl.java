package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.course.dao.TodoDao;
import com.course.model.TodoItem;

@Repository
public class TodoDaoImpl implements TodoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Override
	public List<TodoItem> findAll() {
		String sql = "SELECT * FROM TODO";
		RowMapper<TodoItem> rowMapper = new RowMapper<>() {
			@Override
			public TodoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				TodoItem item = new TodoItem();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setDueDate(rs.getDate("dueDate"));
				item.setStatus(rs.getInt("status"));
				return item;
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insert(TodoItem todoItem) {
		String sql = "INSERT INTO TODO (TITLE, DUEDATE, STATUS) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, todoItem.getTitle(), todoItem.getDueDate(), todoItem.getStatus());
	}
	
	@Override
	public Integer update(TodoItem todoItem) {
		String sql = "UPDATE TODO SET TITLE = ?, DUEDATE = ?, STATUS = ? WHERE ID = ?";
		return jdbcTemplate.update(sql, todoItem.getTitle(), todoItem.getDueDate(), todoItem.getStatus(), todoItem.getId());
		
	}

	@Override
	public Integer delete(Integer id) {
		String sql = "DELETE FROM TODO WHERE ID = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public TodoItem findById(Integer id) {
		String sql = "SELECT * FROM TODO WHERE ID = ?";
		// 使用 Lambda
		RowMapper<TodoItem> rowMapper = (rs, rowNum) -> {
			TodoItem item = new TodoItem();
			item.setId(rs.getInt("id"));
			item.setTitle(rs.getString("title"));
			item.setDueDate(rs.getDate("dueDate"));
			item.setStatus(rs.getInt("status"));
			return item;
		};
		TodoItem item = null;
	    try {
	    	item = jdbcTemplate.queryForObject(sql, rowMapper, id);
	    } catch (EmptyResultDataAccessException e) {
	        // 找不到資料，需要try catch EmptyResultDataAccessException
	    }
		
		return item;
	}

}
