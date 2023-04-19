package com.callor.controller;

public class ControllerE {
	/*
	 * 51~100범위의 랜덤수를 1개 생서아여 변수에 저장
	 * 변수에 저장된 수가 소수인가 판별
	 */
	public static void main(String[] args) {
		int rNum = (int)(Math.random()*50)+51;
		int pCount = 0;
		for(int i = 2; i<=rNum/2; i++) {
			if(rNum %i == 0) {
				pCount++;
			}
		}
		System.out.print("랜덤수 : "+rNum);
		if(pCount > 0){
			System.out.printf("\t(소수X)");
		}else {
			System.out.printf("\t(소수O)");
		}
	}
}
