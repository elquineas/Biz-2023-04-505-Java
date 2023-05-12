package com.callor.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.service.GuideService;
import com.callor.service.impl.GuideServiceImplV1;

public class GuideExecA {
	public static void main(String[] args) {
		GuideService gService = new GuideServiceImplV1();
		
		gService.loadGuide();
		gService.printGuideList();
		
		List<Integer> numList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		for(int i = 0; i< 30; i++) {
			int rNum = (int)(Math.random()*50)+51;
			numList.add(rNum);
		}
		
		for(int i = 0; i< numList.size(); i++) {
			int result = prime(numList.get(i));
			if(result > 0) {
				tempList.add(numList.get(i));
			}
		}
		
		int sum = 0;
		for(int i = 0; i<tempList.size(); i++) {
			sum += tempList.get(i);
		}
		System.out.printf("소수 개수 : %d\n",tempList.size());
		System.out.printf("소수의 합 : %d",sum);
		
	}
	
	public static int prime(int num) {
		for(int i = 2; i < num; i++) {
			if(num%i == 0) {
				return 0;
			}
		}
		return num;
	}
		
}
