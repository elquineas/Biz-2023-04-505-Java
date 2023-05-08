package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;
import com.callor.classes.service.ScoreServiceV1;

/*
 * 일반적인 변수(primitive)는 method의 매개변수로 전달할때
 * 변수 자체가 전달되는 것이 아니고 변수의 값("데이터")만 전달된다.
 * 매개변수로 전달받은 method에서 아무리 변수에 값을 변경해도
 * 실제 값은 변경되지 않는다.
 */

public class ScoreB {
	public static void main(String[] args) {
		List<ScoreDto> scoreList = new ArrayList<>();
		ScoreServiceV1 sServ = new ScoreServiceV1();
		
		// 저장된 주소 전달
		sServ.makeScore(scoreList);
//		System.out.println(scoreList.toString());
//		System.out.println(scoreList.get(0));
//		System.out.println(scoreList.get(1));

		sServ.printScore(scoreList);
		
		sServ.sortScore(scoreList);
		sServ.printScore(scoreList);
//		sServ.totalScore(scoreList);
//		sServ.avgScore(scoreList);
//		int num1 = 100;
//		int num2 = 200;
//		 num1, num2에 저장된 값만 전달
//		sServ.add(num1, num2);
//		System.out.printf("%d %d", num1, num2);
	}
}
