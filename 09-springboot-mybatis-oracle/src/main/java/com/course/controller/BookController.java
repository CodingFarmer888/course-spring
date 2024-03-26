package com.course.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.mapper.BookMapper;
import com.course.vo.BookVo;

@RestController
public class BookController {
	
	@Autowired
	private BookMapper bookMapper;

	@GetMapping("/books")
	public List<BookVo> findAllBook() {
		return bookMapper.findAll();
	}
	
	@GetMapping("/book/{id}")
	public BookVo findById(@PathVariable Long id) {
		return bookMapper.findById(id);
	}
	
	@PostMapping("/book")
	public void createBook(@RequestBody BookVo book) {
		bookMapper.insert(book);
	}
	
	@PutMapping("/book")
	public void update(@RequestBody BookVo book) {
		bookMapper.update(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteById(@PathVariable Long id) {
		bookMapper.delete(id);
	}
	
	@GetMapping("/books/s/{id}")
	public List<BookVo> findStudentBooks(@PathVariable("id") Long studentId) {
		return bookMapper.findStudentBooks(studentId);
	}
}
