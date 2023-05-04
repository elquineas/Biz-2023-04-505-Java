package com.callor.scanner.exec;

import java.util.Scanner;

import com.callor.scanner.config.PublicConfig;

public class ScannerFA {
	public static int rGame(int[] nums) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(PublicConfig.dLine(100));
		System.out.println("GAME START");
		System.out.println("1 ~ 45사이 랜덤수 맞추기");
		int rNum = (int)(Math.random() * 45)+1;
		for(int i = 0; i<nums.length; i++) {
			if(nums[i] == rNum) {
				rNum = (int)(Math.random() * 45)+1;
				i = -1;
			}
		}
		
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
				if(sNum<0 || sNum > 45){
					System.err.println("1 ~ 45사이 정수를 입력해주세요");
					continue;
				}else if(rNum == sNum) {
					System.out.println("잘했어요~");
					break;
				}else if(rNum > sNum){
					System.err.println("UP");
				}else if(rNum < sNum){
					System.err.println("DOWN");
				}
			}catch(Exception e){
				System.err.println("1 ~ 45사이 정수를 입력해주세요");
			}
		}
		return sNum;
	}
	public static void main(String[] args) {
		int[] nums = new int[6];
		int result;
		int index = 0;
		while(true) {
			result = rGame(nums);	
			nums[index] = result;
			if(result < 0 || index == nums.length-1) {
				System.out.println("=".repeat(40));
				System.out.println("GAME OVER");
				for(int i = 0; i < nums.length; i++) {
					System.out.print(nums[i] + "\t");
				}
				System.out.println();
				System.out.println("=".repeat(40));
				return;
			}
			index++;
		}
	}
}
