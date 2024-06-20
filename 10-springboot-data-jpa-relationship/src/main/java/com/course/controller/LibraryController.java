package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.City;
import com.course.entity.Library;
import com.course.service.CityService;
import com.course.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@GetMapping("/code/{code}")
	public Library getLibraryByCode(@PathVariable String code) {
		
		return libraryService.getLibraryByCode(code);
	}
	
	@PostMapping("/{libraryCode}/book/{bookId}")
	public Library addBookToLibrary(@PathVariable String libraryCode, @PathVariable Long bookId) {
		return libraryService.addBookToLibrary(libraryCode, bookId);
	}
	
	@PostMapping("/")
	public Library addLibrary(String code, String name, String cityCode) throws Exception {
		return libraryService.addLibrary(code, name, cityCode);
	}

}
