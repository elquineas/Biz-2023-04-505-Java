package com.elquineas.system.var;

public class VarBA {
	public static void main(String[] args) {
		
		// 작은 정수
		int intNum1 = 0;
		// 단정도 실수
		float floatNum1 = 0.0f;
		// 큰 정수
		long longNum1 = 0;
		// 배정도 실수
		double douNum1 = 0.0;
		
		// 데이터의 형병환(type cast, convert)
		
		// int형 데이터를 long형 변수에 저장
		longNum1 = intNum1; // 자동형변환, 암시적형변환
		// long형 데이터를 int형 변수에 저장
		intNum1 = (int)longNum1; // 강제형변환, 명시적형변환
		
		// double형 데이터를 float형 변수에 저장
		floatNum1 = (float)douNum1;
		// float형 데이터를 double형 변수에 저장
		douNum1 = floatNum1;
	}
}
