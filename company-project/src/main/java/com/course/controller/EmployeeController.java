package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.EmployeeService;
import com.course.vo.Employee;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Employee employee) {
		service.addEmployee(employee);
		return ResponseEntity.ok("新增成功");
	}

	@GetMapping("/queryAllEmployee")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employeeList = service.queryAllEmployee();
		return ResponseEntity.ok(employeeList);
	}
}