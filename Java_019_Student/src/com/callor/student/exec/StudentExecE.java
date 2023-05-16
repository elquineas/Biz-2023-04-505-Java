package com.callor.student.exec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StudentExecE {
	public static void main(String[] args) {
		String studentFile = "src/com/callor/student/student.txt";
		OutputStream os = System.out;
		PrintWriter out = new PrintWriter(os);
		
		try {
			os = new FileOutputStream(studentFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		for(int i = 0; i<10; i++) {
			out.println("안녕하세요. 반갑습니다.");
		}
		
		// close가 실행되기 전에 임시보관 되어있다가 출력장치로 전달된다. 
		out.close();
	}
}
