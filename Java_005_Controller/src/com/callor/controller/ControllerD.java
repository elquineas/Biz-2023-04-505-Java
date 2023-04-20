package com.callor.controller;

public class ControllerD {
	public static void main(String[] args) {
		int rNum;
		int pCount;
		for(int i = 0;i<100; i++) {
			rNum = (int)(Math.random()*50)+51;
			pCount = 0;
//			System.out.printf("%3d번째 : %3d",i+1,rNum);
			for(int j = 2; j<=rNum/2; j++) {
				if(rNum%j == 0) {
					pCount++;
					break;
				}
			}
			if(pCount == 0) {
				System.out.printf("%3d (소수)\n",rNum);
			}
//			else {
//				System.out.println();
//			}
		}
	}
}
