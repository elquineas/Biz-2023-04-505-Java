package com.callor.student.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Line;

public class StudentExecA {
	public static void main(String[] args) {
		List<StudentDto> sList = new ArrayList<>();
		StudentDto sDto = new StudentDto();
		Scanner scan = new Scanner(System.in);
		
		System.out.println(Line.dLine);
		System.out.println("학생 정보를 입력해주세요.");
		System.out.println(Line.sLine);
		while(true) {
			System.out.print("학번 >> ");
			sDto.stNum = scan.nextLine();
			System.out.print("이름 >> ");
			sDto.stName = scan.nextLine();
			System.out.print("학과 >> ");
			sDto.stDept = scan.nextLine();
			System.out.print("학년 >> ");
			String grade = scan.nextLine();
			sDto.stGrade = Integer.valueOf(grade);
			System.out.print("전화번호 >> ");
			sDto.stTel = scan.nextLine();
			sList.add(sDto);
			System.out.println(sList.toString());
		}
		
	}
}
