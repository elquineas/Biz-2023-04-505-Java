package com.callor.classes.exec;

import com.callor.classes.module.ServiceC;

public class ExecL {
	public static void main(String[] args) {
		ServiceC servC = new ServiceC();
		int rNum = (int)(Math.random()*10);
		servC.guguDan(rNum);
	}
}
