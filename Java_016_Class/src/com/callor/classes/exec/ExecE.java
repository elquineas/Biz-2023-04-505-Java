package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.callor.classes.models.StdData;

public class ExecE {
	public static void main(String[] args) {
		// stdData.Student는 static 키워드로 선언되어 있기 때문에 객체를 생성하여 접근하지 않아도 된다.
		// 대신 클래스를 통해서 Dot(.)연산자로 변수에 직접 접근이 가능하다
		// StdData stdData = new StdData();
		// System.out.println(stdData.Student[]);
		
		for(int i = 0; i< StdData.Student.length; i++) {
			System.out.println(StdData.Student[i]);
		}
		System.out.println("=".repeat(100));
		for(String str : StdData.Student) {
			System.out.println(str);
		}
		System.out.println("=".repeat(100));
		// 같은 방법
		// 편한걸로 사용가능
		List<String> studentList = Arrays.asList(StdData.Student);
		studentList = new ArrayList<>(Arrays.asList(StdData.Student));
		
		for(String str : studentList) {
			System.out.println(str);
		}
		
		/* 			배열			|			List
		 * =========================|========================
		 * 처음에 개수를 지정		| 처음에 type을 지정
		 * new String[10]			| List<String>
		 * 							| size()가 0인 상태로 시작
		 * 							|
		 * 개수범위내의 index		| 필요에 따라 List에 add()를 
		 * 위치 요소에 값 저장		| 실행하여 데이터를 추가한다
		 * ex) str[3] = "Korea"		|
		 * 							|
		 * 개수범위내의 index		| List의 get(index) method를 통하여
		 * 위치 요소로 부터			| 데이터를 읽을 수 있다.
		 * 값을 읽을 수 있다		|
		 * ex) println(str[0])		| 특정 index 요소의 값을 변경할때는
		 * 							| List의 set(index) method를 통하여
		 * 							| 값을 변경할 수 있다
		 * 							|
		 * 배열은 코드가 실행되는	| List는 필요에 따라 size()가 
		 * 도중에 크기를 변경 불가	| 변경될수 있다
		 * 							| 							
		 * 							| remove(index) method를 통해서
		 * 							| index 위치의 item을 제거할 수 있다.
		 */
		
		
		// final 키워드가 선언된 변수는 다시 재정의 할 수 없다.
		// StdData.Student = new String[10];
		String[] str = new String[10];
		str = new String[20];
		str = new String[30];
		
	}
}
