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

public class StudentServiceImplV4 extends StudentServiceImplV3{
	public StudentServiceImplV4() {
		// stList 객체는 V3 클래스에서 protected로 선언한 객체이다
		// 이 객체는 V3 클래스를 상속받은 클래스에서 접근 가능하다
		stList = new ArrayList<>();
	}
	
	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학년\t\t학과\t전화번호\t주소");
		System.out.println(Line.sLine(100));
		int row = 0;
		for(StudentDto dto : stList) {
			System.out.printf("%s\t",dto.stNum);
			System.out.printf("%s\t",dto.stName.substring(0,3));
			System.out.printf("%s\t",dto.stDept);
			System.out.printf("%d\t",dto.stGrade);
			System.out.printf("%s\t",dto.stTel);
			System.out.printf("%s\t\n",dto.stAddress);
			if(++row % 5 == 0 && row<stList.size()) {
				System.out.println(Line.sLine(100));
			}
		}
		System.out.println(Line.dLine(100));
	}
}
