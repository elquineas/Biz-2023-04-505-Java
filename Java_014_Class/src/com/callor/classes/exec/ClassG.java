package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassG {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int rndNum = (int)(Math.random() * 50) + 51;
			numList.add(rndNum);
		}

		for (int i = 0; i < numList.size(); i++) {
			if(numList.get(i)%2 == 0) {
				System.out.print(numList.get(i)+"\t");
			}
		}

		
		// 리스트 마지막에 30 추가
		// indexList.add(30)
		// 리스트 0번째 삭제
		// indexList.remove(0)
		// 리스트 0번째에 30값 추가
		// indexList.add(0,30)
		// num에 리스트 0번재 값 저장
		// int num = indexList.get(0)
		// 리스트 0번의 값을 30으로 수정
		// indexList.set(0,30)
		// 리스트의 모든값 출력
		// indexList.toString()
		
		
		
	}
}
