package com.course.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.TourEntity;

public interface TourRepository extends JpaRepository<TourEntity, Long> {
	
	/** 透過關鍵字搜尋 */
	public List<TourEntity> findByTitleContainsOrDescriptContains(String titleKeyword, String descriptKeyword);
	
	/** 透過關鍵字搜尋，並分頁 */
	public Page<TourEntity> findByTitleContainsOrDescriptContains(String titleKeyword, String descriptKeyword, Pageable pageable);


	public List<TourEntity> findByHighLight(boolean highLight);
}
