package com.callor.classes.exec;

public class NumbersC {
	public static void main(String[] args) {
		// 참조형 정수 배열 10개 생성
		// 참조형 정수 배열은 개수는 만들어지지만 초기화는 되지 않는다
		Integer[] nums = new Integer[10];
		int[] intNums  = new int[10];
		
		System.out.println(nums[0]);
		System.out.println(intNums[0]);
		
		boolean bYes = nums[0].equals(nums[1]);
		System.out.println(bYes);
		
		for (int i = 0; i < nums.length; i++) {
			intNums[i] = 0;
		}
		// 참조형 수샂 배열의 요소는 일반 기본형 변수 초기화와 같이 생성한다.
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Integer(0);
		}
		
		String str1 = "Korea";
		String str2 = new String("Korea");
		
		
	}
}
