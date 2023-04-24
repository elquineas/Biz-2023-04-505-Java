package com.callor.classes.module;

public class ServiceF {
	public ServiceF() {
		
	}
	public void score(int kor,int eng,int math,int hist,int mus,int art,int ath) {
		int sum = kor+eng+math+hist+mus+art+ath;
		float avg = sum/7;
		System.out.printf("총점 : %3d\n",sum);
		System.out.printf("평균 : %3.2f\n",avg);
		
	}
}
