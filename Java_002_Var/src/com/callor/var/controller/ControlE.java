package com.callor.var.controller;

public class ControlE {
	public static void main(String[] args) {
		int intRnd = ((int) (Math.random() * 10) + 1);

		if (intRnd % 3 == 0) {
			System.out.println(intRnd + "은(는) 3의 배수");
		}
		if (intRnd % 3 != 0) {
			System.err.println(intRnd + "은(는) 3의 배수가 아니다");
		}
		
		// 내가 원하는 목정 : 3의 배수인 경우도 한번 아닌가를 ㄸㄸㄸㄸㄸㄸㄸㄸㄸㄸㄸㄷ확인하여
		// 다소 비효율적인 코드 진행이 된다,
		if(intRnd % 3 == 0) {
			System.out.println(intRnd + "은(는) 3의 배수");
		// 내가 원하는 목정르 당성하지 못했ㅇㄹ 경우
		}else {
			System.err.println(intRnd + "은(는) 3의 배수가 아니다");
		}
	}
}
