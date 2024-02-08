package com.course.service.impl;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.course.entity.TourEntity;
import com.course.repository.TourRepository;
import com.course.service.TourService;
import com.course.vo.TourVo;

@Service
public class TourServiceImpl implements TourService {
	
	/** 每的頁面卡片的最多數量 */
	private static final Integer CARD_PAGE_COUNT = 8;

	@Autowired
	private TourRepository repository;
	
	/**
	 * 查詢所有旅遊
	 */
	@Override
	public List<TourVo> getAllTours() {
		List<TourEntity> entityList = repository.findAll();
		return exchangeToTourVoList(entityList);
	}
	
	/**
	 * 查詢所有旅遊(分頁)
	 */
	@Override
	public Page<TourVo> getAllToursByPageNo(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo, CARD_PAGE_COUNT);
		Page<TourEntity> entityList = repository.findAll(pageable);
		// 使用 Page.map 方法進行轉換
        Page<TourVo> voPage = entityList.map(this::convertToVo);
		return voPage;
	}
	
	/**
	 * 透過關鍵字查詢旅遊
	 * @param keyword
	 */
	@Override
	public List<TourVo> findByKeyword(String keyword) {
		List<TourEntity> entityList = repository.findByTitleContainsOrDescriptContains(keyword, keyword);
		return exchangeToTourVoList(entityList);
	}
	
	/**
	 * 透過關鍵字跟頁數查詢旅遊
	 * @param keyword
	 */
	@Override
	public Page<TourVo> findByKeywordAndPageNo(String keyword, Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo, CARD_PAGE_COUNT);
		Page<TourEntity> entityList = repository.findByTitleContainsOrDescriptContains(keyword, keyword, pageable);
		// 使用 Page.map 方法進行轉換
        Page<TourVo> voPage = entityList.map(this::convertToVo);
		return voPage;
	}
	
	/**
	 * 透過高光旅遊資訊
	 */
	@Override
	public List<TourVo> getHighLight() {
		List<TourEntity> entityList = repository.findByHighLight(true);
		return exchangeToTourVoList(entityList);
	}

	/**
	 * 將整數值轉換成含有千分位的字串
	 * 1000 -> 1,000
	 * @param price
	 * @return
	 */
	private String displayAmount(Integer price) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.TAIWAN);
        return numberFormat.format(price);
	}
	
	/**
	 * 將Entity物件轉換為前端顯示物件
	 * @param entityList
	 * @return
	 */
	private List<TourVo> exchangeToTourVoList(List<TourEntity> entityList) {
		return entityList.stream().map(entity -> {
			return convertToVo(entity);
		}).collect(Collectors.toList());
	}
	
	/**
	 * 將Entity轉換為Vo物件
	 * @param entity
	 * @return
	 */
	private TourVo convertToVo(TourEntity entity) {
		TourVo vo = new TourVo();
		vo.setId(entity.getId());
		vo.setTitle(entity.getTitle());
		vo.setDescript(entity.getDescript());
		vo.setImgName(entity.getImgName());
		vo.setListPrice(entity.getListPrice());
		vo.setListPriceDisplay(displayAmount(entity.getListPrice()));
		vo.setSalesPrice(entity.getSalesPrice());
		vo.setSalesPriceDisplay(displayAmount(entity.getSalesPrice()));
		vo.setHighLight(entity.isHighLight());
		return vo;
	}

}
