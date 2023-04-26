package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class ArrayD {
	/*
	 * Class type의 객체(변수) 배열 만들기
	 * ClassName[] object = new ClassName[10]
	 * Class type의 배열은 일반 변수 배열과 달리
	 * 즉시 사용할 수 없다. 동시에 초기화 되지 않는다.
	 * 별도로 배열 요소를 초기화 시키는 코드가 필요하다.
	 */
	public static void main(String[] args) {
		ScoreDto[] scores = new ScoreDto[10];
		ScoreServiceA sServ = new ScoreServiceA();
		
		// Class type의 배열 요소 전체를 객체 요소로 생성하기
		for(int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}
		
		scores[0].stNum		= "0001";
		scores[0].stName	= "홍길동";
		scores[0].scKor		= sServ.getScore();
		scores[0].scEng		= sServ.getScore();
		scores[0].scMath	= sServ.getScore();
		
		System.out.println("=".repeat(55));
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("-".repeat(55));
		sServ.scorePrint(scores[0]);
		System.out.println("=".repeat(55));
		
	}
}
