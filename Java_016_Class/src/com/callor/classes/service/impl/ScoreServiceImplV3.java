package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScData;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;

/*
 * interface(class)를 implements 한 클래스는
 * interface에 선언된 모든 메서드를 의무적으로 구현해야 한다.
 *   메서드를 한개라도 생략하면 문법오류가 발생한다
 */

public class ScoreServiceImplV3 implements ScoreService{
	private StudentService stService;
	private List<ScoreDto> scList;
	private List<StudentDto> stList;
	private int barNum = 80;
	
	public ScoreServiceImplV3() {
		this.scList 	= new ArrayList<>();
		this.stList 	= new ArrayList<>();
		this.stService  = new StudentServiceImplV1();
	}
	@Override
	public void makeScore() {
		for(String str : ScData.SCORE) {
			String[] student = str.split(",");
			ScoreDto scDto = new ScoreDto(
					student[ScData.ST_NUM],
					Integer.valueOf(student[ScData.ST_KOR]),
					Integer.valueOf(student[ScData.ST_ENG]),
					Integer.valueOf(student[ScData.ST_MATH]),
					Integer.valueOf(student[ScData.ST_MUSIC]),
					Integer.valueOf(student[ScData.ST_ART]),
					Integer.valueOf(student[ScData.ST_SOFTWARE]),
					Integer.valueOf(student[ScData.ST_DATABASE])
			);
			scList.add(scDto);
		}
	}

	@Override
	public void makeScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printScore() {
		
		stService.loadStudent();
		
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
		for(ScoreDto dto : scList) {
			StudentDto dto1 = stService.getStudent(dto.getStNum());
			System.out.print(dto.getStNum() 	+ "\t");
			System.out.print(dto1.stName	 	+ "\t");
			System.out.print(dto1.stDept	 	+ "\t");
			System.out.print(dto.getScKor() 	+ "\t");
			System.out.print(dto.getScEng() 	+ "\t");
			System.out.print(dto.getScMath() 	+ "\t");
			System.out.print(dto.getScMusic() 	+ "\t");
			System.out.print(dto.getScArt() 	+ "\n");
		}
		System.out.println("=".repeat(barNum));
	}

	@Override
	public void printScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}
}
