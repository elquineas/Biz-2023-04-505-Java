package com.callor.classes.models;

public class StudentDto {
	public String stNum;
	public String stName;
	public String stDept;
	public int stGrade;
	public String stTel;
	public String stAddress;
	
	
	
	@Override
	public String toString() {
		return "StudentDto [stNum=" + stNum + ", stName=" + stName + ", stDept=" + stDept + ", stGrade=" + stGrade
				+ ", stTel=" + stTel + ", stAddress=" + stAddress + "]";
	}
	
}
