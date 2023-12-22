package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String username, String password) {
		if ("aaa".equals(username) && "1234".equals(password)) {
			return "loginSuccess";
		} else {
			return "loginError";
		}
		
	}
}
