package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 注解於類別上的RequestMapping，用於對整個類別的請求映射進行設置
// @RequestMapping("/user")
public class LoginController {

	
	@RequestMapping(value = "/login")
	public String login() {
		String username = "abc1";
		if (username.equals("abc")) {
			// 檢查帳號密碼成功，導向登入成功頁
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
}
