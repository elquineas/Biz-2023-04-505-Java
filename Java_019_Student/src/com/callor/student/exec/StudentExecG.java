package com.callor.student.exec;

import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2;
import com.callor.student.utils.Line;

public class StudentExecG {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println(Line.dLine(100));
			System.out.println("대한고교 학사관리 2023");
			System.out.println(Line.dLine(100));
			System.out.println("실행할 업무를 선택하세요.");
			System.out.println(Line.sLine(100));
			System.out.println("1. 학생 리스트 확인");
			System.out.println("2. 학생정보 추가/수정");
			System.out.println("3. 학생정보 삭제");
			System.out.println("9. 업무종료");
			System.out.println(Line.sLine(100));
			System.out.print("업무선택 >> ");
			String str = scan.nextLine();
//			System.out.println(str);
			if(str.equals("1")) {
				stService.loadStudent();
				stService.printStudent();
			}else if(str.equals("2")) {
				((StudentServiceImplV2)stService).insertStudent();
			}else if(str.equals("3")) {
				((StudentServiceImplV2)stService).deleteStudent();
			}else if(str.equals("9")) {
				System.out.println("업무를 종료합니다.");
				return;
			}
		}
		
	}
}
