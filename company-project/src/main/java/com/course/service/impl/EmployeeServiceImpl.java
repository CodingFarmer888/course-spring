package com.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.EmployeeMapper;
import com.course.service.EmployeeService;
import com.course.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public void addEmployee(Employee employee) {
		mapper.add(employee);
	}

	@Override
	public List<Employee> queryAllEmployee() {
		return mapper.getAll();
	}

	@Override
	public Employee queryMemberById(Integer id) {
		// TODO
		return null;
	}

}
