package com.callor.classes.exec;

import com.callor.classes.module.MyClassC;

public class ExecH {
	/*
	 * 51 ~ 100까지 중의 임의의 랜덤수를 생성하여
	 * MyClassC의 prime() method에게 전달하고
	 * 소수인지 아닌지 결과를 Condole에 출력
	 */
	public static void main(String[] args) {
		MyClassC myC = new MyClassC();
		int rNum = (int)(Math.random()*50)+51;
		int result = myC.prime(rNum);
		
		if(result > 0) {
			System.out.println(rNum+" 는 소수");
		}else {
			System.err.println(rNum+" 는 소수아님");
		}
	}
	
}
