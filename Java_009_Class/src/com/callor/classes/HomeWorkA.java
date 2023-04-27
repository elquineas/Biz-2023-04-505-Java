package com.callor.classes;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWorkA {
	public static void main(String[] args) {
		ScoreDto[] scores = new ScoreDto[10];
		ScoreServiceA sServ = new ScoreServiceA();
		
		for(int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}
		
		getStudent(scores);
		
		for(int i = 0; i < scores.length; i++) {
			sServ.getStScore(scores[i]);
		}
		
		System.out.println("=".repeat(55));
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("-".repeat(55));
		for(int i = 0; i < scores.length; i++) {
			sServ.scorePrint(scores[i]);
		}
		System.out.println("-".repeat(55));
		sServ.scoreTotalPrint(scores);
		System.out.println("=".repeat(55));
				
	}
	
	public static void getStudent(ScoreDto[] scores) {
		scores[0].stName	= "홍길동";
		scores[0].stNum		= "0001";
		scores[1].stName	= "이몽룡";
		scores[1].stNum		= "0002";
		scores[2].stName	= "성춘향";
		scores[2].stNum		= "0003";
		scores[3].stName	= "장보고";
		scores[3].stNum		= "0004";
		scores[4].stName	= "임꺽정";
		scores[4].stNum		= "0005";
		scores[5].stName	= "김철수";
		scores[5].stNum		= "0006";
		scores[6].stName	= "김희경";
		scores[6].stNum		= "0007";
		scores[7].stName	= "이기동";
		scores[7].stNum		= "0008";
		scores[8].stName	= "박철수";
		scores[8].stNum		= "0009";
		scores[9].stName	= "한동후";
		scores[9].stNum		= "0010";
	}
	
}
