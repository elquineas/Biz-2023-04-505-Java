package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecJ {
	public static void main(String[] args) {
		ServiceA serviceA = new ServiceA();
		int num1 = (int)(Math.random()*50)+51;
		int num2 = (int)(Math.random()*50)+51;
		int result = serviceA.add(num1, num2);
		
		System.out.printf("NUM1 : %3d\nNUM2 : %3d\n",num1, num2);
		System.out.printf("SUM  : %3d",result);
	}
}
