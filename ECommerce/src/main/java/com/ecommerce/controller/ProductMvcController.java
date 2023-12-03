package com.ecommerce.controller;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

	@PostMapping(value = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addProduct(@RequestParam("imgFile") MultipartFile imgFile, 
			@RequestParam("productId") String productId,
            @RequestParam("name") String name,
            @RequestParam("brand") String brand,
            @RequestParam("status") Integer status,
            @RequestParam("listPrice") BigDecimal listPrice,
            @RequestParam("salesPrice") BigDecimal salesPrice,
            @RequestParam("imgName") String imgName
            ) {

		// 複制檔案
		// MultipartFile file = dto.getImgFile();
		MultipartFile file = imgFile;
		// 上傳檔案原始名稱
		String fileName = file.getOriginalFilename();
		// 前端傳入檔案名稱
//			String fileName = uploadFileVo.getImgName();

		ProductDto dto = new ProductDto();
		dto.setProductId(productId);
		dto.setName(name);
		dto.setBrand(brand);
		dto.setStatus(status);
		dto.setListPrice(listPrice);
		dto.setSalesPrice(salesPrice);
		dto.setImgName(fileName);
		try {

			// 取得當前專案目錄
			String projectPath = System.getProperty("user.dir");

			// 創建路徑
			Path filePath = Path.of(projectPath, "src", "main", "resources", "static", "img", fileName);

			// 確認目錄存在
			Files.createDirectories(filePath.getParent());

			// 寫檔
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			e.printStackTrace();
			// 处理异常
		}
		productService.addProduct(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/product/addProductSuccess");
		mav.addObject("product", dto);
		return mav;
	}

}
