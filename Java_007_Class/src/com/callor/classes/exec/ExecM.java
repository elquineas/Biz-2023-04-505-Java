package com.callor.classes.exec;

import com.callor.classes.module.ServiceD;

public class ExecM {
	public static void main(String[] args) {
		ServiceD servD = new ServiceD();
		int rNum1 = (int)(Math.random()*50)+51;
		int rNum2 = (int)(Math.random()*50)+51;
		servD.add(rNum1, rNum2);
	}
}
