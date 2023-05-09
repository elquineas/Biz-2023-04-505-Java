package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;

public class StudentC {
	public static void main(String[] args) {
		List<StudentDto> stList = new ArrayList<>();
		
		for(int i = 0; i < StdData.Student.length; i++) {
			String[] student = StdData.Student[i].split(",");
			StudentDto stDto = new StudentDto();
			stDto.stNum 	= student[StdData.ST_NUM]; 	
			stDto.stName 	= student[StdData.ST_NAME]; 	
			stDto.stDept 	= student[StdData.ST_DEPT]; 	
			stDto.stGrade 	= Integer.parseInt(student[StdData.ST_GRADE]); // Integer.valueOf() 	
			stDto.stTel 	= student[StdData.ST_TEL]; 
			stDto.stAddress = student[StdData.ST_ADDRESS];
			stList.add(stDto);
		}
		
		System.out.println(stList.toString());
	}
}
