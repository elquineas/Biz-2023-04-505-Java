package com.callor.classes.exec;

import java.util.Scanner;
import com.callor.classes.module.ServiceB;

public class ExecK {
	public static void main(String[] args) {
		ServiceB serviceb = new ServiceB();
//		Scanner scan = new Scanner(System.in);
//		scan.next();
		String name = "홍길동";
		int kor = (int)(Math.random()*50)+51;
		int eng = (int)(Math.random()*50)+51;
		int math = (int)(Math.random()*50)+51;
		serviceb.scorePrint(name, kor, eng, math);
//		ServiceB.scorePrint2("홍길동", kor, eng, math);
	}
}
