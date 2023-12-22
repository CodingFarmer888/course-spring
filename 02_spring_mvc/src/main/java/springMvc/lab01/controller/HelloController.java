package springMvc.lab01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 1. 宣告是一個 Web Controller
@Controller
public class HelloController {

	// RequestMapping ("/") 
	@RequestMapping(value = "/")
	public String index() {
		// 由於已經在視圖解析器設定前後綴，所以回傳的string會自動加入前後綴並轉往View
		// {/WEB-INF/views/}index{.jsp}
		return "index";
	}
	
	// 2. 開啟一個Api接口(GET /hello)
	// 3. 導頁至success.jsp
	@RequestMapping(value = "/hello")
	public String hello() {
		return "success";
	}
	
	@RequestMapping(value = "/requestGet", method = RequestMethod.GET)
	public String getMethod() {
		return "success";
	}
	
	@GetMapping("/getMapping")
	public String getMapping() {
		return "success";
	}
	
	@PostMapping("/postMapping")
	public String postMapping() {
		return "success";
	}
	
	
}
