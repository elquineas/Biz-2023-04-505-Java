package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerB {
	private static int getNum() {
		Scanner scan = new Scanner(System.in);
		int pNum = 0;
		while(true) {
			System.out.println("3 이상의 정수를 입력하세요");
			System.out.print("소수 판별 ( QUIT : 종료 ) >> ");
			String prime = scan.nextLine();
			if(prime.equals("QUIT")) {
				return -1;
			}
			try {
				pNum = Integer.valueOf(prime);
//				if(pNum < 3) {
//					continue;
//				}
//				break;
//				continue 키워드를 사용하기 싶지 않으면
				if(pNum >= 3) {
					break;
				}
			}catch(Exception e){
				System.out.println("정수로만 입력해야 합니다");
			}
		}
		
		return pNum;
	}
	
	public static int prime(int num) {
		int i;
		for(i = 2; i<num; i++) {
			if(num % i == 0) {
				return -1;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		while(true) {
			int pNum = getNum();
			if(pNum < 0) {
				System.out.println("!!! System 종료 !!!");
				return;
			}
			
			int result = prime(pNum);
			
			if(result > 0) {
				System.out.println(pNum + "은(는) 소수입니다.");
			}else {
				System.err.println(pNum + "은(는) 소수가 아닙니다.");
			}
		}
	}
}
