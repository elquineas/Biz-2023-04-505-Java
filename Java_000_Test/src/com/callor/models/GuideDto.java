package com.callor.models;

//id,종목명,순번,가이드
public class GuideDto {
	public String guId;
	public String guList;
	public String guSeq;
	public String guGuide;
	
	public GuideDto() {
	}
	public GuideDto(String guId,String guList,String guSeq,String guGuide) {
		this.guId	= guId;
		this.guList = guList;
		this.guSeq 	= guSeq;
		this.guGuide = guGuide;
	}
	
	@Override
	public String toString() {
		return "GuideDto [guId=" + guId + ", guList=" + guList + ", guSeq=" + guSeq + ", guGuide=" + guGuide + "]";
	}
	
	
}
