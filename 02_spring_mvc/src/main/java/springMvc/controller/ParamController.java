package springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springMvc.controller.vo.UserVo;

@Controller
public class ParamController {

	@RequestMapping("/param")
	public String toParamPage() {
		return "paramExam";
	}
	
	@RequestMapping("/param/hobby")
	public String getHobby(String nickname, @RequestParam(value = "phone", required = true) String mobile, String[] hobby) {
		System.out.println(nickname);
		System.out.println(mobile);
		
		for (String h : hobby) {
			System.out.println(h);			
		}
		return "success";
	}
	
	@RequestMapping("/param/class")
	public String getHobby(UserVo userVo) {
		System.out.println(userVo);
		return "success";
	}
}
