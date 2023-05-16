package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.service.StudentService;
import com.callor.student.utils.Config;
import com.callor.student.utils.Line;

public class StudentServiceImplV1 implements StudentService{
	protected List<StudentDto> stList;
	protected Scanner scan;
	
	public StudentServiceImplV1() {
		stList = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	
	@Override
	public void loadStudent() {
		
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("대한 고교 학생 리스트");
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호");
		System.out.println(Line.sLine(100));
		if(stList == null || stList.size()<1) {
			System.out.println("표시한 데이터가 없음");
			return;
		}
		int index = 0;
		for(StudentDto dto : stList) {
			System.out.printf("%s\t",dto.stNum);
			System.out.printf("%s\t",dto.stName);
			System.out.printf("%s\t",dto.stDept);
			System.out.printf("%d\t",dto.stGrade);
			System.out.printf("%s\n",dto.stTel);
//			if(index != stList.size()) {
//				System.out.println(Line.sLine(100));
//			}
		}
		System.out.println(Line.dLine(100));
	}
	
	public void insertStudent() {
		
		System.out.println(Line.dLine(60));
		while(true) {
			System.out.println("학생 정보 추가(종료/QUIT)");
			System.out.println(Line.sLine(60));
			
			String stNum = null;
			int num = 0;
			while(true) {
				System.out.print("학번(정수) >> ");
				stNum = scan.nextLine();
				try {
					num = (Integer.valueOf(stNum));
					stNum = String.format("%04d",num);
				} catch (Exception e) {
					if(stNum.toUpperCase().equals("QUIT")) break;
					System.out.println("숫자를 입력해주세요");
				}
				if(num > 0 && num<10000) break;
			}
			if(stNum.toUpperCase().equals("QUIT")) break;
			
			System.out.print("이름 >> ");
			String stName = scan.nextLine();
			if(stName.toUpperCase().equals("QUIT")) break;
			
			System.out.print("학과 >> ");
			String stDept = scan.nextLine();
			if(stDept.toUpperCase().equals("QUIT")) break;
			
			String grade;
			while(true) {
				System.out.print("학년 >> ");
				grade = scan.nextLine();
				int grade1 = 0;
				try {
					grade1 = (Integer.valueOf(grade));
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");
				}
				if(grade.toUpperCase().equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
				if(grade1 < 1 || grade1 > 4) {
					System.out.println("1~4 사이의 수를 입력해야합니다.");
					continue;
				}
			}
			if(grade.toUpperCase().equals("QUIT")) break;
			
			System.out.print("전화번호 >> ");
			String stTel = scan.nextLine();
			if(stTel.toUpperCase().equals("QUIT")) break;
			
			StudentDto sDto = new StudentDto();
			sDto.stNum   = stNum;
			sDto.stName  = stName;
			sDto.stDept  = stDept;
			sDto.stGrade = Integer.valueOf(grade);
			sDto.stTel   = stTel;
			
			stList.add(sDto);
			System.out.println(Line.sLine(60));
		}
		
	}

	@Override
	public StudentDto getStudent(String stNum) {
		return null;
	}

	@Override
	public List<StudentDto> getStudentList() {
		return null;
	}

}
