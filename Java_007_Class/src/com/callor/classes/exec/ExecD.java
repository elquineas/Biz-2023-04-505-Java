package com.callor.classes.exec;

import java.util.Scanner;

import com.callor.classes.module.MyClassA;

public class ExecD {
	public static void main(String[] args) {
		/*
		 * MyClassA type myA 객체를 선언하고,
		 * MyClassA() 생성자 method를 사용하여
		 * myA 객체를 초기화 한다.
		 */
		MyClassA myA = new MyClassA();
		
		/*
		 * String str = new String("Republic of Korea");
		 * 로도 사용가능
		 * String type str 객체를 선언하고,
		 * String() 생성자 method를 사용하여
		 * str 객체를 초기화 한다.
		 */
		String str = "Republic of Korea";
		
		/*
		 * Scanner type의 scan 객체를 선언하고,
		 * Scanner() 생성자 method를 사용하여
		 * scan 객체를 초기화 한다.
		 */
		Scanner scan = new Scanner(System.in);
		
		/*
		 * class type의 객체를 선언하고
		 * - class type이란 변수 선언 keyword가 class
		 * - class type으로 선언된 변수를 샛체라고 한다
		 * - 선언되지 않은 변수는 초기화, 저장, 읽기, 쓰기등
		 *   일체 허용되지 않는다. 사용할수 없다.
		 *   
		 * 객체를 생성자 method를 사용하여 초기화 한다
		 * - 객체(변수)를 완전히 사용가능한 상태로 만들기
		 * - 객체(변수)를 초기화하지 않으면, 일부 기능만
		 *   사용할수 있다.
		 *   
		 * 일반 변수는 값을 저장, 할당, 대입하면 초기화가 된다
		 * 객체는 클래스의 생성자 method()를 사용하여 초기화 된다    
		 */
		int num1;
		num1 = 0;
	}
}
