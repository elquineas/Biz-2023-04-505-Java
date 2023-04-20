package com.callor.controller;

public class ControllerF {
	/*
	 * prime() method의 코드를 수정하여
	 * 생성된 랜덤수가 소수인지 아닌지 판별하는 코드로 변경
	 * 
	 * method를 선언할때 void type 이외의 type으로 선언하면 method{}
	 * 내에서 반드시 return 명령문이 있어야한다
	 * 
	 */
	public static boolean prime() {
		int rNum = (int)(Math.random()*50)+51;
		int pCount = 0;
		int j;
		for(j = 2; j<rNum; j++) {
			if(rNum%j == 0) {
				pCount++;
//				break;
				return false;
			}
		}
		boolean yesPrime = rNum <= j;
		return yesPrime;
//		if(pCount == 0) {
//			System.out.printf("%3d (소수)\n",rNum);
//		}else {
//			System.err.printf("%3d\n",rNum);
//		}

		
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			System.out.printf("%3d번째 : ",i);
			// prime() method의 {}내의 코드를 실행해달라
			// prime() method를 호출한다 라고 표현
			if(prime()){
				System.out.println("소수");
			}else {
				System.out.println("소수아님");
			}
		}
	}
}
