package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Book;
import com.course.entity.BookDetail;
import com.course.repository.BookRepository;
import com.course.vo.BookVo;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<BookVo> getAllBook() {
		
		List<Book> entityList = bookRepository.findAll();
		
		List<BookVo> voList = entityList.stream().map(book -> {
			BookVo vo = new BookVo();
			vo.setName(book.getName());
			vo.setAuthor(book.getAuthor());
			vo.setPrice(book.getBookDetail().getPrice());
			vo.setDesc(book.getBookDetail().getDescript());
			return vo;
		}).collect(Collectors.toList());
		return voList;
	}
	
	public BookVo addBook(BookVo vo) {
		Book book = addBookTransaction(vo);
        
		BookVo updatedVo = new BookVo();
		updatedVo.setName(book.getName());
		updatedVo.setAuthor(book.getAuthor());
		updatedVo.setPrice(book.getBookDetail().getPrice());
		updatedVo.setDesc(book.getBookDetail().getDescript());
        return updatedVo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	private Book addBookTransaction(BookVo vo) {
        Book book = new Book();
        book.setName(vo.getName());
        book.setAuthor(vo.getAuthor());
        // 必須先新增Book，取得自動遞增的主鍵值，才能在BookDetail新增
        book = bookRepository.save(book);

        // 建立 BookDetail 實體
        BookDetail bookDetail = new BookDetail();
        bookDetail.setPrice(vo.getPrice());
        bookDetail.setDescript(vo.getDesc());
        bookDetail.setBook(book);
        // 如果透過一般屬性欄位新增 BookDetail，bookId 需要自行set
        // bookDetail.setBookId(book.getId());

        // BookDetail 設置到 Book 實體一併更新
        book.setBookDetail(bookDetail);
        book = bookRepository.save(book);
        
        return book;
	}
}
