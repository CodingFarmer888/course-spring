package springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	// URL: POST /user/login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		// 檢核帳密是否存在
		if (checkLogin(username, password)) {
			return "loginSuccess";
		} else {
			return "loginError";
		}
	}
	
	/**
	 * 檢核帳密是否存在
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean checkLogin(String username, String password) {
		// Tips: 如果你返回的結果是布林值，建議可以直接 return 判斷式
		// return "aaa".equals(username) && "111".equals(password)
		if ("aaa".equals(username) && "111".equals(password)) {
			return true;
		}
		return false;
	}

	
	
}
