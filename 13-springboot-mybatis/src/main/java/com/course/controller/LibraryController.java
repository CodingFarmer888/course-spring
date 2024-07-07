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

import com.course.mapper.LibraryMapper;
import com.course.service.LibraryService;
import com.course.vo.LibraryVo;

@RestController
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@GetMapping("/librarys")
	public List<LibraryVo> findAll() {
		return libraryService.findAll();
	}
	
	@PostMapping("/library")
	public void addLibrary(@RequestBody LibraryVo vo) {
		libraryService.addLibrary(vo);
	}
	
	@PutMapping("/library")
	public void updateLibrary(@RequestBody LibraryVo vo) {
		libraryService.updateLibrary(vo);
	}
	
	@DeleteMapping("/library/{id}")
	public void deleteLibrary(@PathVariable Long id) {
		libraryService.deleteLibrary(id);
	}
}
