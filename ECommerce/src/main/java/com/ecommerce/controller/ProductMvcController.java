package com.ecommerce.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductMvcController {

	@Value("${app.imgPath}")
	private String imgPath;

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

	/**
	 * 新增商品 Post-Redirect-Get
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> addProduct(@ModelAttribute ProductDto dto) {

		// 取得上傳圖檔
		MultipartFile file = dto.getImgFile();

		byte[] imageBytes = null;
		try {
			// TODO: 以下是註解為存在專案目錄底下的方式，
			// 上傳檔案原始名稱，檔名+副檔名
			// String fileName = file.getOriginalFilename();
			// 創建路徑
			// Path filePath = Path.of(imgPath, fileName);
			// 確認目錄存在
			// Files.createDirectories(filePath.getParent());
			// 寫檔
			// Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			imageBytes = file.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setImageData(imageBytes);
		productService.addProduct(dto);

		// 轉導的URL，productId是為了在 /showProductSuccessPage 重新取得資料
		String redirectUrl = "/product/showProductSuccessPage?productId=" + dto.getProductId();

		// 建立一個重新導向的Http Response
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, redirectUrl);
		return new ResponseEntity<>(headers, HttpStatus.FOUND);
	}

	@GetMapping("/showProductSuccessPage")
	public ModelAndView showProductSuccessPage(@RequestParam("productId") String productId) {
		ProductDto productDto = productService.getProductById(productId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/product/addProductSuccess");
		mav.addObject("product", productDto);
		return mav;
	}
	
	@GetMapping(value = "/search")
	public ModelAndView getPageProducts(
			@RequestParam(defaultValue = "0", required = false) Integer pageNum, 
			@RequestParam(defaultValue = "3", required = false) Integer pageSize,
			@RequestParam(defaultValue = "", required = false) String searchKeyword) {
		List<ProductDto> allProducts = productService.searchProductsWithoutPages(searchKeyword);
		List<ProductDto> productDtoList = productService.getSearchProducts(searchKeyword, pageNum, pageSize);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productList");
		// 將關鍵字往前端傳，顯示於搜尋框
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("productCount", allProducts.size());
		mav.addObject("pageCount", allProducts.size()/pageSize);
		mav.addObject("currentPage", 2);
		mav.addObject("products", productDtoList);
		return mav;
	}

}
