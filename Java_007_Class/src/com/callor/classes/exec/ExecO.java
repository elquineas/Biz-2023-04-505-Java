package com.callor.classes.exec;

import com.callor.classes.module.ServiceF;

public class ExecO {
	public static void main(String[] args) {
		ServiceF servF = new ServiceF();
		int kor = (int)(Math.random()*50)+51;
		int eng = (int)(Math.random()*50)+51;
		int math = (int)(Math.random()*50)+51;
		int hist = (int)(Math.random()*50)+51;
		int mus = (int)(Math.random()*50)+51;
		int art = (int)(Math.random()*50)+51;
		int ath = (int)(Math.random()*50)+51;
		servF.score(kor,eng,math,hist,mus,art,ath);
	}
}
