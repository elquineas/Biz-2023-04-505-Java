package com.callor.classes.exec;

public class ClassC {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		
		// 새로운 배열 20개 생성
		// 배열은 만들어진 상태에서 크기를 변경하거나 할수 없다.
		// nums = new int[20];
		
		// 배열 요소 전부를 반복하는 확장된 for 반복문 (for Each)
		// 0번 index부터 끝 index까지 무조건 반복
		// nums 배열요소를 모두 펼쳐놓고, 0번 index부터 끝 index까지 순서대로
		// num 변수에 저장하여 {}코드에서 사용할수 있도록 한다.
		for(int num : nums) {
			System.out.print(num + "\t");
		}
		
	}
}
