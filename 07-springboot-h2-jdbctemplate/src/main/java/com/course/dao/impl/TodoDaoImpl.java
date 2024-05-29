package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "INSERT INTO TODO (TITLE, DUEDATE, STATUS) VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, todoItem.getTitle(), todoItem.getDueDate(), todoItem.getStatus());
	}
	
	

	@Override
	public void update(TodoItem todoItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TodoItem todoItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TodoItem findById(Integer id) {
		String sql = "SELECT * FROM TODO WHERE ID = ?";
		RowMapper<TodoItem> rowMapper = new RowMapper<>() {
			@Override
			public TodoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				TodoItem item = new TodoItem();
				item.setTitle(rs.getString("title"));
				item.setDueDate(rs.getDate("dueDate"));
				item.setStatus(rs.getInt("status"));
				return item;
			}
		};
		
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
