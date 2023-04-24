package com.callor.controller;

public class ControllerA {
	/*
	 * java.exe 도구가 ControllerA.class 파일을 읽어서
	 * 메모리에 load하고 제일먼저 호출하는 method()
	 * 시작점 메서드, 진입점 메서드
	 */
	public static void main(String[] args) {
		prime();
		// prime() method는 return type이 void이기 때문에 다른 명령문에 포함되거나
		// 변수의 값을 생성할 수 없다
		// return type이 void 이기 단독으로만 실행할 수 있다.
		// if(prime()) {}
		// boolean tesPrime = prime();
	} // end main
	
	/*
	 * 매개변수도 없고, return type이 void(없다라고 표현)dls
	 * prime() method 선언
	 */
	public static void prime() {
		int rNum = (int)(Math.random()*50)+51;
		int i = 0;
		for(i = 2; i<rNum; i++) {
			if(rNum%i == 0) {
				break;
			}
		}
		if(i >= rNum) {
			System.out.println(rNum + " 소수");
		}else {
			System.out.println(rNum + " 소수아님");
		}
		
		
	}
	
}
