package com.callor.controller;

public class ControllerD {
	/*
	 * 1~100까지의 숫자를 가로방향으로 일렬로 나열하기
	 * ex)
	 * 1 2 3 4 5
	 * 6 7 8 9 10
	 */
	public static void main(String[] args) {
		int last = 100;
		for(int i = 0; i<last; i++) {
			System.out.print((i+1) + "\t");
			if((i+1) % 5 == 0) {
				System.out.println();
			}
		}
	}
}
