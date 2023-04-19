package com.callor.controller;

public class ControllerD {
	/*
	 * 51~100까지 범위의 랜덤수 100개 생성
	 * 생성된 랜덤수 중에 짝수가 몇개인가 판별
	 */
	public static void main(String[] args) {
		int rNum;
		int eCount = 0;
		int eSum = 0;
//		float eAvg = 0;
		int eAvg;
		for(int i = 0; i<100; i++) {
			rNum = (int)(Math.random()*50)+51;
			if(rNum %2 == 0){
				eSum += rNum;
				eCount++;
			}
//			System.out.printf("%3d번째 : %3d\n",i+1,rNum);
		}
//		eAvg = (float)eSum/eCount;
		eAvg = eSum/eCount;
		System.out.printf("짝수의 개수 : %4d\n",eCount);
		System.out.printf("짝수의 합계 : %4d\n",eSum);
//		System.out.printf("짝수의 평균 : %.2f" ,eAvg);
		System.out.printf("짝수의 평균 : %4d" ,eAvg);
	}
}
