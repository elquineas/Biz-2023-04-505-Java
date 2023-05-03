package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV2 {
	
	private StudentDto[] stList;
	
	public StudentDto[] inputStudents(StudentDto[] stList) {
		Scanner scan = new Scanner(System.in);
		String num;
		String name;
		String dept;
		String grade1;
		String tel;
		int    grede2 = 0;
		
		for(int i = 0; i<stList.length; i++) {
			
			System.out.println("-".repeat(30));
			System.out.println("학생정보를 입력하세요.");
			System.out.print("학번 : ");
			num = scan.nextLine();
			stList[i].setStNum(num);
			
			System.out.print("이름 : ");
			name = scan.nextLine();
			stList[i].setStName(name);
			
			System.out.print("학과 : ");
			dept = scan.nextLine();
			stList[i].setStDept(dept);
			
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
				stList[i].setStGrade(grede2);
				break;
			}
			
			System.out.print("전화번호 : ");
			tel = scan.nextLine();
			stList[i].setStTel(tel);
			
		}

		return stList;
	}
	
	public void printStudents(StudentDto[] stList) {
		System.out.println("=".repeat(55));
		System.out.print("학번\t");
		System.out.print("이름\t");
		System.out.print("학과\t\t");
		System.out.print("학년\t");
		System.out.print("전화번호\n");
		System.out.println("-".repeat(55));
		for(int i = 0; i<stList.length; i++) {
			System.out.printf("%s\t",stList[i].getStNum());
			System.out.printf("%s\t",stList[i].getStName());
			System.out.printf("%s\t",stList[i].getStDept());
			System.out.printf("%3d\t",stList[i].getStGrade());
			System.out.printf("%s\n",stList[i].getStTel());
//			System.out.println(stList[i].toString()); 
		}
		System.out.println("=".repeat(55));
//		for(int i = 0; i<stList.length; i++) {
//			System.out.println(this.stList[i]);
//		}
	}
	
	
	
	public void inputStudents2() {
		Scanner scan = new Scanner(System.in);
		this.stList = new StudentDto[5];
		for(int i = 0; i<stList.length; i++) {
			this.stList[i] = new StudentDto();
		}
		
		String num;
		String name;
		String dept;
		String grade1;
		String tel;
		int    grede2 = 0;
		
		for(int i = 0; i<stList.length; i++) {
			
			System.out.println("-".repeat(30));
			System.out.println("학생정보를 입력하세요.");
			System.out.print("학번 : ");
			num = scan.nextLine();
			stList[i].setStNum(num);
			
			System.out.print("이름 : ");
			name = scan.nextLine();
			stList[i].setStName(name);
			
			System.out.print("학과 : ");
			dept = scan.nextLine();
			stList[i].setStDept(dept);
			
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
				stList[i].setStGrade(grede2);
				break;
			}
			
			System.out.print("전화번호 : ");
			tel = scan.nextLine();
			stList[i].setStTel(tel);
			

			this.stList[i] = stList[i];
		}
	}
	
	public void printStudents2() {
		System.out.println("=".repeat(55));
		System.out.print("학번\t");
		System.out.print("이름\t");
		System.out.print("학과\t\t");
		System.out.print("학년\t");
		System.out.print("전화번호\n");
		System.out.println("-".repeat(55));
		for(int i = 0; i<stList.length; i++) {
			System.out.printf("%s\t",stList[i].getStNum());
			System.out.printf("%s\t",stList[i].getStName());
			System.out.printf("%s\t",stList[i].getStDept());
			System.out.printf("%3d\t",stList[i].getStGrade());
			System.out.printf("%s\n",stList[i].getStTel());
		}
		System.out.println("=".repeat(55));
	}
}
