package com.callor.shop.models;

/*
	고객ID		문자열(10)		buId
	고객이름	한글문자열(20)	buName
	전화번호	문자열(13)		buTel
	주소		한글문자열(125)	buAddr
 */
public class BuyerDto {
	public String buId;
	public String buName;
	public String buTel;
	public String buAddr;
	
	public BuyerDto() {
		super();
	}
	
	public BuyerDto(String buId, String buName, String buTel, String buAddr) {
		super();
		this.buId = buId;
		this.buName = buName;
		this.buTel = buTel;
		this.buAddr = buAddr;
	}
	
	@Override
	public String toString() {
		return "BuyerDto [buId=" + buId + ", buName=" + buName + ", buTel=" + buTel + ", buAddr=" + buAddr + "]";
	}
	
}
