package com.course.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	// select * from product where code = ?
	List<ProductEntity> findByCode(String code);
	
	// select * from product where code = ? and name = ?
	List<ProductEntity> findByCodeAndName(String code, String name);
	
	// select * from product where code = ? or name = ?
	List<ProductEntity> findByCodeOrName(String code, String name);
	
	// select * from product where price > ?
	List<ProductEntity> findByPriceGreaterThan(BigDecimal price);
	
	// select * from product where price >= ? and price <= ?
	List<ProductEntity> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal minPrice, BigDecimal maxPrice);
	
	// select * from product where price between ? and ?
	List<ProductEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
	
	// select * from product where create_date between ? and ?
	List<ProductEntity> findByCreateDateBetween(Date startDate, Date endDate);
	
	// select * from product where name like ?
	List<ProductEntity> findByNameLike(String name);
	
	// select * from product where name in (?, ?, ?)
	List<ProductEntity> findByNameIn(List<String> nameList);
	
	// select * from product where name like ? order by price desc
	List<ProductEntity> findByNameLikeOrderByPrice(String name);
	
	// select count(*) from product where name = ?
	Integer countByName(String name);

}
