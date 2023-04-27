package com.callor.score.service;

import com.callor.score.model.ScoreDto;

public class ScoreService {
	// 라 - 각 과목의 성적은 51 ~ 100까지 random 정수를 생성합니다
	public static void getScore(ScoreDto score) { 
		score.kor   = (int)(Math.random()*50)+51;
		score.eng   = (int)(Math.random()*50)+51;
		score.math  = (int)(Math.random()*50)+51;
		score.music = (int)(Math.random()*50)+51;
		score.art   = (int)(Math.random()*50)+51;
	}
	
	public static void printScore(ScoreDto score) { 
		System.out.printf("%5s\t ",score.stNum);
		System.out.printf("%3d\t ",score.kor);
		System.out.printf("%3d\t ",score.eng);
		System.out.printf("%3d\t ",score.math);
		System.out.printf("%3d\t ",score.music);
		System.out.printf("%3d\t ",score.art);
		System.out.printf("%3d\t ",score.getTotal(score));
		System.out.printf("%5.2f\t ",score.getAvg(score));
		System.out.println();
	}
	
	public static void printTotalScore(ScoreDto[] score) { 
		ScoreDto total = new ScoreDto();
		for(int i = 0; i< score.length; i++) {
			total.kor   += score[i].kor;
			total.eng   += score[i].eng;
			total.math  += score[i].math;
			total.music += score[i].music;
			total.art   += score[i].art;
		}

		System.out.printf("총점\t ");
		System.out.printf("%3d\t ",total.kor);
		System.out.printf("%3d\t ",total.eng);
		System.out.printf("%3d\t ",total.math);
		System.out.printf("%3d\t ",total.music);
		System.out.printf("%3d\t ",total.art);
		System.out.printf("%3d\t ",total.getTotal(total));
		System.out.printf("\t ");
		System.out.println();
	}
	public static void printTotalAvg(ScoreDto[] score) { 
		ScoreDto total = new ScoreDto();
		for(int i = 0; i< score.length; i++) {
			total.kor   += score[i].kor;
			total.eng   += score[i].eng;
			total.math  += score[i].math;
			total.music += score[i].music;
			total.art   += score[i].art;
		}

		float avg = 0;
		avg += (float)total.kor/score.length;
		avg += (float)total.eng/score.length;
		avg += (float)total.math/score.length;
		avg += (float)total.music/score.length;
		avg += (float)total.art/score.length;
		
		System.out.printf("평균\t ");
		System.out.printf("%5.2f\t ",(float)total.kor/score.length);
		System.out.printf("%5.2f\t ",(float)total.eng/score.length);
		System.out.printf("%5.2f\t ",(float)total.math/score.length);
		System.out.printf("%5.2f\t ",(float)total.music/score.length);
		System.out.printf("%5.2f\t ",(float)total.art/score.length);
		System.out.printf("\t ");
		System.out.printf("%5.2f\t ",avg/5f);
		System.out.println();
	}
	public static void printScoreList(ScoreDto[] score) {
		System.out.println("=".repeat(63));
		System.out.println("* 한울 고교 성적 리스트 *");
		System.out.println("=".repeat(63));
		System.out.printf("학번\t 국어\t 영어\t 수학\t 음악\t 미술\t 총점\t 평균\n");
		System.out.println("-".repeat(63));
		for(int i = 0; i<score.length; i++) {
			printScore(score[i]);
		}
		System.out.println("-".repeat(63));
		printTotalScore(score);
		printTotalAvg(score);
		System.out.println("=".repeat(63));
	}
}
