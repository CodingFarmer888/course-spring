package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.TourService;
import com.course.vo.TourVo;

@CrossOrigin("*")
@RestController
public class TravelController {
	
	@Autowired
	private TourService tourService;

	/**
	 * 查詢全部旅遊資訊
	 * @return
	 */
	@GetMapping("/tours")
	public ResponseEntity<List<TourVo>> getAllTours() {
		List<TourVo> voList = tourService.getAllTours();
		return ResponseEntity.ok(voList);
	}
	
	/**
	 * 查詢全部旅遊資訊 並 分頁
	 * @param pageNo
	 * @return
	 */
	@GetMapping("/tours/p/{pageNo}")
	public ResponseEntity<Page<TourVo>> getAllToursPagination(@PathVariable Integer pageNo) {
		Page<TourVo> voList = tourService.getAllToursByPageNo(pageNo);
		return ResponseEntity.ok(voList);
	}
	
	/**
	 * 關鍵字查詢旅遊資訊
	 * @param keyword
	 * @return
	 */
	@GetMapping("/tours/{keyword}")
	public ResponseEntity<List<TourVo>> searchByKeyword(@PathVariable String keyword) {
		List<TourVo> voList = tourService.findByKeyword(keyword);
		return ResponseEntity.ok(voList);
	}
	
	/**
	 * 關鍵字查詢旅遊資訊 並 分頁
	 * @param keyword
	 * @param pageNo
	 * @return
	 */
	@GetMapping("/tours/{keyword}/p/{pageNo}")
	public ResponseEntity<Page<TourVo>> searchByKeywordPagination(@PathVariable String keyword, @PathVariable Integer pageNo) {
		Page<TourVo> voList = tourService.findByKeywordAndPageNo(keyword, pageNo);
		return ResponseEntity.ok(voList);
	}
	
	/**
	 * 取得高光旅遊列表
	 * @return
	 */
	@GetMapping("/highLight")
	public ResponseEntity<List<TourVo>> getHighLightTour() {
		List<TourVo> voList = tourService.getHighLight();
		return ResponseEntity.ok(voList);
	}
}
