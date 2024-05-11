package com.course.model;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {

	private String answer;
	
	private List<String> guessHistory = new ArrayList<>();


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getGuessHistory() {
		return guessHistory;
	}

	public void setGuessHistory(List<String> guessHistory) {
		this.guessHistory = guessHistory;
	}
	
	
}
