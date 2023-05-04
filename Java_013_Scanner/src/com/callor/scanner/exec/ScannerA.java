package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int pNum = 0;
		boolean flag = true;
		String prime;
		while(true) {
			System.out.print("소수 판별 >> ");
			prime = scan.nextLine();
			try {
				pNum = Integer.valueOf(prime);
			}catch(Exception e){
				System.out.println("정수로만 입력해야 합니다");
				continue;
			}
			if(pNum <= 2) {
				System.out.println("2보다 큰수를 입력해야 합니다");
				continue;
			}
			break;
		}
		for(int i = 2; i<pNum; i++) {
			if(pNum % i == 0) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println(pNum + "은(는) 소수입니다.");
		}else {
			System.err.println(pNum + "은(는) 소수가 아닙니다.");
		}
	}
}
