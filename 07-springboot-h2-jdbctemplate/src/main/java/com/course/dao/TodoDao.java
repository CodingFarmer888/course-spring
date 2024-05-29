package com.course.dao;

import java.util.List;

import com.course.model.TodoItem;

public interface TodoDao {

	List<TodoItem> findAll();
	
	TodoItem findById(Integer id);
	
	void insert(TodoItem todoItem);
	
	void update(TodoItem todoItem);
	
	void delete(TodoItem todoItem);
}
