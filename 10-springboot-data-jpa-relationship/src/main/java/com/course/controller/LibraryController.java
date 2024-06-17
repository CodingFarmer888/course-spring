package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/code/{code}")
	public Library getLibraryByCode(@PathVariable String code) {
		
		return libraryService.getLibraryByCode(code);
	}
	
	@GetMapping("/city")
	public List<City> getAllCity() {
		return cityService.getAllCity();
	}
}
