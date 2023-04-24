package com.callor.controller;

public class ControllerC {
	public static int prime() {
		int rNum = (int)(Math.random()*50)+51;
		for(int i = 2; i < rNum; i++) {
			if(rNum%i == 0) {
				return 0;
			}
		}
		return rNum;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++){
			int rNum = prime();
			if(rNum > 0) {
				System.out.println(rNum + " 는 소수");
			}else {
				System.err.println("X");
			}
		}
	}
}
