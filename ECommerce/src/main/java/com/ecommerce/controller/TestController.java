package com.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Customer;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.ProductService;

@RestController
public class TestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
//	@Autowired
//	private ResourceLoader resourceLoader;
	
	@GetMapping(value = "/customer/{id}")
	public void findCustomer(@PathVariable("id") String customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		System.out.println(customer);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> xxx() {
		List<ProductDto> productDtoList = productService.getAllProducts();
		return ResponseEntity.ok(productDtoList);
		
	}
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto dto) {
		productService.addProduct(dto);
		return ResponseEntity.ok("新增商品成功");
	}
	
	@PostMapping(value = "/uploadFile", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> uploadFile(@ModelAttribute ProductDto uploadProductDto) throws IOException {		
		// 複制檔案
		MultipartFile file = uploadProductDto.getImgFile();
		// 上傳檔案原始名稱
		String fileName = file.getOriginalFilename();
		// 前端傳入檔案名稱
//		String fileName = uploadFileVo.getImgName();
		
//		Files.copy(file.getInputStream(), Paths.get("/home/VendingMachine/DrinksImage").resolve(fileName));
		
		
        try {
            // 获取 static 目录的绝对路径
            // String staticPath = ResourceUtils.getFile("classpath:static").getAbsolutePath();
        	// String staticPath = resourceLoader.getResource("classpath:static").getFile().getAbsolutePath();
            //ClassPathResource classPathResource = new ClassPathResource("static");

            // 获取静态资源目录的绝对路径
            // String staticPath = classPathResource.getFile().getAbsolutePath();
            // 构建文件保存路径
            // Path filePath = Path.of(staticPath, "img", fileName);

            
            // 获取当前工作目录，即项目的根目录
            String projectPath = System.getProperty("user.dir");

            // 构建文件保存路径
            Path filePath = Path.of(projectPath, "src", "main", "resources", "static", "img", fileName);

            
            // 确保目录存在
            Files.createDirectories(filePath.getParent());

            // 将文件保存到指定路径
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            productService.addProduct(uploadProductDto);
            
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常
        }
		return ResponseEntity.ok("新增商品成功");
	}

}
