package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.course.dto.InventoryDto;
import com.course.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
	
	@Query("SELECT new com.course.dto.InventoryDto(p.name, s.storeName, i.quantity) "
			+ "FROM InventoryEntity i "
			+ "JOIN StoreEntity s ON s.id = i.storeId "
			+ "JOIN ProductEntity p ON p.id = i.productId "
			+ "WHERE p.code = ?1")
	List<InventoryDto> getInventoryByProductCode(String code);

}
