package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.BookDetail;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

}
