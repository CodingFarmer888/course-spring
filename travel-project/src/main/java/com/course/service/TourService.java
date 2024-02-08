package com.course.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.course.vo.TourVo;

public interface TourService {

	public List<TourVo> getAllTours();
	
	public Page<TourVo> getAllToursByPageNo(Integer pageNo);
	
	public List<TourVo> findByKeyword(String keyword);
	
	public Page<TourVo> findByKeywordAndPageNo(String keyword, Integer pageNo);
	
	public List<TourVo> getHighLight();
}
