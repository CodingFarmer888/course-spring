package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Book;
import com.course.service.CriteriaService;

@RestController
public class CriteriaController {

	@Autowired
	private CriteriaService criteriaService;
	
	@GetMapping("/criteria/book")
	public List<Book> findByAuthor(@RequestParam String author, @RequestParam(required = false) String keyword) {
		return criteriaService.findBooksByAuthor(author, keyword);
	}
	
}
