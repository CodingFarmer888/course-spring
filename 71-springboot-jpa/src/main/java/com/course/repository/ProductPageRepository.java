package com.course.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.course.entity.ProductEntity;

public interface ProductPageRepository extends JpaRepository<ProductEntity, Long> {
	
	Page<ProductEntity> findByName(String name, Pageable pageable);
	
	@Query("select p from ProductEntity p where p.name = ?1")
	Page<ProductEntity> queryByName(String name, Pageable pageable);

}
