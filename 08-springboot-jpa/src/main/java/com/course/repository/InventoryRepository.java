package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.course.dto.InventoryDto;
import com.course.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
	
	@Query("select new com.course.dto.InventoryDto(p.name, s.storeName, i.quantity) "
			+ "from InventoryEntity i "
			+ "join StoreEntity s on s.id = i.storeId "
			+ "join ProductEntity p on p.id = i.productId "
			+ "where p.code = ?1")
	List<InventoryDto> getInventoryByProductCode(String code);

}
