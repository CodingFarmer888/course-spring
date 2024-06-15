package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Todo;
import com.course.model.TodoVo;
import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> findAll() {
		return todoService.getAllTodoList();
	}
	
	
	@PostMapping("/todo")
	public Todo addTodo(@RequestBody TodoVo todoVo) {
		return todoService.updateTodo(todoVo);
	}
	
	@DeleteMapping("/todo/{id}")
	public void deleteTodo(@PathVariable Long id) {
		todoService.deleteTodoById(id);
	}
	
	@DeleteMapping("/todos/batch")
	public void deleteAllInBatch() {
		todoService.deleteAllInBatch();
	}
	
	@DeleteMapping("/todos")
	public void deleteAll() {
		todoService.deleteAll();
	}
}
