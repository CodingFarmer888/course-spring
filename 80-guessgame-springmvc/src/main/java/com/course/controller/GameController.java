package com.course.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.model.GameInfo;
import com.course.model.ResultBean;
import com.course.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameInfo gameInfo;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("hiddenGuessBlock", true);
		return "index";
	}
	
	@RequestMapping("/newGame")
	public String newGame(Model model) {
		// 取得新遊戲的答案
		String answer = gameService.getAnswer();
		gameInfo.setAnswer(answer);
		gameInfo.setGuessHistory(new ArrayList<>());
		// 清空遊戲歷程
		model.addAttribute("gameHistory", null);
		return "index";
	}
	
	@RequestMapping("/guess")
	public String guess(String guessNum, Model model) {
		// 檢查結果
		ResultBean resultBean = gameService.checkAnswer(gameInfo.getAnswer(), guessNum);
		gameInfo.getGuessHistory().add(resultBean);
		model.addAttribute("gameHistory", gameInfo.getGuessHistory());
		return "index";
	}
}
