package com.callor.classes.exec;

public class ExecJ {
	public static void main(String[] args) {
		int[] nums = new int[50];
		for(int i = 0; i<nums.length; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
		
		int firstIndex = -1;
		int lastIndex = -1;
		for(int i = 0; i<nums.length; i++) {
			if(prime(nums[i]) > 0) {
				if(firstIndex < 0) {
					firstIndex = i;
				}
				lastIndex = i;
			}
		}
		
		if(firstIndex > -1){
			System.out.println("첫번째 위치 : "+firstIndex);
			System.out.println("첫번째 소수 : "+nums[firstIndex]);
			System.out.println("마지막 위치 : "+lastIndex);
			System.out.println("마지막 소수 : "+nums[lastIndex]);
		}else {
			System.err.println("소수없음");
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
