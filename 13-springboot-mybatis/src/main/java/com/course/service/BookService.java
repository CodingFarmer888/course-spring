package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.BookMapper;
import com.course.vo.BookVo;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;
	
	public List<BookVo> getAllBook() {
		return bookMapper.findAll();
	}
	
	public void addBook(BookVo vo) {
		bookMapper.insertBook(vo);
		bookMapper.insertBookDetail(vo);
	}
	
	public List<BookVo> findByConfition(BookVo vo) {
		return bookMapper.findByCondition(vo);
	}
	
	public List<BookVo> findByChoose(BookVo vo) {
		return bookMapper.findByChoose(vo);
	}
	
	public List<BookVo> findByWhere(BookVo vo) {
		return bookMapper.findByWhere(vo);
	}
	
	public List<BookVo> findByNames(List<String> names) {
		return bookMapper.findByNames(names);
	}
	
	public void updateByCondition(BookVo vo) {
		bookMapper.updateByCondition(vo);
	}
}
