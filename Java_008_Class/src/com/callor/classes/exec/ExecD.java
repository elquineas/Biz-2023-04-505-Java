package com.callor.classes.exec;

import com.callor.classes.model.ScoreDto;

public class ExecD {
	public static void main(String[] args) {
		ScoreDto 학생1 = new ScoreDto();
		ScoreDto 학생2 = new ScoreDto();
		ScoreDto 학생3 = new ScoreDto();
		ScoreDto 학생4 = new ScoreDto();
		ScoreDto 학생5 = new ScoreDto();
		학생1.kor	= 100;
		학생2.kor	= 94;
		학생3.kor	= 89;
		학생4.kor	= 79;
		학생5.kor	= 99;
		
		int sum = 학생1.kor + 
				  학생2.kor + 
				  학생3.kor + 
				  학생4.kor + 
				  학생5.kor;
		float avg = sum/5f;
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
		
	}
}
