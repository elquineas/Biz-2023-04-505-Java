package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassE {
	public static void main(String[] args) {
		// Generic Type : <>로 감싸진 클래스 type
		// numList 에 추가할수 있는 데이터는 정수만 가능하도록 한다
		// Generic Type은 primitive type은 사용할수 없다.
		// 반드시 클래스 (wrapper class, data class)만 사용할 수 있다.
		
		// numList에는 정수만 추가할수 있는 규칙부여
		List<Integer> numList = new ArrayList<>();
		System.out.println(numList.size());
		
		numList.add(10);
		numList.add(20);
		numList.add(30);
		numList.add(40);
		numList.add(50);
		System.out.println(numList.size());
		
		numList.add(3,100);
		numList.add(3,200);
		
		for(int i = 0; i< numList.size(); i++) {
			System.out.print(numList.get(i)+"\t");
		}
		
	}
}
