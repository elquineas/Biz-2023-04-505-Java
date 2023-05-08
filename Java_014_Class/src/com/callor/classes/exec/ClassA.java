package com.callor.classes.exec;

public class ClassA {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]%2 ==0) {
				System.out.printf("INDEX : %d\n",i);
				System.out.printf("짝 수 : %d\n",nums[i]);
				break;
			}
		}
		
	}
}
