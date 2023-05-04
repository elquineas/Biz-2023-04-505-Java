package com.callor.scanner.service;

import java.util.Scanner;

public class PrimeServiceV1 {
	private Scanner scan = new Scanner(System.in);
	public int getNum() {
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
				if(pNum >= 3) {
					break;
				}
			}catch(Exception e){
				System.out.println("정수로만 입력해야 합니다");
			}
		}
		
		return pNum;
	}
	
	public int primeYesNo(int num) {
		int i;
		for(i = 2; i<num; i++) {
			if(num % i == 0) {
				return -1;
			}
		}
		return num;
	}
}
