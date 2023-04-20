package com.callor.controller;

public class ControllerE {
	/*
	 * method의 선언
	 * method는 마치 java의 명령문을 새로 만드는 것과 같다
	 * method 선언 규칙에 따라 이름(){}등을 만들고
	 * {}내에 원하는 코드를 작성한다
	 */
	public static void prime() {
		int rNum = (int)(Math.random()*50)+51;
		int pCount = 0;
		for(int j = 2; j<=rNum/2; j++) {
			if(rNum%j == 0) {
				pCount++;
				break;
			}
		}
		if(pCount == 0) {
			System.out.printf("%3d (소수)\n",rNum);
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			// prime() method의 {}내의 코드를 실행해달라
			// prime() method를 호출한다 라고 표현
			prime();
		}
	}
}
