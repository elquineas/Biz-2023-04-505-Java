package com.callor.controller;

public class ControllerC {
	/*
	 * 랜덤수 51~100까지 범위
	 * 3의배수를 표시하고
	 * 아닐때 2의배수도 표시
	 */
	public static void main(String[] args) {
		int rNum;
		for(int i = 0; i<100; i++) {
			rNum = (int)(Math.random()*50) + 51;
			System.out.printf("%3d 번째 : %3d",i+1,rNum);
			if(rNum %3 == 0) {
				System.out.print(" (3의 배수)");
			}else if(rNum %2 == 0){
				System.out.print(" \t\t(2의 배수)");
			}
			System.out.println();
		}
		System.out.println("완료");
	}
}
