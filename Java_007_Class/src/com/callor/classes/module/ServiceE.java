package com.callor.classes.module;

public class ServiceE {
	public ServiceE() {
		
	}
	public void score(int num1, int num2, int num3){
		int sum = num1 + num2 + num3;
		float avg = sum/3;
		
		System.out.println("=======================================");
		System.out.println("국어	영어	수학	총점	평균");
		System.out.printf ("%3d	%3d	%3d	%3d	%3.2f\n",num1,num2,num3,sum,avg);
		System.out.println("=======================================");
	}
}
