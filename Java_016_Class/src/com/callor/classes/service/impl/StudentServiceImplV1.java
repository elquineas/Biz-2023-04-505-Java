package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService{
	private List<StudentDto> stList;
	private int barNum = 100;
	
	public void StudentServiceImplV1() {
		this.stList = new ArrayList<>(); 
	}
//	public void StudentServiceImplV1(List<StudentDto> stList) {
//		this.stList = stList;
//	}
	
	@Override
	public void loadStudent() {
//		내 코드
		this.stList = new ArrayList<>(); 
		for(int i = 0; i < StdData.Student.length; i++) {
			String[] student = StdData.Student[i].split(",");
			StudentDto stDto = new StudentDto();
			stDto.stNum 	 = student[StdData.ST_NUM];
			stDto.stName 	 = student[StdData.ST_NAME];
			stDto.stDept 	 = student[StdData.ST_DEPT];
			stDto.stGrade 	 = Integer.valueOf(student[StdData.ST_GRADE]);
			stDto.stTel 	 = student[StdData.ST_TEL];
			stDto.stAddress = student[StdData.ST_ADDRESS];
			stList.add(stDto);
		}
//		선생님 코드
//		for(String str : StdData.Student){
//			String[] student = str.split(",");
//			StudentDto stDto = new StudentDto();
//			stDto.stNum 	 = student[StdData.ST_NUM];
//			stDto.stName 	 = student[StdData.ST_NAME];
//			stDto.stDept 	 = student[StdData.ST_DEPT];
//			stDto.stGrade 	 = Integer.valueOf(student[StdData.ST_GRADE]);
//			stDto.stTel 	 = student[StdData.ST_TEL];
//			stDto.stAddress	 = student[StdData.ST_ADDRESS];
//			stList.add(this.stDto);
//		}
	}

	@Override
	public void printStudent() {
		System.out.println("=".repeat(barNum));
		System.out.print(" 학번\t");
		System.out.print(" 이름\t");
		System.out.print("  학과\t\t");
		System.out.print(" 학년\t");
		System.out.print("  전화번호\t\t");
		System.out.print("주소\n");
		System.out.println("-".repeat(barNum));
		for(int i = 0; i< stList.size(); i++) {
			System.out.printf("%s\t"    ,this.stList.get(i).stNum);
			System.out.printf("%s\t"    ,this.stList.get(i).stName);
			System.out.printf("%s\t"  	,this.stList.get(i).stDept);
			System.out.printf("%3d\t"   ,this.stList.get(i).stGrade);
			System.out.printf("%s\t"	,this.stList.get(i).stTel);
			System.out.printf("%s\n"    ,this.stList.get(i).stAddress);
		}
		System.out.println("=".repeat(barNum));
	}
	
	@Override
	public StudentDto getStudent(String stNum) {
		StudentDto stDto = new StudentDto();
		for(int i = 0; i < stList.size(); i++) {
			if(this.stList.get(i).stNum.equals(stNum)) {
				stDto = stList.get(i);
				break;
			}
		}
		
//		선생님 코드
//		for(StudentDto dto : stList){
//			if(dto.stNum.equals(stNum)) {
//				return dto;
//			}
//		}
		return stDto;

	}

}
