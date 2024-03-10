package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.StoreEntity;
import com.course.repository.StoreRepository;

@RestController
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	@GetMapping("/store/{storeCode}")
	public StoreEntity getStoreByCode(@PathVariable String storeCode) {
		
		StoreEntity store = storeRepository.findByStoreCode(storeCode);
		
		return store;
	}
	
}
