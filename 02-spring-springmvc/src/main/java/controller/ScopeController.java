package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import config.UserSession;
import vo.UserVo;

@Controller
public class ScopeController {
	
	@Autowired
	private UserVo userInSession;
	
	@Autowired
	private UserSession mySession;

	@RequestMapping("/setSession")
	public String setUserSession() {
		// userInSession.setUsername("Hello Kitty");
		// System.out.println("setSession: " + userInSession.getUsername());
		
		mySession.setUsername("Hello Snoopy");
		System.out.println("setSession: " + mySession.getUsername());
		return "loginSuccess";
	}
	
	@RequestMapping("/getSession")
	public String getUserSession() {
		// String username = userInSession.getUsername();
		String username = mySession.getUsername();
		System.out.println("getSession: " + username);
		return "loginSuccess";
	}
}
