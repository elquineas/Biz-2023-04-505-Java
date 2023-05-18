package com.callor.bank.models;

/*
 * 거래리스트 데이터 클래스
 * 계좌번호	문자열(10)	acNum
 * 거래일자	문자열		aiDate
 * 거래시각	문자열		aiTime
 * 거래구분	문자열		aiDiv
 * 입금		정수형		aiInput
 * 출금		정수형		aiOutput
 */

public class AccIoDto {
	public String acNum;
	public String aiDate;
	public String aiTime;
	public String aiDiv;
	public int 	  aiInput;
	public int 	  aiOutput;
	
	public AccIoDto() {
		super();
	}

	public AccIoDto(String acNum, String aiDate, String aiTime, String aiDiv, int aiInput, int aiOutput) {
		super();
		this.acNum = acNum;
		this.aiDate = aiDate;
		this.aiTime = aiTime;
		this.aiDiv = aiDiv;
		this.aiInput = aiInput;
		this.aiOutput = aiOutput;
	}

	@Override
	public String toString() {
		return "AccIoDto [acNum=" + acNum + ", aiDate=" + aiDate + ", aiTime=" + aiTime + ", aiDiv=" + aiDiv
				+ ", aiInput=" + aiInput + ", aiOutput=" + aiOutput + "]";
	}

}
