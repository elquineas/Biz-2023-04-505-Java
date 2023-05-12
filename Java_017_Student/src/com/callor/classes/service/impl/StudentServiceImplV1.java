package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.datas.DataIndex;
import com.callor.classes.datas.DataSource;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService{
	protected List<StudentDto> stList;
	private int barNum = 100;
	
	public StudentServiceImplV1() {
		this.stList = new ArrayList<>(); 
	}

	@Override
	public void loadStudent() {
//		내 코드
//		stList = new ArrayList<>(); 
		for(int i = 0; i < DataSource.STUDENT.length; i++) {
			String[] student = DataSource.STUDENT[i].split(",");
			StudentDto stDto = new StudentDto();
			stDto.stNum 	 = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName 	 = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept 	 = student[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade 	 = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel 	 = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress  = student[DataIndex.STUDENT.ST_ADDRESS];
			stList.add(stDto);
		}
//		선생님 코드
//		for(String str : DataSource.STUDENT){
//			String[] student = str.split(",");
//			StudentDto stDto = new StudentDto();
//			stDto.stNum 	 = student[DataIndex.STUDENT.ST_NUM];
//			stDto.stName 	 = student[DataIndex.STUDENT.ST_NAME];
//			stDto.stDept 	 = student[DataIndex.STUDENT.ST_DEPT];
//			stDto.stGrade 	 = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
//			stDto.stTel 	 = student[DataIndex.STUDENT.ST_TEL];
//			stDto.stAddress	 = student[DataIndex.STUDENT.ST_ADDRESS];
//			stList.add(stDto);
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
