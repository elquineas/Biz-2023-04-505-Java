package com.callor.controller;

public class ControllerA {
	public static void main(String[] args) {
		double douNum = Math.random();
//		douNum = douNum * 50;
		douNum *= 50;
		int intNum = (int)douNum;
		intNum += 51;
		
		int rndNum = (int)(Math.random()*50)+51;
		System.out.println(rndNum);
	}
}
