package com.callor.classes.arrays;

public class ArrayE {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i = 0; i<10; i++) {
			nums[i] = i+1;
		}
		for(int i = 0; i<10; i++) {
			if(nums[i]%2 == 0) {
//				System.out.println(nums[i]);
			}
		}
		
		for(int i = 2; i<10; i++) {
			boolean pYes = true;
			for(int j = 2; j<nums[i]; j++) {
				if(nums[i] % j == 0) {
					pYes = false;
				}
			}
			if(pYes){
				System.out.println(nums[i]);
			}
		}
	}
}
