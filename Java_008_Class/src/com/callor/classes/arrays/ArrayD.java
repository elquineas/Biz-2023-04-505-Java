package com.callor.classes.arrays;

public class ArrayD {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i = 0; i<10; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
		for(int i = 0; i<10; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		//각 요소에 저장된 정수를 모두 더하여 결과 표시
		int sum = 0;
		for(int i = 0; i<10; i++) {
			sum += nums[i];
		}
		System.out.println(sum);
	}
}
