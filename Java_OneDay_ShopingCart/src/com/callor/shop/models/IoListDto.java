package com.callor.shop.models;

/*
	SEQ			정수형		ioSEQ
	거래일자	문자열(10)	ioDate
	거래시각	문자열(10)	ioTime
	고객ID		문자열(10)	ioBuid
	상품코드	문자열(13)	ioPCode
	수량		정수형		ioQuan
	판매단가	정수형		ioPrice

 */
public class IoListDto {
	public int ioSEQ;
	public String ioDate;
	public String ioTime;
	public String ioBuid;
	public String ioPCode;
	public int ioQuan;
	public int ioPrice;
	
	public IoListDto() {
		super();
	}

	public IoListDto(int ioSEQ, String ioDate, String ioTime, String ioBuid, String ioPCode, int ioQuan, int ioPrice) {
		super();
		this.ioSEQ = ioSEQ;
		this.ioDate = ioDate;
		this.ioTime = ioTime;
		this.ioBuid = ioBuid;
		this.ioPCode = ioPCode;
		this.ioQuan = ioQuan;
		this.ioPrice = ioPrice;
	}

@Override
	public String toString() {
		return "IoListDto [ioSEQ=" + ioSEQ + ", ioDate=" + ioDate + ", ioTime=" + ioTime + ", ioBuid=" + ioBuid
				+ ", ioPCode=" + ioPCode + ", ioQuan=" + ioQuan + ", ioPrice=" + ioPrice + "]";
	}
}
