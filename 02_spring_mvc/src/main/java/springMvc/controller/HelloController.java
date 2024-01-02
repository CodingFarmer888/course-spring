package springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 匹配一個字元 test1, test2 -> OK, test10 -> NO
	@RequestMapping("/pattern/test?")
	public String pattern1() {
		return "success";
	}
	
	// 匹配多個字元 test10, test100 -> OK
	@RequestMapping("/pattern/test*")
	public String pattern2() {
		return "success";
	}
	
	// 匹配零個或多個路徑 /abcd, /abcd/defg -> OK
	@RequestMapping("/pattern/**")
	public String pattern3() {
		return "success";
	}
	
	// 匹配一個路徑並將其捕獲為名稱為 "spring" 的變數
//	@RequestMapping("/pattern/path/{spring}")
//	public String pattern4(@PathVariable String spring) {
//		System.out.println("Path Variable: " + spring);
//		return "success";
//	}
	
	// 將正則表達式作為名稱為 "spring" 的路徑變數進行匹配
	@RequestMapping("/pattern/path/{spring:[a-zA-Z]+}")
	public String pattern5(@PathVariable String spring) {
		System.out.println("Path Variable[a-zA-z]: " + spring);
		return "success";
	}
	
}
