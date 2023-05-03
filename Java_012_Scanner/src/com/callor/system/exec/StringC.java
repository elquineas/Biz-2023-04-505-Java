package com.callor.system.exec;

public class StringC {
	public static void main(String[] args) {
		String str1 = "Korea";
		String str2 = new String("Korea");
		String str3 = "KOREA";
		
		//문자열 값의 비교는 equals를 사용해야 한다.
		boolean bYes = str1 == str2;
		bYes = str1.equals(str2);
		bYes = str2.equals(str1);
		// equals() method는 저장된 영문자의 대소문자를 
		// 서로다른 문자열로 본다
		bYes = str1.equals(str3);
		// 영문자를 대소문자 관계없이 비교할때
		str1.equalsIgnoreCase(str3);
		
		str1 = "Republic of KOrea";
		str2 = "Republic of Korea";
		str3 = "Republic of    Korea";
		
		/*
		 * equalsIgnoreCase()
		 * 변수에 저장된 문자여르이 배열은 일치하고
		 * 대소문자가 섞여있을때는 같은 값으로 본다.
		 */
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1.equalsIgnoreCase(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
	}
}
