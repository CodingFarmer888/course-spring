package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vo.UserVo;

@Controller
// 注解於類別上的RequestMapping，用於對整個類別的請求映射進行設置
// @RequestMapping("/user")
public class LoginController {

	// @RequestMapping(value = "/login")
	public String login() {
		String username = "abc1";
		if (username.equals("abc")) {
			// 檢查帳號密碼成功，導向登入成功頁
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
	
	
	// URL: /h1 /h2
	@RequestMapping(value = {"/h1", "/h2"})
	public String h1() {
		return "loginSuccess";
	}

	// "?" 匹配一個字元 test1, test2 -> OK, test10 -> NO
	@RequestMapping("/pattern/test?")
	public String pattern1() {
		System.out.println("Pattern: /pattern/test?");
		return "loginSuccess";
	}
	
	// "*" 匹配多個字元 test10, test100 -> OK
	@RequestMapping("/pattern/test*")
	public String pattern2() {
		System.out.println("Pattern: /pattern/test*");
		return "loginSuccess";
	}
	
	// "**" 匹配零個或多個路徑，路徑名稱任意 /abcd, /abcd/defg -> OK
	@RequestMapping("/pattern/**")
	public String pattern3() {
		System.out.println("Pattern: /pattern/**");
		return "loginSuccess";
	}
	
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	@GetMapping("/get")
	public String getMapping() {
		System.out.println("@GetMapping");
		return "loginSuccess";
	}
	

	/** 前端後端傳遞資料 */
	
	@RequestMapping(value = "/loginHttpServletRequest")
	public String loginRequest(HttpServletRequest req) {
		// 取得QueryString的參數值
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		req.setAttribute("user", "佛殺凱蒂貓");
		return "loginSuccess";
	}
	
	// 使用 @RequestParam 取得資料，如果名稱相同，可以不添加 @RequestParam
	@RequestMapping(value = "/loginRequestParam")
	public String loginRequestParam(@RequestParam String username, @RequestParam String password) {
		return "loginSuccess";
	}
	
	// 請求參數的參數名跟映射方法的參數名只要保持一致，就會自動將URL的請求參數與控制器方法的參數進行映射
	@RequestMapping(value = "/login")
	public String login(@RequestParam(value="username", required = true, defaultValue = "XXX") String name, String password) {
		System.out.println("name:" + name);
		System.out.println("password:" + password);
		if (name.equals("abc")) {
			// 檢查帳號密碼成功，導向登入成功頁
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
	
	@RequestMapping("/param/hobby")
	public String getHobby(String nickname, @RequestParam(value = "phone", required = true) String mobile, String[] hobby) {
		System.out.println(nickname);
		System.out.println(mobile);
		
		for (String h : hobby) {
			System.out.println(h);			
		}
		return "loginSuccess";
	}
	
	@RequestMapping("/param/class")
	public String getHobby(UserVo userVo) {
		System.out.println(userVo);
		return "loginSuccess";
	}
	
	// 使用Model傳遞資料
	@RequestMapping(value = "/loginModel")
	public String loginModel(String username, String password, Model model) {
		model.addAttribute("user", "佛殺凱蒂貓二世");
		return "loginSuccess";
	}
	
	
	// 使用 ModelAttribute 傳遞資料
	@RequestMapping(value = "/loginModelAttribute")
	public String loginModel(@ModelAttribute("user") UserVo user) {
		// ModelAttribute 有Model的功能
		// model.addAttribute("user", user.getUsername());
		return "loginSuccess";
	}
	
	@ModelAttribute("user2")
	public UserVo getUser() {
		UserVo user = new UserVo();
		user.setUsername("Hello snoopy");
		return user;
	}
	
	// 使用 ModelAndView 傳遞資料
	@RequestMapping(value = "/loginModelAndView")
	public ModelAndView loginModelAndView(UserVo user) {
		ModelAndView mv = new ModelAndView();
		// 設置視圖名稱
		mv.setViewName("loginSuccess");
		// 添加模型資料
		mv.addObject("user", user);
		return mv;
	}
	
	
	/** PathVariable */
	
	// 匹配一個路徑並將其捕獲為名稱為 "name" 的變數
	@RequestMapping(value = "/user/{name}")
	public String pathVariable(@PathVariable("name") String username) {
		System.out.println("@PathVariable: " + username);
		return "loginSuccess";
	}
	
	// 將正則表達式作為名稱為 "name" 的路徑變數進行匹配
	@RequestMapping("/user/regex/{name:[a-zA-Z]+}")
	public String pathVariableRegex(@PathVariable("name") String username) {
		System.out.println("Path Variable[a-zA-z]: " + username);
		return "loginSuccess";
	}
	
}
