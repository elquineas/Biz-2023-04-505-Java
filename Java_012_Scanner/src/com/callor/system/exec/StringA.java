package com.callor.system.exec;

public class StringA {
	public static void main(String[] args) {
		/*
		 * 문자열 변수
		 * 
		 * 일반적인 변수(primitive variable)
		 *   int, float, long, double, boolean, char
		 * primitive 변수는 변수를 선언하는 키워드가 모두 소문자이다.
		 *   이 키워드는 단지 데이터를 저장하는 공간인 변수를 선언하는 용도
		 *   (숫자)변수의 형(type)을 강제 변환하는 용도로만 사용된다.
		 *   
		 * 문자열변수는 primitive type 이 아니다
		 *   class type 이다
		 * class type으로 생성된 변수는
		 *   여러가지 기능(method)들을 많이 포함하고 있다
		 */
		
		String str1 = "Korea";
		System.out.println(str1.substring(3));
		
		String str2 = "Korea";
		String str3 = new String("Korea");
		
		System.out.println("STR2 : "+str2);
		System.out.println("STR3 : "+str3);
		
		boolean bYes = str2 == str3;
	}
}
