package com.callor.classes.arrays;

public class ArrayF {
	public static boolean prime(int num1) {
		for(int i = 2; i < num1; i++) {
			if(num1 % i == 0) {
				return false;			
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i = 0; i<10; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
		for(int i = 0; i<10; i++) {
			if(prime(nums[i])) {
				System.out.println(nums[i] +"\t소수");
			}else {
				System.err.println(nums[i]);
			}
		}
	}
}
