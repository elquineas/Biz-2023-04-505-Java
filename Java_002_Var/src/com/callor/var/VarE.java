package com.callor.var;

public class VarE {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		num1 = 30;
		num2 = 40;
		
		int plus1;
		int minus1; 
		int times1;
		int devide1;
		plus1 = num1+num2;
		minus1 = num1-num2;
		times1 = num1*num2;
		devide1 = num1/num2;
		
		System.out.println(plus1);
		System.out.println(minus1);
		System.out.println(times1);
		System.out.println(devide1);
		
		System.out.println("******************");
		System.out.printf("%d + %d = %d\n",num1,num2,plus1);
		System.out.printf("%d - %d = %d\n",num1,num2,minus1);
		System.out.printf("%d x %d = %d\n",num1,num2,times1);
		System.out.printf("%d / %d = %d\n",num1,num2,devide1);
		System.out.println("******************");
	}
}
