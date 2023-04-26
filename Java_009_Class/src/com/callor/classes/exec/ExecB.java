package com.callor.classes.exec;

public class ExecB {
	public static void main(String[] args) {
		int[] nums = new int[10];
		
		for(int i = 0; i<10; i++) {
			nums[i] = i+1;
		}
		
		for(int i = 0; i<10; i++) {
			nums[i] = (int)(Math.random()*50)+51;
		}
	}
}
