package com.callor.classes.module;

public class ServiceA {
	public ServiceA() {
		
	}
	public void score(int kor, int eng, int meth, int hist, int mus, int art, int sport) {
		int sum = kor+eng+meth+hist+mus+art+sport;
		float avg = sum/7f;
		
		System.out.printf("국어 : %3d\n",kor);
		System.out.printf("영어 : %3d\n",eng);
		System.out.printf("수학 : %3d\n",meth);
		System.out.printf("국사 : %3d\n",hist);
		System.out.printf("음악 : %3d\n",mus);
		System.out.printf("미술 : %3d\n",art);
		System.out.printf("체육 : %3d\n",sport);
		System.out.println("===============");
		System.out.printf("총점 : %3d\n",sum);
		System.out.printf("평균 : %.2f",avg);
	}
}
