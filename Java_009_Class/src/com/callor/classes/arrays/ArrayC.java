package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class ArrayC {
	public static void main(String[] args) {
		ScoreServiceA scoreServ = new ScoreServiceA();
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();
		
		홍길동.stNum  = "0001";
		홍길동.stName = "홍길동";
		이몽룡.stNum  = "0002";
		이몽룡.stName = "이몽룡";
		성춘향.stNum  = "0003";
		성춘향.stName = "성춘향";
		
		홍길동.scKor  = scoreServ.getScore();
		홍길동.scEng  = scoreServ.getScore();
		홍길동.scMath = scoreServ.getScore();
		이몽룡.scKor  = scoreServ.getScore();
		이몽룡.scEng  = scoreServ.getScore();
		이몽룡.scMath = scoreServ.getScore();
		성춘향.scKor  = scoreServ.getScore();
		성춘향.scEng  = scoreServ.getScore();
		성춘향.scMath = scoreServ.getScore();
		
		System.out.println("=".repeat(55));
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("-".repeat(55));
		scoreServ.scorePrint(홍길동);
		scoreServ.scorePrint(이몽룡);
		scoreServ.scorePrint(성춘향);
		System.out.println("-".repeat(55));
		scoreServ.scoreTotalPrint(
				sumScore(홍길동.scKor,이몽룡.scKor,성춘향.scKor),
				sumScore(홍길동.scEng,이몽룡.scEng,성춘향.scEng),
				sumScore(홍길동.scMath,이몽룡.scMath,성춘향.scMath),
				sumScore(홍길동.getTotal(),이몽룡.getTotal(),성춘향.getTotal())
				);
//		System.out.printf("\t \t %3d\t %3d\t %3d\t %3d\n",
//				sumScore(홍길동.scKor,이몽룡.scKor,성춘향.scKor),
//				sumScore(홍길동.scEng,이몽룡.scEng,성춘향.scEng),
//				sumScore(홍길동.scMath,이몽룡.scMath,성춘향.scMath),
//				sumScore(홍길동.getTotal(),이몽룡.getTotal(),성춘향.getTotal()));
		System.out.println("=".repeat(55));
	}
	public static int sumScore(int num1,int num2,int num3) {
		int score = num1+num2+num3;
		return score;
	}
}
