package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerG {
	
	public static boolean duplication(int[] nums,int num) {
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] == num) {
				return false;
			}
		}
		return true;
	}
	
	public static int rGame(int nums) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=".repeat(40));
		System.out.println("GAME START");
		System.out.println("1 ~ 45사이 랜덤수 맞추기");
		System.out.println(nums);
		int sNum = 0;
		while(true) {
			System.out.println("-".repeat(40));
			System.out.print("정수만 입력(QUIT : 종료) >> ");
			String prime = scan.nextLine();
			if(prime.equals("QUIT")) {
				return -1;
			}
			try {
				sNum = Integer.valueOf(prime);
				if(sNum < 0 || sNum > 45){
					System.err.println("1 ~ 45사이 정수를 입력해주세요");
					continue;
				}else if(nums == sNum) {
					System.out.println("잘했어요~");
					break;
				}else if(nums > sNum){
					System.err.println("UP");
				}else if(nums < sNum){
					System.err.println("DOWN");
				}
			}catch(Exception e){
				System.err.println("1 ~ 45사이 정수를 입력해주세요");
			}
		}
		return sNum;
	}
	
	public static int[] ascendingOrder(int[] nums) {
		for(int out = 0; out < nums.length; out++) {
			for(int in = out+1; in < nums.length; in++) {
				if(nums[out] > nums[in]) {
					int _tmp  = nums[in];
					nums[in]  = nums[out];
					nums[out] = _tmp;
				}
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];
		int rNum = (int)(Math.random() * 45)+1;
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(duplication(nums, rNum)) {
				nums[count] = rNum;
				count++;
				if(count >= nums.length) {
					break;
				}
			}else {
				rNum = (int)(Math.random() * 45)+1;
				i = -1;
			}
		}
		
		int result;
		for(int i = 0; i < nums.length; i++) {
			result = rGame(nums[i]);
			if(result < 0 ||  i == nums.length-1) {
				System.out.println("=".repeat(40));
				System.out.println("GAME OVER");
				nums = ascendingOrder(nums);
				for(int j = 0; j < nums.length; j++) {
					System.out.print(nums[j] + "\t");
				}
				System.out.println();
				System.out.println("=".repeat(40));
				return;
			}
		}
		
		
	}
}
