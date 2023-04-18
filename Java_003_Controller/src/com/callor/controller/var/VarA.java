package com.callor.controller.var;

public class VarA {
	public static void main(String[] args) {
		int intKor = 85;
		int intEng = 57;
		int intMath = 100;
		int intTotal = intKor + intEng + intMath;
		float intAvg = (float)intTotal/3f;
		
		System.out.println("==============================");
		System.out.println("국어 : "+intKor);
		System.out.println("영어 : "+intEng);
		System.out.println("수학 : "+intMath);
		System.out.println("------------------------------");
		System.out.println("총점 : "+intTotal+", 평균 : "+intAvg);
		System.out.println("==============================");
		
		System.out.printf("==============================\n");
		System.out.printf("국어 : %3d\n",intKor);
		System.out.printf("영어 : %3d\n",intEng);
		System.out.printf("수학 : %3d\n",intMath);
		System.out.printf("------------------------------\n");
//		System.out.println("총점 : "+intTotal+", 평균 : "+intAvg);
		System.out.printf("총점 : %3d, 평균 : %5.2f\n", intTotal, intAvg);
		System.out.printf("==============================");
	}
}
