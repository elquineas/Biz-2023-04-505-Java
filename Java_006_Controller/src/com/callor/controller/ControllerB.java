package com.callor.controller;

public class ControllerB {
	public static boolean prime() {
		int rNum = (int)(Math.random()*50)+51;
		int index = 0;
		for(index = 2; index < rNum; index++) {
			if(rNum%index == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			boolean yesPrime = prime();
			if(yesPrime) {
				System.out.println("소수");
			}else {
				System.out.println("소수아님");
			}
		}
	}
	
}
