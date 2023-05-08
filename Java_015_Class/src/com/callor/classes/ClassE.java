package com.callor.classes;

import java.util.List;
/*
 * ClassE는 2개의 생성자 method를 가지고 있다.
 * 한 개는 매개변수가 없는 생성자 = 기본생성자
 * 한 개는 strList 매개변수를 가지고 있으며, this.strList를 초기화 시키는 코드가 있다.
 * 
 * 임의생성자를 만들면 기본생성자가 자동으로 생성되지 않는다.
 */
public class ClassE {
	private List<String> strList;
	// 기본생성자
	public ClassE() {
		// TODO Auto-generated constructor stub
	}
	// 임의생성자
	public ClassE(List<String> strList) {
		this.strList = strList;
	}
	
	public void printList() {
		System.out.println(strList.toString());
	}
}
