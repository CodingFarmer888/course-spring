package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.course.vo.Employee;

@Mapper
public interface EmployeeMapper {
	@Insert("insert into employee(name,address,department,gender) values (#{name},#{address},#{department},#{gender})")
	public void add(Employee employee);
	
	
	@Select("select * from employee")
	public List<Employee> getAll();
}
