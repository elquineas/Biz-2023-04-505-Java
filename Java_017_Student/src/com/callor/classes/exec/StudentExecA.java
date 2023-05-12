package com.callor.classes.exec;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentExecA {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV1();
		

		stService.loadStudent();
		stService.printStudent();
		
		StudentDto stDto = stService.getStudent("S0001");
		if(stDto.stNum != null) {
			System.out.println(stDto.stNum);
			System.out.println(stDto.toString());
		}else {
			System.out.println("찾는 데이터가 없음");
		}
//		try {
//			System.out.println(stDto.stNum);
//			System.out.println(stDto.toString());
//		} catch (Exception e){
//			System.out.println("찾는 데이터가 없음");
//		}
	}
}
