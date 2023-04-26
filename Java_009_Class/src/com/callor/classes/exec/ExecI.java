package com.callor.classes.exec;

public class ExecI {
	public static void main(String[] args) {
		int[] nums = new int[50];
		for(int i = 0; i<nums.length; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
		
		int index = -1;
		for(int i = 0; i<nums.length; i++) {
			if(nums[i] % 3 ==0) {
				index = i;
			}
		}
		
		if(index < 0){
			System.err.println("3의 배수 없음");
		}else{
			System.out.println("위치	: "+index);
			System.out.println("값	: "+nums[index]);
		}
		
		
//		역주행
//		for(int i = nums.length-1; i>=0; i--) {
//			if(nums[i] % 3 ==0) {
//				index = i;
//			}
//		}
		
		
	}
}
