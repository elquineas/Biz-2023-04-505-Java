package com.callor.score;

import com.callor.score.model.ScoreDto;
import com.callor.score.service.ScoreService;

public class Score {
	public static void main(String[] args) {
		// 가 - 학생 수는 10명으로 합니다.
		ScoreDto[] student = new ScoreDto[10]; 
		ScoreService sServ = new ScoreService();
		for(int i = 0; i<student.length; i++) {
			student[i] = new ScoreDto();
		}
		// 다 -  ScoreDto 클래스를 배열로 선언하여 각 학생의 학번과 점수를 저장합니다
		for(int i = 0; i<student.length; i++) {
			student[i].stNum = String.format("23%03d",i+1);
			sServ.getScore(student[i]);
		}
		// 마 - 배열에 저장된 성적정보를 다음과 같이 리스트로 출력합니다.
		sServ.printScoreList(student);
	}
}
