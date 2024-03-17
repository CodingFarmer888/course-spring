package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	

}
