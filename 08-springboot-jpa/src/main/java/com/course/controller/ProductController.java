package com.course.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.ProductEntity;
import com.course.repository.ProductPageRepository;
import com.course.repository.ProductQueryRepository;
import com.course.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductQueryRepository queryRepository;
	
	@Autowired
	private ProductPageRepository pageRepository;
	
	/**
	 * 新增商品
	 * @param code
	 * @param name
	 * @param price
	 * @param imageUrl
	 * @return
	 */
	@PostMapping("/product")
	public ProductEntity insertProduct(@RequestParam String code, @RequestParam String name, @RequestParam String price, @RequestParam String imageUrl) {
		return productService.insertProduct(code, name, price, imageUrl);
	}
	
	/**
	 * 透過ID查詢商品
	 * @param id
	 * @return
	 */
	@GetMapping("/product/{id}")
	public ProductEntity getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	/**
	 * 取得全部商品
	 * @return
	 */
	@GetMapping("/products")
	public List<ProductEntity> getAllProducts() {
		return productService.getAllProducts();
	}
	
	/**
	 * 更新商品資料
	 * @param id
	 * @param code
	 * @param name
	 * @param price
	 * @param imageUrl
	 * @return
	 */
	@PutMapping("/product")
	public ProductEntity updateProduct(@RequestParam Long id, @RequestParam String code, @RequestParam(required = false) String name, @RequestParam(required = false) String price, @RequestParam(required = false) String imageUrl) {
		return productService.updateProduct(id, code, name, price, imageUrl);
	}
	
	/**
	 * 刪除商品
	 * @param id
	 */
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteById(id);
	}
	
	@GetMapping("/findByCode")
	public List<ProductEntity> getByCode(String code) {
		return productService.getByCode(code);
	}
	
	@GetMapping("/findByCodeAndName")
	public List<ProductEntity> getByCodeAndName(String code, String name) {
		return productService.getByCodeAndName(code, name);
	}
	
	@GetMapping("/findByCodeOrName")
	public List<ProductEntity> getByCodeOrName(String code, String name) {
		return productService.getByCodeOrName(code, name);
	}
	
	@GetMapping("/findByPriceGreaterThan")
	public List<ProductEntity> getPriceGreaterThan(@RequestParam String price) {
		return productService.getPriceGreaterThan(price);
	}
	
	@GetMapping("/findByPriceGreaterThanEqualAndPriceLessThanEqual")
	public List<ProductEntity> getPriceGreaterThanEqualAndPriceLessThanEqual(@RequestParam String minPrice, @RequestParam String maxPrice) {
		return productService.getPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice);
	}
	
	@GetMapping("/findByPriceBetween")
	public List<ProductEntity> getPriceBetween(@RequestParam String minPrice, @RequestParam String maxPrice) {
		return productService.getPriceBetween(minPrice, maxPrice);
	}
	
	@GetMapping("/findByCreateDateBetween")
	public List<ProductEntity> getCreateDateBetween(@RequestParam String startDate, @RequestParam String endDate) {
		return productService.getCreateDateBetween(startDate, endDate);
	}
	
	@GetMapping("/findByNameLike")
	public List<ProductEntity> getNameLike(String name) {
		return productService.getNameLike(name);
	}
	
	@GetMapping("/findByNameIn")
	public List<ProductEntity> getNameIn() {
		List<String> nameList = Arrays.asList("EarBuds","P05","P99");
		return productService.getNameIn(nameList);
	}
	
	@GetMapping("/findByNameLikeOrderByPriceDesc")
	public List<ProductEntity> getNameLikeOrderByPrice(String name) {
		return productService.getNameLikeOrderByPrice(name);
	}
	
	@GetMapping("/countByName")
	public Integer countByName(String name) {
		return productService.countByName(name);
	}
	
	@GetMapping("/findByJpql2")
	public List<ProductEntity> getByJqpl(String name, String price) {
		return queryRepository.findByJpqlNamed(name, new BigDecimal(price));
	}
	
	@GetMapping("/findByNativeSql")
	public List<ProductEntity> getByNativeSql(String name) {
		return queryRepository.findByNativeSql(name);
	}
	
	@PostMapping("/updateProductName")
	public Integer updateProductName(@RequestParam String code, @RequestParam String name) {
		return queryRepository.updateProductName(code, name);
	}
	
	@GetMapping("/getAllProductSortByPrice")
	public List<ProductEntity> getAllProductSortByPrice(Integer pageNo, Integer pageCount) {
		// Sort sort = Sort.by("code");
		Sort sort = Sort.by(Direction.DESC, "createDate");
		return pageRepository.findAll(sort);
	}
	
	@GetMapping("/getAllProductByPage")
	public Page<ProductEntity> getAllProductByPage(Integer pageNo, Integer pageCount) {
		Pageable pageable = PageRequest.of(pageNo, pageCount);
		Page<ProductEntity> page = pageRepository.findAll(pageable);
		return page;
	}
	
	@GetMapping("/getProductByNamePageable")
	public Page<ProductEntity> getProductByNamePageable(String name, Integer pageNo, Integer pageCount) {
		Pageable pageable = PageRequest.of(pageNo, pageCount);
		Page<ProductEntity> page = pageRepository.findByName(name, pageable);
		return page;
	}
	
	@GetMapping("/queryByName")
	public Page<ProductEntity> queryByName(String name, Integer pageNo, Integer pageCount) {
		Pageable pageable = PageRequest.of(pageNo, pageCount);
		Page<ProductEntity> page = pageRepository.queryByName(name, pageable);
		return page;
	}
	

}
