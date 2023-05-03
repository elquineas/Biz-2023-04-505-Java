package com.callor.system.exec;

import java.util.Scanner;

public class ScannerB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		while(true) {
			/*
			 * strNum1, strNum2는 문자열형 숫자가 들어간다
			 * +연산 이외의 다른 사칙연산은 오류가 난다
			 */
			
			System.out.println("두 개의 정수를 입력하세요");
			System.out.print("정수1 (QUIT:종료) >> ");
//			num1 = scan.nextInt();
			String strNum1 = scan.nextLine();
			if(strNum1.equals("QUIT")){
				break;
			}
			System.out.print("정수2 (QUIT:종료) >> ");
			String strNum2 = scan.nextLine();
			if(strNum2.equals("QUIT")){
				break;
			}
			System.out.println(strNum1 + strNum2);
//			num2 = scan.nextInt();
			
		}
		System.out.println("GAME OVER!!!");
		scan.close();
		
	}
}
