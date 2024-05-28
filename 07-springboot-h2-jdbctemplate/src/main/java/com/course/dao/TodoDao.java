package com.course.dao;

import java.util.List;

import com.course.model.TodoItem;

public interface TodoDao {

	List<TodoItem> findAll();
}
