package com.course.mapper;

import java.util.Date;
import java.util.List;

import com.course.vo.StudentVo;

public interface StudentMapper {

	List<StudentVo> findAll();
	
	List<StudentVo> findByNameLike(String name);
	
	void addStudent(StudentVo student);
	
	void updateStudent(StudentVo student);
	
	void deleteStudent(Long id);
	
	List<StudentVo> findByIf(String name, String sex);
	
	List<StudentVo> findByChoose(String name, String sex);
	
	List<StudentVo> findByWhere(String name, String sex);
	
	List<StudentVo> findByNames(List<String> names);
	
	void updateStudentByCondition(StudentVo student);

	List<StudentVo> findByName(String name, String sex, Date startDate, Date endDate);
	
}
