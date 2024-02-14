package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopping.entity.Product;
import com.shopping.model.ProductInfo;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductService;
import com.shopping.utils.ProductUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product save(Product p) {
		return productRepository.save(p);
	}

	public Product findProduct(String code) {
		Optional<Product> data = productRepository.findById(code);
		return data.orElse(null);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Page<ProductInfo> getProductsPage(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = productRepository.findAll(pageable);
		Page<ProductInfo> infoPage = pagedResult.map(ProductUtils::convertEntityToInfo);
		return infoPage;
	}

	/**
	 * 分頁物件 PagingAndSortingRepository
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public List<Product> getPageProducts(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Product> pagedResult = productRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Product>();
		}
	}
}
