package com.callor.controller;

public class ControllerG {
	/*
	 * prime() method{}내에서 선언했던 rNum 변수를 매개변수(parameter)로 변경하기
	 * 매개변수는 스스로 초기화할수 없다
	 * 누군가 prime() method를 호출하면서 값을 
	 * 전달해주어야만 그 값으로 초기화 할수 있다
	 * prime(int rndNum = 0;과 같은 코드 사용불가
	 * 
	 * main()에서 prime(55)와 같은 코드가 실행될때 
	 * 매개변수 값이 초기화 된다
	 */
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
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			//main에서 랜덤수를 만들고
			int mainRndNum = (int)(Math.random()*50)+51;
			
			//prime() method에게 전달해 주기
			//prime() method에게 mainRndNum 변수에 저장된 값을 전달해 주기
			if(prime(mainRndNum)){
				System.out.println("소수");
			}else {
				System.err.println("소수아님");
			}
		}
	}
}
