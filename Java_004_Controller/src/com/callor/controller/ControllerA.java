package com.callor.controller;

public class ControllerA {
	public static void main(String[] args) {
		int rNum;
		for(int i = 0; i<100; i++) {
			rNum = (int)(Math.random()*50)+51;
			if(rNum < 51 || rNum > 100) {
				System.err.printf("ERROR : %3d\n",rNum);
			}
			System.out.printf("%3d번째 : %3d\n",i+1,rNum);
		};
		System.out.println("완료");
	}
}
