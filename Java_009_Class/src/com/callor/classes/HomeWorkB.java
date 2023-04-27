package com.callor.classes;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWorkB {
	public static void main(String[] args) {
		String[] names1 = new String[10];
		
		// 각 문자열 배열의 요소에 이름을 저장하기
		// DB로 부터 가져온 데이터, 
		// 키보드 등으로 프로젝트가 실행되는 중에 생성된 데이터를
		// 배열에 저장하는 방법
		names1[0] = "홍길동";
		names1[1] = "이몽룡";
		names1[2] = "성춘향";
		names1[3] = "장보고";
		names1[4] = "임꺽정";
		names1[5] = "김철수";
		names1[6] = "김희경";
		names1[7] = "이기동";
		names1[8] = "박철수";
		names1[9] = "한동후";
		
		// ={}; 에 표시된 요소들을 기본 값으로 하여
		// names 배열 생성하기
		// names 배열의 요소에 저장할 값이 미리 확정된 경우
		String[] names = {
				"홍길동","이몽룡","성춘향","장보고","임꺽정",
				"김철수","김희경","이기동","박철수","한동후"
		};

		ScoreDto[] scores = new ScoreDto[names.length];	
		ScoreServiceA sServ = new ScoreServiceA();
		for(int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}
		for(int i = 0; i < scores.length; i++) {
			// names 배열에 저장된 학생이름을 순서대로
			// scores 배열 요소의 stName 속성에 복사하기
			scores[i].stName	= names[i];
//			scores[i].stNum		= (i+1)+"";
			scores[i].stNum		= String.format("S%04d",(i+1));
			
			// 각 학생의 과목 성적을 핸덤수 샘플데이터로 세팅하기
			scores[i].scKor		= sServ.getScore();
			scores[i].scEng		= sServ.getScore();
			scores[i].scMath	= sServ.getScore();
		}
		
		System.out.println("=".repeat(55));
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("-".repeat(55));
		for(int i = 0; i < scores.length; i++) {
			sServ.scorePrint(scores[i]);
		}
		System.out.println("-".repeat(55));
	}
}
