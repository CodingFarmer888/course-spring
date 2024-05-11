package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.model.GameInfo;
import com.course.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameInfo gameInfo;
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/newGame")
	public String newGame(Model model) {
		// 取得新遊戲的答案
		String answer = gameService.getAnswer();
		gameInfo.setAnswer(answer);
		
		return "index";
	}
	
	@RequestMapping("/guess")
	public String guess(String guessNum, Model model) {
		System.out.println(gameInfo.getAnswer());
		gameInfo.getGuessHistory().add(guessNum);
		model.addAttribute("gameHistory", gameInfo.getGuessHistory());
		return "index";
	}
}
