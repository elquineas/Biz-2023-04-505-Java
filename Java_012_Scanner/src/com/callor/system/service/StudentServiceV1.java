package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV1 {
	
	public void inputStudent() {
		StudentDto student = new StudentDto();
		Scanner scan = new Scanner(System.in);
		
		String num;
		String name;
		String dept;
		String grade1;
		String tel;
		int    grede2 = 0;
		
		System.out.println("학생정보를 입력하세요.");
		System.out.print("학번 : ");
		num = scan.nextLine();
		student.setStNum(num);
		
		System.out.print("이름 : ");
		name = scan.nextLine();
		student.setStName(name);
		
		System.out.print("학과 : ");
		dept = scan.nextLine();
		student.setStDept(dept);
		
		while(true) {
			System.out.print("학년 : ");
			grade1 = scan.nextLine();
			try {
				grede2 = Integer.valueOf(grade1);
			}catch(Exception e){
				System.out.println("학년은 정수로만 입력해야 합니다");
				continue;
			}
			if(grede2<1 || grede2>4){
				System.out.println("학년은 1 ~ 4 범위에서 입력해야 합니다");
				continue;
			}
			student.setStGrade(grede2);
			break;
		}
		
		System.out.print("전화번호 : ");
		tel = scan.nextLine();
		student.setStTel(tel);
		System.out.println("===========================");
		
		System.out.println(student.toString()); 
//		System.out.println("학번 : "+student.getStNum());
//		System.out.println("이름 : "+student.getStName());
//		System.out.println("학과 : "+student.getStDept());
//		System.out.println("학년 : "+student.getStGrade());
//		System.out.println("전화번호 : "+student.getStTel());
		System.out.println("===========================");
		
	}
}
