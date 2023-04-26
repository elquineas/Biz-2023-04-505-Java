package com.callor.classes.exec;
/*
 * Java의 Class
 * 객체지향 프로그래밍 방법론적인 부분에서
 * 가장 표준적인 코딩 스타일
 * 
 * Java는 모든 코드(파일)가 기본적으로 class로 부터 시작한다
 * 
 * Java의 소스코드는 *.java라는 이름으로 파일이 저장되지만
 * Java Class 파일 이라고 명명한다
 * 
 * method들이 포함되고, 변수들이 포함된다.
 * method만 있는 클래스 파일이 있고,
 * 변수들만 있는 클래스 파일이 있고,
 * method와 변수가 함께 있는 파일이 있다.
 * 
 * 코드를 테스트하고 실행하기 위해 main() method를 작성한다
 * main() method를 진입점, 시작점 method라고 하면
 * main() method를 포함하는 java class 코드를 진입점 코드 라고 한다
 */
public class ExecA {
	public static void main(String[] args) {
		 int num = (int)(Math.random()*50)+51;
		 int[] nums = new int[10];
		 nums[0] = 100;
		 nums[1] = 33;
		 nums[2] = 44;
		 nums[3] = 55;
		 nums[4] = 66;
		 nums[5] = 77;
		 nums[6] = 88;
		 nums[7] = 99;
		 nums[8] = 11;
		 nums[9] = 22;		 
		 
		 num = nums[3];
		 System.out.println(num);
		 System.out.println(nums[5]);
				
		 
	}
}
