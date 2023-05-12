package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.datas.DataSource;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;

/*
 * interface(class)를 implements 한 클래스는
 * interface에 선언된 모든 메서드를 의무적으로 구현해야 한다.
 *   메서드를 한개라도 생략하면 문법오류가 발생한다
 */

public class ScoreServiceImplV1 implements ScoreService{
	protected StudentService stService;
	protected List<ScoreDto> scList;
	private int barNum = 80;
	
	public ScoreServiceImplV1() {
		this.scList 	= new ArrayList<>();
		this.stService  = new StudentServiceImplV1();
	}
	
	public ScoreDto str2Dto(String str) {
		String[] score = str.split(",");
		ScoreDto scDto = new ScoreDto(
				score[DataIndex.SCORE.ST_NUM],
				Integer.valueOf(score[DataIndex.SCORE.SC_KOR]),
				Integer.valueOf(score[DataIndex.SCORE.SC_ENG]),
				Integer.valueOf(score[DataIndex.SCORE.SC_MATH]),
				Integer.valueOf(score[DataIndex.SCORE.SC_MUSIC]),
				Integer.valueOf(score[DataIndex.SCORE.SC_ART]),
				Integer.valueOf(score[DataIndex.SCORE.SC_SOFTWARE]),
				Integer.valueOf(score[DataIndex.SCORE.SC_DATABASE])
		);
		return scDto;
	}
	
	@Override
	public void loadScore() {
		for(String str : DataSource.SCORE) {
			scList.add(str2Dto(str));
		}
	}

	@Override
	public void printScore() {
		stService.loadStudent();
		
//		System.out.println(Line.dLine(100));
		System.out.println("=".repeat(barNum));
		System.out.print("학번\t");
		System.out.print("이름\t");
		System.out.print("학과\t\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("음악\t");
		System.out.print("미술\n");
		System.out.println("-".repeat(barNum));
//		System.out.println(Line.sLine(100));
		
		for(ScoreDto dto : scList) {
			StudentDto stDto = stService.getStudent(dto.getStNum());
			
			System.out.print(dto.getStNum() 	+ "\t");
			if(stDto.stNum != null) {
				System.out.print(stDto.stName	 	+ "\t");
				System.out.print(stDto.stDept	 	+ "\t");
			}else {
				System.out.print("-\t");
				System.out.print("-\t\t");
			}
			System.out.print(dto.getScKor() 	+ "\t");
			System.out.print(dto.getScEng() 	+ "\t");
			System.out.print(dto.getScMath() 	+ "\t");
			System.out.print(dto.getScMusic() 	+ "\t");
			System.out.print(dto.getScArt() 	+ "\n");
		}
		System.out.println("=".repeat(barNum));
	}
	
}
