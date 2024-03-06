package com.course.service;

import java.util.List;

import com.course.entity.InventoryEntity;

public interface InventoryService {

	List<InventoryEntity> getInventoryByProductCode(String code);
}
