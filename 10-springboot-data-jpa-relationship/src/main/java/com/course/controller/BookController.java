package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.BookService;
import com.course.vo.BookVo;

@RequestMapping("/book")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public List<BookVo> getAllBook() {
		return bookService.getAllBook();
	}

	@PostMapping("/")
	public BookVo addBook(@RequestBody BookVo bookVo) {
		return bookService.addBook(bookVo);
	}
}
