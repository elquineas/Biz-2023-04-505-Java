package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.datas.DataSource;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV3 implements StudentService{
	protected List<StudentDto> stList;
	public StudentServiceImplV3() {
		stList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		String studentFile = "src/com/callor/classes/datas/student.csv";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(studentFile + " 파일이 없습니다 확인하세요");
			return;
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String student = scan.nextLine();
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
		scan.close();
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.print(" 학번\t");
		System.out.print(" 이름\t\t");
		System.out.print("  학과\t\t");
		System.out.print(" 학년\t");
		System.out.print("  전화번호\t\t");
		System.out.print("주소\n");
		System.out.println(Line.sLine(100));
		int row = 0;
		for(StudentDto stDto : stList){
			System.out.printf("%s\t"    ,stDto.stNum);
			System.out.printf("%s  \t"  ,stDto.stName);
			System.out.printf("%s\t"  	,stDto.stDept);
			System.out.printf("%3d\t"   ,stDto.stGrade);
			System.out.printf("%s\t"	,stDto.stTel);
			System.out.printf("%s\n"    ,stDto.stAddress);
			if(++row % 5 == 0 && row<stList.size()) {
				System.out.println(Line.sLine(100));
			}
		}
		System.out.println(Line.dLine(100));
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
