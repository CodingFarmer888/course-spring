package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Todo;
import com.course.model.TodoVo;
import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<TodoVo> findAll() {
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
	
	@GetMapping("/todo/status/{status}")
	public ResponseEntity<List<TodoVo>> getListByStatus(@PathVariable Integer status) {
		List<TodoVo> todoList = todoService.findByStatus(status);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/status/{status}/duedate/{duedate}")
	public ResponseEntity<List<TodoVo>> findByStatusAndDueDate(@PathVariable Integer status, @PathVariable("duedate") String dueDate) {
		List<TodoVo> todoList = todoService.findByStatusAndDueDate(status, dueDate);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/duedate/after/{duedate}")
	public ResponseEntity<List<TodoVo>> findByAfterDueDate(@PathVariable("duedate") String dueDate) {
		List<TodoVo> todoList = todoService.findByDueDateGreaterThan(dueDate);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/duedate/after/{startdate}/before/{enddate}")
	public ResponseEntity<List<TodoVo>> findByDateRange(@PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate) {
		List<TodoVo> todoList = todoService.findByDateRange(startDate, endDate);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/duedate/between/{startdate}/{enddate}")
	public ResponseEntity<List<TodoVo>> findByDateBetween(@PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate) {
		List<TodoVo> todoList = todoService.findByDateBetween(startDate, endDate);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/title/{keyword}")
	public ResponseEntity<List<TodoVo>> findByKeyword(@PathVariable("keyword") String keyword) {
		List<TodoVo> todoList = todoService.findByTitleKeyword(keyword);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todos/ids")
	public ResponseEntity<List<TodoVo>> findByIdList(@RequestParam List<Long> ids) {
		List<TodoVo> todoList = todoService.findByIdList(ids);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todos/orderby/duedate")
	public ResponseEntity<List<TodoVo>> findAllOrderByDueDate() {
		List<TodoVo> todoList = todoService.findAllOrderByDueDate();
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todos/startby/{keyword}")
	public ResponseEntity<List<TodoVo>> findByTitleStartingWithOrderByDueDate(@PathVariable("keyword") String keyword) {
		List<TodoVo> todoList = todoService.findByTitleStartingWithOrderByDueDate(keyword);
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/count/duedate/{duedate}")
	public ResponseEntity<Integer> countByDueDate(@PathVariable("duedate") String startDate) {
		Integer count = todoService.countByDueDate(startDate);
		return ResponseEntity.ok(count);
	}
	
	@GetMapping("/todos/complete")
	public ResponseEntity<List<TodoVo>> getCompleteList() {
		List<TodoVo> todoList =  todoService.findAllCompleteList();
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todos/uncomplete/{duedate}")
	public ResponseEntity<List<TodoVo>> getCompleteList(@PathVariable("duedate") String dueDate) {
		List<TodoVo> todoList =  todoService.findUnCompleteList(dueDate);
		return ResponseEntity.ok(todoList);
	}
	
	@PostMapping("/todo/query")
	public Integer updateTodoTitle(@RequestParam Long id, @RequestParam String title) {
		return todoService.updateTodoTitle(id, title);
	}
	
	@GetMapping("/todos/sort")
	public List<TodoVo> findAllAndSort() {
		return todoService.findAllAndSort();
	}
	
	@GetMapping("/todos/page/{pageNumber}/{pageSize}")
	public Page<TodoVo> findAllAndPagination(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize")Integer pageSize) {
		return todoService.pagination(pageNumber, pageSize);
	}
}
