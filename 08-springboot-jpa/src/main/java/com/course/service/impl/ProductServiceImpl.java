package com.course.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.ProductEntity;
import com.course.repository.ProductRepository;
import com.course.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductEntity insertProduct(String code, String name, String price, String imageUrl) {
		// TODO: 新增前需要先判斷code是否已經存在，如果已經存在不能讓程式新增
		ProductEntity entity = new ProductEntity();
		entity.setCode(code);
		entity.setName(name);
		entity.setPrice(new BigDecimal(price));
		entity.setCreateDate(new Date());
		entity.setImageUrl(imageUrl);
		entity = productRepository.save(entity);
		return entity;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public ProductEntity getProductById(Long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		return product.orElse(null);
	}

	@Override
	public ProductEntity updateProduct(Long id, String code, String name, String price, String imageUrl) {
		Optional<ProductEntity> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			ProductEntity entity = productOptional.get();
			// 如果沒有傳遞參數，視為不變更資料，id、code不允許變更
			if (name != null) {
				entity.setName(name);
			}

			if (price != null) {
				entity.setPrice(new BigDecimal(price));				
			}

			if (imageUrl != null) {
				entity.setImageUrl(imageUrl);
			}

			return productRepository.save(entity);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	/** --------- QueryMethod ---------- */
	@Override
	public List<ProductEntity> getByCode(String code) {
		return productRepository.findByCode(code);
	}
	
	@Override
	public List<ProductEntity> getByCodeAndName(String code, String name) {
		return productRepository.findByCodeAndName(code, name);
	}

	@Override
	public List<ProductEntity> getByCodeOrName(String code, String name) {
		return productRepository.findByCodeOrName(code, name);
	}

	@Override
	public List<ProductEntity> getPriceGreaterThan(String price) {
		return productRepository.findByPriceGreaterThan(new BigDecimal(price));
	}
	
	@Override
	public List<ProductEntity> getPriceGreaterThanEqualAndPriceLessThanEqual(String minPrice, String maxPrice) {
		return productRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(new BigDecimal(minPrice), new BigDecimal(maxPrice));
	}
	
	@Override
	public List<ProductEntity> getPriceBetween(String minPrice, String maxPrice) {
		return productRepository.findByPriceBetween(new BigDecimal(minPrice), new BigDecimal(maxPrice));
	}

	@Override
	public List<ProductEntity> getCreateDateBetween(String startDate, String endDate) {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        Date end = null;
		try {
			start = dateFormat.parse(startDate + " 00:00:00");
			end = dateFormat.parse(endDate + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return productRepository.findByCreateDateBetween(start, end);
	}


	@Override
	public List<ProductEntity> getNameLike(String name) {
		String condition = "%" + name + "%";
		return productRepository.findByNameLike(condition);
	}

	@Override
	public List<ProductEntity> getNameIn(List<String> nameList) {
		return productRepository.findByNameIn(nameList);
	}

}
