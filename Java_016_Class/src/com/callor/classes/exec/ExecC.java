package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreServiceV1;

public class ExecC {
	public static void main(String[] args) {
		List<StudentDto> stdList = new ArrayList<>();
		
		StudentDto stDto = new StudentDto();
		stDto.stNum  = "0001";
		stDto.stName = "홍길동"; 
		stDto.stDept = "정보통신";
		
		stdList.add(stDto);
		
		stDto = new StudentDto();
		stDto.stNum  = "0002";
		stDto.stName = "성춘향"; 
		stDto.stDept = "컴퓨터공학";
		stdList.add(stDto);
		
		System.out.println(stdList.get(0).stName);

		StudentDto 홍길동 = stdList.get(0);
		System.out.println(홍길동.toString());
		System.out.println(홍길동.stName);
		System.out.println(stdList.get(0).stName);
		
		StudentDto 성춘향 = stdList.get(1);
		System.out.println(성춘향.toString());
		System.out.println(성춘향.stName);
		System.out.println(stdList.get(1).stName);
		
		for(int i = 0; i<stdList.size(); i++ ) {
			String stName = stdList.get(i).stName;
			System.out.println(stName);
		}
		
	}
}
