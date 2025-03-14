package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.ResultBean;
import com.course.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping(value = {"/newGame", "/playAgain"})
	public String createNewGame() {
		// 產生一組答案
		gameService.genAnswer();
		return "index";
	}
	
	@GetMapping("/guess")
	public String guess(@RequestParam("guessNum") String guessNum, Model model) {
		System.out.println(guessNum);
		boolean isGoal = gameService.checkAnswer(guessNum);
		List<ResultBean> historyList = gameService.getGuessHistory();
		model.addAttribute("historyList", historyList);
		if (isGoal) {
			return "goal";
		} else {
			return "index";
		}
	}
	
	@ModelAttribute("title")
	public String getTitle() {
		return "1A2B 猜數字";
	}
}
