package springMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springMvc.controller.vo.UserVo;

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
	
	// http://localhost:8080/02_spring_mvc/user/testSaveSession
	@GetMapping("/testSaveSession")
	public ModelAndView testSaveSession(HttpSession session) {
		UserVo userVo = new UserVo();
		userVo.setNickname("斬卍凱蒂貓卍佛");
		userVo.setPhone("0910123123");
		session.setAttribute("user", userVo);
		System.out.println("SESSIONID: " +session.getId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginSuccess");
		mav.addObject("user", userVo);
		return mav;
	}
	
	// http://localhost:8080/02_spring_mvc/user/testGetSession
	@GetMapping("/testGetSession")
	public String testGetSession(HttpSession session) {

		UserVo userVo = (UserVo)session.getAttribute("user");
		System.out.println("SESSIONID: " +session.getId());
		System.out.println(userVo);
		return "success";
	}

	
	
}
