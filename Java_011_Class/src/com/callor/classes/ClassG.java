package com.callor.classes;

import java.util.Scanner;

public class ClassG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		/*
		 * 무한반복 loop
		 * 반복조건이 true인 동안 무한 반복 loop
		 * 
		 * while(true){}
		 * 끝이 없이 (조건이 true이므로) 무한 반복
		 * 코드를 강제로 멈추지 않으면 영원히 반복된다.
		 * 
		 */
		while(true) {
			System.out.println("두개의 정수를 입력하세요");
			System.out.println("-1을 입력하면 종료합니다");
			System.out.print("정수1 >> ");
			num1 = scan.nextInt();
			// while(true)문 무한반복 종료 조건 설정
			if(num1 < 0) {
				break;
			}
			System.out.print("정수1 >> ");
			num2 = scan.nextInt();
			// while(true)문 무한반복 종료 조건 설정
			if(num2 < 0) {
				break;
			}
			System.out.printf("%d + %d = %d\n", num1, num2 ,num1+num2);
		}
		System.out.println("GAME OVER!!!");
		
		
	}
}

