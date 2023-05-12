package com.callor.classes.exec;

import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.ScoreServiceImplV1;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class ScoreA {
	public static void main(String[] args) {
		ScoreService scService = new ScoreServiceImplV1();
		
		scService.loadScore();
		scService.printScore();
	}
}
