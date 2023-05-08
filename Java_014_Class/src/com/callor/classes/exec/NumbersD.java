package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class NumbersD {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < 45; i++) {
			numList.add(i+1);
		}
		for(int i = 0; i < 1000; i++) {
			int rNum1 = (int)(Math.random() * numList.size());
			int rNum2 = (int)(Math.random() * numList.size());
			int num = numList.get(rNum1);
			numList.set(rNum1,numList.get(rNum2));
			numList.set(rNum2,num);
		}
		for(int i = 0; i < 6; i++) {
			System.out.print(numList.get(i)+"\t");
		}
	}
}
