package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.LibraryMapper;
import com.course.vo.LibraryVo;

@Service
public class LibraryService {

	@Autowired
	private LibraryMapper mapper;
	
	public List<LibraryVo> findAll() {
		return mapper.findAll();
		// return mapper.findAll2();
		// return mapper.findAllToResultMap();
	}
	
	public void addLibrary(LibraryVo vo) {
		mapper.insertLibrary(vo);
	}
	
	public void updateLibrary(LibraryVo vo) {
		mapper.updateLibrary(vo);
	}
	
	public void deleteLibrary(Long id) {
		mapper.deleteLibrary(id);
	}
}
