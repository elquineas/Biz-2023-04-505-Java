package com.callor.system.exec;

import com.callor.system.service.StudentServiceV1;

public class StudentC {
	public static void main(String[] args) {
		StudentServiceV1 sServ = new StudentServiceV1();
		sServ.inputStudent();
	}
}
