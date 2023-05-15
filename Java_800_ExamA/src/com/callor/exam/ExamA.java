package com.callor.exam;

public class ExamA {
	public static void main(String[] args) {
		int index = 0;
		for(index = 0; index< 100; index++) {
			int rNum = (int)(Math.random()*50)+1;
			if(rNum < 1 && rNum > 100) {
				break;
//				System.out.println(rNum + " 값은 범위에 포함된");
			}
		}
		if(index >= 100) {
			System.out.println("100 번 수행결과 1~100까지의 랜덤수를 만들어내고 있습니다.");
		}else{
			System.out.println("테스트 횟수 : "+ index+1);
			System.out.println("100 번 수행결과 "+index+1+"번째에서 실패함");
		}
	}
}
