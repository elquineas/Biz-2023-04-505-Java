package com.callor.controller;

import java.util.Iterator;

public class ControllerE {
	
	/*
	 * 2개의 정수형 인수를 전달받아 덧셈을 수행한후
	 *       method 선언을 할때 정수형 매개변수 2개가 필요
	 * 덧셈을 수행한후
	 *       결과는 int형이다
	 * 결과를 return 하는 method
	 *       method의 return type이 int
	 */
	public static int add(int num1, int num2) {
		// 결과값을 변수에 저장후 return
		int sNum = num1+num2;
		return sNum;
		
		
		// 연산과 동시에 결과를 return
//		return num1+num2;
		
	}
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		// add() method 호출
		// add() method는 2개의 정수형 매개변수를 가지고 있다
		//     정수값 2개를 "전달"해 주어야 한다
		// add() method 실행한 후 결과값을 return 한다
		// add() method가 return한 값을 다른 변수에 저장
		// 이때 add() method 실행결과를 다른 변수에
		//     저장하려면 그 변수의 type의 add() method의
		//     return type과 같아야 한다
		//     그래서 int result 형식으로 변수를 선언한다
		// result 변수에는 add() method의 실행결과가 담긴다
		int sNum = add(num1,num2);
		System.out.println(sNum);
	}
	
}
