package com.callor.controller;

public class ControllerB {
	public static void main(String[] args) {
		int rNum;
		for(int i = 0; i<100; i++) {
			rNum = (int)(Math.random()*50) + 51;
//			if(rNum < 51 || rNum > 100) {
//				System.err.printf("ERROR : %3d\n", rNum);
//			}
//			if(rNum %2 == 0) {
//				System.out.printf("%3d번째 : %3d 짝수\n",i+1,rNum);
//			}else {
//				System.err.printf("%3d번째 : %3d 짝수아님\n",i+1,rNum);
//			}
			if(rNum %2 == 0) {
				System.out.printf("%3d번째 : %3d 짝수\n",i+1,rNum);
			}else if(rNum %2 == 1) {
				System.err.printf("%3d번째 : %3d 홀수\n",i+1,rNum);
			}
//			if(rNum %2 == 1) {
//				System.out.printf("%3d번째 : %3d 홀수\n",i+1,rNum);
//			}
		}
		System.out.println("완료");
	}
}
