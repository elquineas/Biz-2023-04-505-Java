package com.callor.student.exec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentExecD {
	public static void main(String[] args) {
		InputStream is = System.in;
		Scanner scan = new Scanner(is);
		
		String studentFile = "src/com/callor/student/student.txt";
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(studentFile);
			out = new PrintWriter(os);
			
			for(int i = 0; i<10; i++) {
				out.print("0001,");
				out.print("홍길동,");
				out.print("정보통신,");
				out.print("3,");
				out.println("010-0000-2222");
			}
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
