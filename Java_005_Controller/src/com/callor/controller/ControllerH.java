package com.callor.controller;

public class ControllerH {
	public static boolean prime(int rNum) {
		int pCount = 0;
		int j;
		for(j = 2; j<rNum; j++) {
			if(rNum%j == 0) {
				pCount++;
				return false;
			}
		}
		boolean yesPrime = rNum <= j;
		return yesPrime;		
	}
	
	/*
	 * Java에서는 method의 이름ㅇ르 매개변수의 type로 본다
	 * prime(int rndNum)은 pirme(int)라는 이름으로 선언되고
	 * prime()는 prime() 라는 이름으로 선언된다
	 * 따라서 prime(int)와 prime()은 전혀 다른 method로 인식한다
	 * 이것을 Java의 특징중에 중복선언 (OverLoading)이라고 한다
	 * 
	 * 호출하는 곳에서 
	 * prime(30)과 같이 호출하면 prime(int)가 호출되고 
	 * prime()과 같이 호출하면 prime()가 실행된다
	 */
	
	public static boolean prime() {
		int rNum = (int)(Math.random()*50)+51;
		
		return prime(rNum);		
	}
	
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			int mainRndNum = (int)(Math.random()*50)+51;
			if(prime(mainRndNum)){
				System.out.println(mainRndNum + " 소수");
			}
//			else {
//				System.err.println(mainRndNum + " 소수아님");
//			}
			if(prime()) {
				System.out.println("소수");
			}
		}
	}
	
	
}
