package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.service.ScoreServiceV1;

public class ExecA {
	public static void main(String[] args) {
		ScoreServiceV1 scService = new ScoreServiceV1();
		scService.makeScore();
		scService.printScore();
		
		List<Integer> scoreList = new ArrayList<>();
		
		int result = scService.makeScore(scoreList);
		
	}
}
