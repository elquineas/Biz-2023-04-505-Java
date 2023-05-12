package com.callor.classes.exec;

import java.util.Scanner;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV2;

public class StudentExecD {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		StudentDto stDto = new StudentDto();
		Scanner scan = new Scanner(System.in);
		
		stService.loadStudent();
		stService.printStudent();
		
		String str = scan.nextLine();
		stDto = stService.getStudent(str);
		System.out.println(stDto.toString());
	}
}
