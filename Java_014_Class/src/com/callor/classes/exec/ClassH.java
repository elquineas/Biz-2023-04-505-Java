package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassH {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int rndNum = (int)(Math.random() * 50) + 51;
			numList.add(rndNum);
		}
		for (int i = 0; i < numList.size(); i++) {
			for (int j = i+1; j < numList.size(); j++) {
				if(numList.get(i) > numList.get(j)) {
					int num1 = numList.get(i);
					numList.set(i,numList.get(j));
					numList.set(j,num1);
				}
			}
		}
		System.out.print(numList.toString());
	}
}

