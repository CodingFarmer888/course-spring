package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.dto.LibraryDto;
import com.course.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findByCode(String code);

	@Query("SELECT new com.course.dto.LibraryDto(l.code, l.name, c.code, c.name) "
			+ "FROM Library l JOIN City c on c.code = l.cityCode "
			+ "WHERE c.name like ?1")
	List<LibraryDto> getLibraryInCity(String city);
}
