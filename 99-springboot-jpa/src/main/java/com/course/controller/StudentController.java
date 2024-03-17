package com.course.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Book;
import com.course.entity.Course;
import com.course.entity.Student;
import com.course.repository.CourseRepository;
import com.course.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/students")
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/add")
	public void addStudent() {
		Student student = new Student();
		student.setName("費倫");
		
		Book book1 = new Book();
		book1.setName("風之名");
		
		Book book2 = new Book();
		book2.setName("風之名2-智者之懼");
		
		student.getBooks().add(book1);
		student.getBooks().add(book2);
		
		studentRepository.save(student);
		
	}
	
	@PostMapping("/update")
	public void addStudent(Long id) {
		
		Student student = studentRepository.findById(id).orElse(null);
		student.setName("福利蓮");
		
		Set<Book> books = student.getBooks();
		Book book = books.stream().findFirst().orElse(null);
		books.remove(book);
		studentRepository.save(student);
		
	}
	
	@GetMapping("/course/{id}")
	public Course findCourse(@PathVariable("id") Long id) {
		return courseRepository.findById(id).orElse(null);
	}

}
