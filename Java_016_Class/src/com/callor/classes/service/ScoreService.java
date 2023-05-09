package com.callor.classes.service;

import java.util.List;

import com.callor.classes.models.ScoreDto;

/*
 * Java interface
 * 클래스의 설계도
 * 클래스의 부모 클래스
 */

public interface ScoreService {
	// 코드 블럭이 없는 메서드, 원형만 선언하기
	public void makeScore();
	public void makeScore(List<ScoreDto> scList);
	public void printScore();
	public void printScore(List<ScoreDto> scList);
	
}
