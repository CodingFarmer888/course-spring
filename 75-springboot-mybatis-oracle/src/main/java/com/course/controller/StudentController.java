package com.course.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/students/findByIf")
	public List<StudentVo> findByIf(@RequestParam(required = false) String name, @RequestParam(required = false) String sex) {
		String searchName = StringUtils.isNotBlank(name) ? "%" + name + "%" : StringUtils.EMPTY;
		return studentMapper.findByIf(searchName, sex);
	}
	
	@GetMapping("/students/findByChoose")
	public List<StudentVo> findByChoose(@RequestParam(required = false) String name, @RequestParam(required = false) String sex) {
		String searchName = StringUtils.isNotBlank(name) ? "%" + name + "%" : StringUtils.EMPTY;
		return studentMapper.findByChoose(searchName, sex);
	}
	
	@GetMapping("/students/findByWhere")
	public List<StudentVo> findByWhere(@RequestParam(required = false) String name, @RequestParam(required = false) String sex) {
		String searchName = StringUtils.isNotBlank(name) ? "%" + name + "%" : StringUtils.EMPTY;
		return studentMapper.findByWhere(searchName, sex);
	}
	
	@GetMapping("/students/findByNames")
	public List<StudentVo> findByNames(@RequestParam List<String> names) {
		return studentMapper.findByNames(names);
	}
	
	@PutMapping("/student/updateStudentByCondition")
	public void updateStudentByCondition(@RequestBody StudentVo student) {
		studentMapper.updateStudentByCondition(student);
	}
}
