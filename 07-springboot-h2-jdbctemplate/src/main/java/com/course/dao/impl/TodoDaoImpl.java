package com.course.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.course.dao.TodoDao;
import com.course.model.TodoItem;

@Repository
public class TodoDaoImpl implements TodoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Override
	public List<TodoItem> findAll() {

		return null;
	}

}
