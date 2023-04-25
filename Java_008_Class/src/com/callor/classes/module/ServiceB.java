package com.callor.classes.module;

import com.callor.classes.model.ScoreDto;

public class ServiceB {
	public void score(ScoreDto score) {
		System.out.println("학번 : " + score.stNum);
		System.out.println("이름 : " + score.stName);
		System.out.println("---------------------");
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.meth);
		System.out.println("국사 : " + score.hist);
		System.out.println("음악 : " + score.music);
		System.out.println("미술 : " + score.art);
		System.out.println("체육 : " + score.sport);
		
//		int total = score.kor;
//		total += score.eng;
//		total += score.meth;
//		total += score.hist;
//		total += score.music;
//		total += score.art;
//		total += score.sport;
		int total = score.getTotal();
//		float avg = total/7f;
		float avg = score.getAvg();
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	}
}
