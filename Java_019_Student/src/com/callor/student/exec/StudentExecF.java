package com.callor.student.exec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2;

public class StudentExecF {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		((StudentServiceImplV2)stService).insertStudent();
		stService.loadStudent();
		stService.printStudent();
	}
}
