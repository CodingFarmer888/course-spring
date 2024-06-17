package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.Library;
import com.course.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	public Library getLibraryByCode(String code) {
		return libraryRepository.findByCode(code);
	}

}
