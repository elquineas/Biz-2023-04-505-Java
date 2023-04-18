package com.callor.controller;

public class ControllerA {
	public static void main(String[] args) {
		int index = 0;
		/*
		 * 1.index < 10 비교문이 실행
		 *   결과가 true이면 2번 실행
		 * 2.{}코드 실행
		 * 3.index++하여 index 변수값을 1증가
		 * 
		 * index<10 비교문 결과가 false가 되면 반복문 종료
		 * 그렇지 않으면 1~3을 계속해서 반복
		 */
		for (; index<10; index++) {
			// 현재 이 코드는 index가 0~9까지
			// 변화되는 동안실행
			// 총 10회 실행된다.
		}
	}
}
