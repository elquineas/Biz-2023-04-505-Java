package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecA {
	public static void main(String[] args) {
		ServiceA servA = new ServiceA();
		int kor = (int)(Math.random()*50)+51;
		int eng = (int)(Math.random()*50)+51;
		int meth = (int)(Math.random()*50)+51;
		int hist = (int)(Math.random()*50)+51;
		int mus = (int)(Math.random()*50)+51;
		int art = (int)(Math.random()*50)+51;
		int sport = (int)(Math.random()*50)+51;
		
		servA.score(kor,eng,meth,hist,mus,art,sport);
	}
}
