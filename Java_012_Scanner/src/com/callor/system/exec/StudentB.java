package com.callor.system.exec;

import com.callor.system.models.StudentDto;

public class StudentB {
	public static void main(String[] args) {
		StudentDto 이몽룡 = new StudentDto();
		이몽룡.setStNum("0001");
		String strNum = 이몽룡.getStNum();

		이몽룡.setStNum("0001");
		이몽룡.setStName("이몽룡");
		이몽룡.setStTel("컴퓨터공학");
		이몽룡.setStDept("3");
		이몽룡.setStTel("010-111-1111");
		
		
		
	}
	
}
