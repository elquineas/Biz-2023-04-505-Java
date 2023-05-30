package com.callor.shop.models;

/*
	상품코드	문자열(13)		pCode
	상품명		한글문자열(50)	pName
	품목		문자열(10)		pItem
	매입단가	정수형			pIPrice
	매출단가	정수형			pOPrice
 */
public class ProductDto {
	public String pCode;
	public String pName;
	public String pItem;
	public int 	  pIPrice;
	public int 	  pOPrice;
	
	public ProductDto() {
		super();
	}
	
	public ProductDto(String pCode, String pName, String pItem, int pIPrice, int pOPrice) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pItem = pItem;
		this.pIPrice = pIPrice;
		this.pOPrice = pOPrice;
	}
	
	@Override
	public String toString() {
		return "ProductDto [pCode=" + pCode + ", pName=" + pName + ", pItem=" + pItem + ", pIPrice=" + pIPrice
				+ ", pOPrice=" + pOPrice + "]";
	}
	
}
