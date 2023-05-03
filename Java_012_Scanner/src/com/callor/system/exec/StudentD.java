package com.callor.system.exec;

import com.callor.system.models.StudentDto;
import com.callor.system.service.StudentServiceV2;
import com.callor.system.service.StudentServiceV22;

public class StudentD {
	public static void main(String[] args) {
		StudentServiceV2 sServ = new StudentServiceV2();
		StudentServiceV22 sServ2 = new StudentServiceV22();
		StudentDto[] stList = new StudentDto[5];
		for(int i = 0; i<stList.length; i++) {
			stList[i] = new StudentDto();
		}
		
//		stList = sServ.inputStudents(stList);
//		sServ.printStudents(stList);
		
		sServ2.inputStudents();
		sServ2.printStudents();
		
	}
}
