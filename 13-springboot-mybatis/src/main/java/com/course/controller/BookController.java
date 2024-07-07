package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.BookService;
import com.course.vo.BookVo;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookVo> findAllBook() {
		return bookService.getAllBook();
	}
	
	@PostMapping("/book")
	public void createBook(@RequestBody BookVo book) {
		bookService.addBook(book);
	}
	
	@PostMapping("/books/findByCondition")
	public List<BookVo> findByCondition(@RequestBody BookVo vo) {
		return bookService.findByConfition(vo);
	}
	
	@PostMapping("/books/findByChoose")
	public List<BookVo> findByChoose(@RequestBody BookVo vo) {
		return bookService.findByChoose(vo);
	}
	
	@PostMapping("/books/findByWhere")
	public List<BookVo> findByWhere(@RequestBody BookVo vo) {
		return bookService.findByWhere(vo);
	}
	
	@PostMapping("/books/findByNames")
	public List<BookVo> findByNames(@RequestBody List<String> names) {
		return bookService.findByNames(names);
	}
	
	@PostMapping("/books/updateByCondition")
	public void updateByCondition(@RequestBody BookVo vo) {
		bookService.updateByCondition(vo);
	}
}
