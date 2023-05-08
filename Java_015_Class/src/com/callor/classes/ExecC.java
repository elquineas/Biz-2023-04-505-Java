package com.callor.classes;

import java.util.ArrayList;
import java.util.List;

public class ExecC {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("우리나라만세");
		strList.add("대한민국");
		strList.add("Republic of Korea");
		
//		ClassE classE = new ClassE();
//		classE.printList();
		ClassE classE1 = new ClassE(strList);
		classE1.printList();
	}
}
