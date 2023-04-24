package com.callor.classes.module;

public class ServiceB {
	public ServiceB() {
	}
	public void scorePrint(String name,int num1,int num2,int num3) {
		int sum = num1+num2+num3;
		float avg = sum/3f;
		System.out.println("=============================================");
		System.out.println("이름	국어	영어	수학	총점	평균");
		System.out.println("---------------------------------------------");
		System.out.printf ("%s	%3d	%3d	%3d	%3d	%.1f\n",name,num1,num2,num3,sum,avg);
		System.out.println("=============================================");
		return;
	}
//	public static void scorePrint2(String name,int num1,int num2,int num3) {
//		int sum = num1+num2+num3;
//		float avg = sum/3f;
//		System.out.println("=============================================");
//		System.out.println("이름	국어	영어	수학	총점	평균");
//		System.out.println("---------------------------------------------");
//		System.out.printf ("%s	%3d	%3d	%3d	%3d	%.1f\n",name,num1,num2,num3,sum,avg);
//		System.out.println("=============================================");
//		return;
//	}
}
