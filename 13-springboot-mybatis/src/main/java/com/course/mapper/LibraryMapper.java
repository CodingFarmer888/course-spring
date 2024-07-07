package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.course.vo.LibraryVo;

@Mapper
public interface LibraryMapper {

	List<LibraryVo> findAll();
	
	List<LibraryVo> findAll2();
	
	List<LibraryVo> findAllToResultMap();
	
	void insertLibrary(LibraryVo vo);
	
	void updateLibrary(LibraryVo vo);
	
	void deleteLibrary(Long id);
	
}
