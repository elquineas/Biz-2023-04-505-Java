package com.callor.classes.arrays;

public class ArrayB {
	public static void main(String[] args) {
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.printf("%d\t", nums[i]);
		}
		System.out.println();
		
		for(int i = 0; i < 100; i++) {
			/*
			 * nums 배열의 index 범위에서 랜덤수 생성하기
			 */
			int index1 = (int)(Math.random()*nums.length);
			int index2 = (int)(Math.random()*nums.length);
			
			int tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = tmp;
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.printf("%d\t", nums[i]);
		}
	}
}
