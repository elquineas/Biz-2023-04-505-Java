package com.callor.exam;

import java.util.ArrayList;
import java.util.List;

import com.callor.exam.service.GuideService;
import com.callor.exam.service.impl.GuideServiceImplV1;

public class ExamC {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		for(int i = 0; i< 30; i++) {
			int rNum = (int)(Math.random()*50)+51;
			numList.add(rNum);
		}
		
		int count = 0;
		int total = 0;
		for(Integer num : numList) {
			if(prime(num) > 0) {
				count++;
				total += num;
			}
		}
		System.out.printf("소수 개수 : %d\n",count);
		System.out.printf("소수의 합 : %d",total);
		
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
