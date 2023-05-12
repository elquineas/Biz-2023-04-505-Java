package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV2 implements StudentService{
	private List<StudentDto> stList;
	private int barNum = 100;
	
	public StudentServiceImplV2() {
		stList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		String studentFile 	= "src/com/callor/classes/datas/student.csv";
		String saveFile 	= "src/com/callor/classes/datas/student-save.csv";
		Scanner fileScan = null;
		
		InputStream is = null;
		try {
			is = new FileInputStream(studentFile);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			String student = fileScan.nextLine();
			String[] stData = student.split(",");
			StudentDto stDto = new StudentDto();
			stDto.stNum 	 = stData[DataIndex.STUDENT.ST_NUM];
			stDto.stName 	 = stData[DataIndex.STUDENT.ST_NAME];
			stDto.stDept 	 = stData[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade 	 = Integer.valueOf(stData[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel 	 = stData[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress  = stData[DataIndex.STUDENT.ST_ADDRESS];
			stList.add(stDto);
		}
		fileScan.close();
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(barNum));
		System.out.print(" 학번\t");
		System.out.print(" 이름\t\t");
		System.out.print("  학과\t\t");
		System.out.print(" 학년\t");
		System.out.print("  전화번호\t\t");
		System.out.print("주소\n");
		System.out.println(Line.sLine(barNum));
		for(int i = 0; i< stList.size(); i++) {
			System.out.printf("%s\t"    ,this.stList.get(i).stNum);
			System.out.printf("%s  \t"  ,this.stList.get(i).stName);
			System.out.printf("%s\t"  	,this.stList.get(i).stDept);
			System.out.printf("%3d\t"   ,this.stList.get(i).stGrade);
			System.out.printf("%s\t"	,this.stList.get(i).stTel);
			System.out.printf("%s\n"    ,this.stList.get(i).stAddress);
			if((i+1)%5 == 0) {
				System.out.println(Line.sLine(barNum));
			}
		}
//		System.out.println(Line.dLine(barNum));
	}

	@Override
	public StudentDto getStudent(String stNum) {
		for(int i = 0; i< stList.size(); i++) {
			if(stList.get(i).stNum.equals(stNum)) {
				return stList.get(i);
			}
		}
		return null;
	}

}
