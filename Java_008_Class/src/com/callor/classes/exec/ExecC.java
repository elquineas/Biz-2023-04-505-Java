package com.callor.classes.exec;

import com.callor.classes.model.ScoreDto;

public class ExecC {
	public static void main(String[] args) {
		ScoreDto 홍길동	= new ScoreDto();
		ScoreDto 이몽룡	= new ScoreDto();
		ScoreDto 성춘향	= new ScoreDto();
		
		홍길동.stName	= "홍길동";
		홍길동.kor		= 100;
		이몽룡.stName	= "이몽룡";
		이몽룡.kor		= 88;
		성춘향.stName	= "성춘향";
		성춘향.kor		= 99;
		성춘향.eng		= 72;
		성춘향.meth		= 63;
		성춘향.hist		= 74;
		성춘향.music	= 57;
		성춘향.art		= 84;
		성춘향.sport	= 98;
		
		System.out.println("성춘향 국어점수	: "+성춘향.kor);
		System.out.println("성춘향 총점	: "+성춘향.getTotal());
	}
}
