package com.callor.classes.exec;

public class ExecG {
	public static void main(String[] args) {
		int[] nums = new int[50];
		for(int i = 0; i<nums.length; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
		
		for(int i = 0; i<nums.length; i++) {
			int result = prime(nums[i]);
			if(result > 0){
				System.out.println(nums[i]+ " 소수");
			}else {
				System.err.println(nums[i]);
			}
		}
	}
	
	public static int prime(int num) {
		for(int i = 2; i < num; i++) {
			if(num%i == 0) {
				return 0;
			}
		}
		return num;
	}
}
