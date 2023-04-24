package com.callor.classes.exec;

import com.callor.classes.module.MyClassC;

public class ExecI {
	public static void main(String[] args) {
		MyClassC myC = new MyClassC();
		int rCount = 0;
		for(int i = 0; i<100; i++) {
			int rNum = (int)(Math.random()*50)+51;
//			System.out.println(i +" : "+ rNum);
			int result = myC.prime(rNum);
			if(result > 0) {
				rCount++;
			}
		}
		System.out.printf("소수는 %2d개 입니다",rCount);
	}
}
