package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentD {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		List<StudentDto> stList = new ArrayList<>();
		StudentService stService = new StudentServiceImplV1();
		StudentDto stDto = new StudentDto();
		
		stService.loadStudent();
		stService.printStudent();
		
		String stNum = scan.nextLine();
		stDto = stService.getStudent(stNum);
		System.out.println(stDto.toString());
	}
}
