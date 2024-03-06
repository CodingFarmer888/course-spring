package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.InventoryDto;
import com.course.repository.InventoryRepository;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@GetMapping("/inventory/code/{code}")
	public List<InventoryDto> getInventoryByCode(@PathVariable String code) {
		return inventoryRepository.getInventoryByProductCode(code);
	}
}
