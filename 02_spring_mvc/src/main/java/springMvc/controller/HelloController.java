package springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 宣告是一個 Controller
@Controller
public class HelloController {

	// RequestMapping ("/") 
	@RequestMapping(value = "/")
	public String index() {
		// 由於已經在視圖解析器設定前後綴，所以回傳的string會自動加入前後綴並轉往View
		// {/WEB-INF/views/}index{.jsp}
		return "index";
	}
	
	// URL: /hello
	@RequestMapping(value = "/hello")
	public String hello() {
		return "success";
	}
	
	// URL: /h1 /h2
	@RequestMapping(value = {"/h1", "/h2"})
	public String h1() {
		return "success";
	}
	
	// URL: GET /requestGet
	@RequestMapping(value = {"/requestGet"}, method = RequestMethod.GET)
	public String getMethod() {
		return "success";
	}
	
	// URL: GET /getMapping
	@GetMapping("/getMapping")
	public String getMapping() {
		return "success";
	}
	
	// URL: POST /postMapping
	@PostMapping("/postMapping")
	public String postMapping() {
		return "success";
	}
	
	@PutMapping("/putMapping")
	public String putMapping() {
		return "success";
	}
	
	@DeleteMapping("/deleteMapping")
	public String deleteMapping() {
		return "success";
	}
	
	// URL: GET /login
	@GetMapping(value = "/login")
	public String login() {
		return "success";
	}
	
	@GetMapping("/toLoginPage")
	public String toLogin() {
		return "login";
	}
	
	
}
