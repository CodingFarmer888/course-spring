package com.course.mapper;

import java.util.List;

import com.course.vo.StudentVo;

public interface StudentMapper {

	List<StudentVo> findAll();
	
	List<StudentVo> findByNameLike(String name);
	
	void addStudent(StudentVo student);
	
	void updateStudent(StudentVo student);
	
	void deleteStudent(Long id);
	
}
