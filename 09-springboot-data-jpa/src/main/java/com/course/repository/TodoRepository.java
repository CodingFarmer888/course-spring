package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


}
