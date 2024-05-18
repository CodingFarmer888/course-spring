package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.course.model.BookVo;

@Controller
public class BookController {

	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		
		mv.addObject("title", "我的書籍");
		
		List<BookVo> bookList = getAllBooks();
		
		mv.addObject("books", bookList);

		return mv;
	}
	
	@GetMapping("/book/{id}")
	public ModelAndView bookDetail(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book");
		BookVo book = getBookById(id);
		mv.addObject("book", book);
		return mv;
	}
	
	private BookVo getBookById(Integer id) {
		List<BookVo> bookList = getAllBooks();
		BookVo book = bookList.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
		return book;
	}
	
	private List<BookVo> getAllBooks() {
		List<BookVo> bookList = new ArrayList<>();
		bookList.add(new BookVo(1, "迷霧之子", "山德森", "mistborn.png"));
		bookList.add(new BookVo(2, "風之名", "派翠克", ""));
		bookList.add(new BookVo(3, "H2", "安達充", ""));
		return bookList;
	}
	
	@PostMapping("/test")
	public String test(String name) {
		System.out.println(name);
		return "index";
	}
}
