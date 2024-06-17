package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findByCode(String code);
}
