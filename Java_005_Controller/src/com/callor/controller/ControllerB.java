package com.callor.controller;

public class ControllerB {
	public static void main(String[] args) {
		int rNum = (int)(Math.random()*50)+51;
		int pNum = 0;
		for(int i = 2; i<=rNum/2; i++) {
			if(rNum %i == 0) {
				pNum++;
				break;
			}
		}
		System.out.printf("%3d", rNum);
		if(pNum == 0) {
			System.out.println("은(는) 소수입니다");
		}
	}
}
