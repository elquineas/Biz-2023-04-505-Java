package com.callor.classes.module;

public class ServiceC {
	public ServiceC() {
		
	}
	public void guguDan(int num1) {
		System.out.println("랜덤수 : "+num1);
		if(num1 >= 2 && num1 <= 9) {
			for(int i = 1; i<10; i++) {
				System.out.printf("%2d X %2d = %2d\n",num1,i,num1*i);
			}
		}
		
	}
}
