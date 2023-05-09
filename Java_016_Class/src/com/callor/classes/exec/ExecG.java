package com.callor.classes.exec;

import com.callor.classes.service.ScoreService;
import com.callor.classes.service.impl.ScoreServiceImplV3;
import com.callor.classes.service.impl.ScoreServiceImplV4;

public class ExecG {
	public static void main(String[] args) {
		
		/*
		 * ScoreService로 객체를 선언하고
		 * ScoreServiceImplV3() 생성자로 객체를 생성한다 
		 * 
		 * ScoreServiceImplV3() 사용하다가 
		 * ScoreServiceImplV4()로 생성자 이름만 바꿔서 사용가능
		 */
		ScoreService scService = new ScoreServiceImplV3();
		scService.makeScore();
		scService.printScore();
		

		ScoreService scService1 = new ScoreServiceImplV4();
		scService1.printScore();
		
	}
}
