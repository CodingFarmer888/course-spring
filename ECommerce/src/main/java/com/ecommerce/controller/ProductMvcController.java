package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductMvcController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/all")
	public ModelAndView allProducts() {
		List<ProductDto> productDtoList = productService.getAllProducts();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productList");
		mav.addObject("products", productDtoList);
		return mav;
	}
	
	@GetMapping(value = "/toAddProductPage")
	public ModelAndView redirectToAddProductPage() {
		return new ModelAndView("/product/addProduct");
	}
	
	@PostMapping(value = "/add")
	public ModelAndView addProduct(@RequestBody ProductDto dto) {
		productService.addProduct(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/product/addProductSuccess");
		mav.addObject("product", dto);
		return mav;
	}
	
}
