package com.callor.score.exec;

import com.callor.score.model.ScoreDto;
import com.callor.score.service.ScoreServiceV1;

public class ScoreExecv1 {
	public static void main(String[] args) {
		// 10명 학생의 점수를 저장할 객체배열 선언
		ScoreDto[] scoreList = new ScoreDto[10];
		// 객체배열 초기화하기
		for(int i = 0; i<scoreList.length; i++) {
			scoreList[i] = new ScoreDto();
		}
		
		// ScoreService에 있는 method들을 사용하기 위한 준비
		ScoreServiceV1 scService = new ScoreServiceV1();
		// ScoreService 클래스의 scoreList 객체 배열변수에 
		// 생성된 (선언과 초기화가 완료된) scoreList 객체 배열값을
		// 세팅하는 절차
		scService.setScoreList(scoreList);
		
		/*
		 * ScoreService의 scoreList 객체 배열을 
		 * public 으로 하지 않고 private으로 선언한다 
		 * 코드 어디선가 개발자(작성자)가 예기치 않게
		 * scoreList 데이터가 변경되는 것을 방지 
		 */
		//scService.scoreList = new ScoreDto[100];
		
		scService.scoreRndMake();
		scService.scoreListPrint();
		scService.scoreTotalPrint();
		scService.scoreAvgPrint();
		
	}
	
	
}
