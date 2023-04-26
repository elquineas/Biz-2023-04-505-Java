package com.callor.classes.service;

import com.callor.classes.model.ScoreDto;

public class ScoreServiceA {
	public static int getScore() {
		int score = (int)(Math.random()*50)+51;
		return score;
	}
	
	public static void getStScore(ScoreDto score) {
		ScoreServiceA sServ = new ScoreServiceA();
		score.scKor		= sServ.getScore();
		score.scEng		= sServ.getScore();
		score.scMath	= sServ.getScore();
	}
	
	public void scorePrint(ScoreDto score) {
		System.out.printf("%s\t %s\t %3d\t %3d\t %3d\t %3d\t %5.2f\n",
				score.stNum,
				score.stName,
				score.scKor,
				score.scEng,
				score.scMath,
				score.getTotal(),
				score.getAvg());
	}
	
	public void scoreTotalPrint(ScoreDto[] scores) {
		int kor		= 0;
		int eng		= 0;
		int math	= 0;
		int total	= 0;
		for(int i = 0; i < scores.length; i++) {
			kor		+= scores[i].scKor;
			eng		+= scores[i].scEng;
			math	+= scores[i].scMath;
			total	+= scores[i].getTotal();
		}
		System.out.print("\t \t ");
		System.out.printf("%3d \t",kor);
		System.out.printf("%3d \t",eng);
		System.out.printf("%3d \t",math);
		System.out.printf("%3d \t",total);
	}
	
	public void scoreTotalPrint(int kor, int eng, int math, int total) {
		System.out.printf("\t \t %3d\t %3d\t %3d\t %3d\t \n",
				kor,
				eng,
				math,
				total
				);
	}
}
