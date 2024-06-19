package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.Book;
import com.course.entity.Library;
import com.course.repository.BookRepository;
import com.course.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Library getLibraryByCode(String code) {
		return libraryRepository.findByCode(code);
	}

	public Library addBookToLibrary(String libraryCode, Long bookId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		Library library = libraryRepository.findByCode(libraryCode);
		library.getBooks().add(book);
		libraryRepository.save(library);
		return library;
	}
}
