package com.callor.controller;

public class ControllerD {
	public static int prime() {
		int rNum = (int)(Math.random()*50)+51;
		for(int i = 2; i<rNum; i++) {
			if(rNum%i == 0) {
				return 0;
			}
		}
		return rNum;
	}
	
	public static void main(String[] args) {
		int pSum = 0;
		int pCount = 0;
		for(int i = 0; i<100; i++) {
			int pNum = prime();
			pSum += pNum;
			if(pNum > 0) {
				pCount++;
			}
		}
		System.out.println("갯수 : "+pCount);
		System.out.println("합   : "+pSum);
	}
}
