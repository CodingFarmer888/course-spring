package com.course.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.course.entity.ProductEntity;

public interface ProductQueryRepository extends JpaRepository<ProductEntity, Long> {

	@Query("select p from ProductEntity p where p.name = ?1")
	List<ProductEntity> findByJpql(String name);
	
	@Query("select p from ProductEntity p where p.name = ?1 and p.price >= ?2")
	List<ProductEntity> findByJpqlPosition(String name, BigDecimal price);
	
	@Query("select p from ProductEntity p where p.name = :name and p.price >= :price")
	List<ProductEntity> findByJpqlNamed(@Param("name") String name, @Param("price") BigDecimal price);
	
	@Query(value = "select p.* from product p where p.name = ?1", nativeQuery = true)
	List<ProductEntity> findByNativeSql(String name);
}
