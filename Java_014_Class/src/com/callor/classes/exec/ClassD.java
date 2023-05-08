package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ClassD {
	public static void main(String[] args) {
		/*
		 * 배열
		 * 다수의 데이터를 연속된 공간에 저장하는 변수
		 * 단점 : 한번 크기가 정해지면 
		 *        코드가 실행되는 중간에는 크기를 변경할 수 없다.
		 *        
		 * 저장할 데이터릐 개수가 변겨오디어야 하는 경우가 많다.
		 * Java에서는 배열의 개수를 코드가 실행되는 도중에 자유롭게 변경할수 있도록
		 * List라는 컬렉션 도구를 제공하고 있다
		 */
		int[] nums = new int[10];
		/*
		 * 객체지향에서 클래스의 상속(implements)
		 * List<> 클래스는 ArrayList, LinkedList, Vector 클래스의 부모이다.
		 * ArryList, LinkedList, Vector 클래스는 List 클래스를 상속받았다.
		 */
		List<Integer> numList = new ArrayList<>();
		numList = new LinkedList<>();
		numList = new Vector<>();
		
		ArrayList<Integer> arrList	 = new ArrayList<>();
		LinkedList<Integer> linkList = new LinkedList<>();
		Vector<Integer> vecList 	 = new Vector<>();
		
		
		
	}
}
