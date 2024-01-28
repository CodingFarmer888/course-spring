package com.course.service;

import java.util.List;

import com.course.vo.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);
	
	List<Employee> queryAllEmployee();
	
	Employee queryMemberById(Integer id);
}
