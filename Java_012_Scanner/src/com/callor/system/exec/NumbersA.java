package com.callor.system.exec;

public class NumbersA {
	public static void main(String[] args) {
		// 문자열형 숫자
		String strNum1 = "30";
		String strNum2 = "30.0";
		String strNum3 = "30 + 40";
		
		// 문자열형 숫자를 숫자형으로 변환하기
		int   num1 = Integer.valueOf(strNum1);
		float num2 = Float.valueOf(strNum2);
//		int   num3 = Integer.valueOf(strNum3);
		
//		System.out.println(num1+num2);
//		System.out.println(num1+num3);
		
		// 문자열형 숫자를 숫자형으로 변화하기 위해서는
		// 숫자외의 다른 문자열이 있으면 안된다
		System.out.println(Integer.valueOf("30"));
		System.out.println(Integer.valueOf(" 30"));
		System.out.println(Integer.valueOf("30 "));
		System.out.println(Integer.valueOf("A30"));
		System.out.println(Integer.valueOf("30A"));
		
		
	}
}
