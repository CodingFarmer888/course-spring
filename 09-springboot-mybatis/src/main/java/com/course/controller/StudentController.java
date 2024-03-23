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

import com.course.mapper.StudentMapper;
import com.course.vo.StudentVo;

@RestController
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;

	@GetMapping("/stuednts")
	public List<StudentVo> getAllStudent() {
		return studentMapper.findAll();
	}
	
	@GetMapping("/student/{name}")
	public List<StudentVo> findByNameKeyword(@PathVariable String name) {
		String searchName = "%" + name + "%";
		return studentMapper.findByNameLike(searchName);
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody StudentVo student) {
		studentMapper.addStudent(student);
	}
	
	@PutMapping("/student")
	public void updateStudent(@RequestBody StudentVo student) {
		studentMapper.updateStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public void updateStudent(@PathVariable Long id) {
		studentMapper.deleteStudent(id);
	}
}
