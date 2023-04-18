package com.callor.controller;

public class ControllerE {
	public static void main(String[] args) {
		int intScore;
		for(int i=0; i<1000; i++){
			intScore = (int)(Math.random()*50)+51;
//			if(intScore < 51 || intScore > 100) {
//				System.out.println(intScore);
//			}
			if(!(intScore > 50 && intScore < 101)) {
				System.out.println(intScore);
			}
			
			if(intScore > 50 && intScore < 101){
			}else {
				System.err.println(intScore);
			}
		}
//		for(int i=0; i<51;) {
//			i = (int)(Math.random()*100);
//			intScore = i+1;
//			System.out.println(intScore);
//		}
		
		
		
		
		int num1 = 100;
		int num2 = 100;
		if(++num1 > 100 || ++num2 > 100){
			System.out.println("OK");
		}
		if(--num1 > 100 && --num2 > 100) {
			System.out.println("HELLO");
		}
	} 
}
