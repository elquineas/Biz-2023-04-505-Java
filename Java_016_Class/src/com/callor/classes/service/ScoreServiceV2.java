package com.callor.classes.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;

/*
 *  데이터 클래스, 서비스 클래스, 연결 클래스
 *  Dto(Data Transfer Object) : 데이터를 저장하는 목적으로 생성하는 코드
 *  Service : 데이터를 가공(데이터 생성, 출력, 연산을 수행)
 *  
 */
public class ScoreServiceV2 {
	private List<ScoreDto> scList;
	private int classNum = 10;

	public ScoreServiceV2() {
	}
	
	public ScoreServiceV2(List<ScoreDto> scoreList) {
		this.scList = scoreList;
	}

	
	
	public void makeScore() {
		this.scList = new ArrayList<>();
//		this.makeScore(scList);
		for (int i = 0; i < this.classNum; i++) {
			ScoreDto scDto = new ScoreDto();
			scDto.setStNum(String.format("%04d", i + 1));
			scDto.setScKor((int) (Math.random() * 50) + 51);
			scDto.setScEng((int) (Math.random() * 50) + 51);
			scDto.setScMath((int) (Math.random() * 50) + 51);
			this.scList.add(scDto);
		}
		System.out.println(this.scList.toString());
	}

	public void makeScore(List<ScoreDto> scList) {
		for (int i = 0; i < this.classNum; i++) {
			ScoreDto scDto = new ScoreDto();
			scDto.setStNum(String.format("%04d", i + 1));
			scDto.setScKor((int) (Math.random() * 50) + 51);
			scDto.setScEng((int) (Math.random() * 50) + 51);
			scDto.setScMath((int) (Math.random() * 50) + 51);
			scList.add(scDto);
		}
	}

}
