package com.callor.exam.models;

public class GuideDto {
	public String id;
	public String item;
	public int seq;
	public String guide;
	
	public GuideDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "GuideDto [id=" + id + ", item=" + item + ", seq=" + seq + ", guide=" + guide + "]";
	}	
	
}
