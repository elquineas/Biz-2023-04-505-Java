package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1{
	private StudentService stService;
	public ScoreServiceImplV2() {
		scList = new ArrayList<>();
		stService = new StudentServiceImplV3();
	}
	
	@Override
	public void loadScore() {
		String scoreFile 	= "src/com/callor/classes/datas/score.csv";
		String saveFile 	= "src/com/callor/classes/datas/score-save.csv";
		Scanner fileScan = null;
		
		InputStream is = null;
		try {
			is = new FileInputStream(scoreFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(scoreFile + " 파일이 없습니다.");
		}
		
		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			String score = fileScan.nextLine();
			ScoreDto scDto = str2Dto(score);
			scList.add(scDto);
		}
		fileScan.close();
	}
	

	@Override
	public void printScore() {
		stService.loadStudent();
		
		System.out.println(Line.dLine(100));
		System.out.print("학번\t");
		System.out.print("이름\t");
		System.out.print("학과\t\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("음악\t");
		System.out.print("미술\t");
		System.out.print("소프트웨어\t");
		System.out.print("데이터베이스\n");
		System.out.println(Line.sLine(100));
		
		for(ScoreDto dto : scList) {
			StudentDto stDto = stService.getStudent(dto.getStNum());
			System.out.print(dto.getStNum() 	+ "\t");
//			System.out.print(dto.getStNum().length() 	+ "\t");
			if(stDto != null) {
				System.out.printf("%s\t",stDto.stName.substring(0, 3));
				System.out.print(stDto.stDept	 	+ "\t");
			}else {
				System.out.print("-\t");
				System.out.print("-\t\t");
			}
			System.out.print(dto.getScKor() 	+ "\t");
			System.out.print(dto.getScEng() 	+ "\t");
			System.out.print(dto.getScMath() 	+ "\t");
			System.out.print(dto.getScMusic() 	+ "\t");
			System.out.print(dto.getScArt() 	+ "\t");
			System.out.print(dto.getScSoftWare()+ "\t\t");
			System.out.print(dto.getScDataBase()+ "\n");
		}
		System.out.println(Line.dLine(100));
	}
}
