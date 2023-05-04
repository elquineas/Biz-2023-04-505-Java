package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerD {
	public static int rGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=".repeat(30));
		System.out.println("GAME START");
		int rNum = (int)(Math.random()*10)+1;
		int sNum = 0;
		while(true) {
			System.out.println("-".repeat(30));
			System.out.println("1~ 10사이 랜덤수 맞추기");
			System.out.print("정수만 입력(QUIT : 종료) >> ");
			String prime = scan.nextLine();
			if(prime.equals("QUIT")) {
				return -1;
			}
			try {
				sNum = Integer.valueOf(prime);
				if(sNum<0 || sNum > 10){
					continue;
				}
			}catch(Exception e){
			}
			if(rNum == sNum) {
				System.out.println("잘했어요~");
				break;
			}else {
				System.err.println("오답");
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int result;
		while(true) {
			result = rGame();
			if(result < 0) {
				System.out.println("=".repeat(30));
				System.out.println("GAME OVER");
				System.out.println("=".repeat(30));
				return;
			}
		}
	}
}
