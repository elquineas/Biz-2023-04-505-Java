package com.callor.classes;

import java.util.Scanner;

public class ClassH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		float num3 = 0;
		while(true) {
			System.out.println("두개의 정수를 입력하세요");
			System.out.println("실수를 입력하면 종료합니다");
			System.out.print("정수1 >> ");
			num3 = scan.nextFloat();
			if(num3%1 > 0) {
				break;
			}
			num1 = (int)num3;
			System.out.print("정수1 >> ");
			num3 = scan.nextFloat();
			if(num3%1 > 0) {
				break;
			}
			num2 = (int)num3;
			System.out.printf("%d + %d = %d\n", num1, num2 ,num1+num2);
		}
		System.out.println("GAME OVER!!!");
	}
}

