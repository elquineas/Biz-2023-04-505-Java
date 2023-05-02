package com.callor.classes;

import java.util.Scanner;

public class ClassF {
	public static void main(String[] args) {
		/*
		 * leak(누수)
		 */
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		System.out.println("=".repeat(30));
		for(int i = 0; i<3; i++) {
			System.out.println((i+1)+")번째 계산");
			System.out.print("정수1 >> ");
			scan.nextInt();
			System.out.print("정수2 >> ");
			scan.nextInt();
			System.out.println("두 정수의 사칙연산");
			System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
			System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
			System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);
			System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);	
			System.out.println("=".repeat(30));
		}
		/*
		 * scan 객체는 하드웨어인 키보드와 연결된 상태의 여러 정보를 가지고 있는 상태이다
		 * 하드웨어 키보드는 운영체제나 여러곳에서 많은 정보를 
		 * 기억장소 어딘가에 보관하고 있는 상태이다.
		 * 이 상태로 프로젝트가 종료되면, 기억장소에 저장된 정보가 
		 * 소멸되는데 상당한 시간이 소요될 것이다.
		 * 그래서 사용이 끝난 키보드는 메모리에서 제거하는 절차를 강제로 실행한다.
		 * 
		 * 이것 자원의 누수(leak)를 방지하는 목적이 있다.
		 */
		scan.close();
	}
}
