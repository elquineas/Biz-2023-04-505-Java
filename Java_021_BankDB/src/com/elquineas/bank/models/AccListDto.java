package com.elquineas.bank.models;

public class AccListDto {
	public long aioSeq;		//NUMBER
	public String acNum;	//VARCHAR2(20)
	public String aioDate;	//VARCHAR2(10)
	public String aioTime;	//VARCHAR2(10)
	public String aioDiv;	//VARCHAR2(1)
	public int aioInput;	//NUMBER
	public int aioOutput;	//NUMBER
	public String aioRem;	//VARCHAR2(30)

	public AccListDto() {
		super();
	}

	public AccListDto(long aioSeq, String acNum, String aioDate, String aioTime, String aioDiv, int aioInput,
			int aioOutput, String aioRem) {
		super();
		this.aioSeq = aioSeq;
		this.acNum = acNum;
		this.aioDate = aioDate;
		this.aioTime = aioTime;
		this.aioDiv = aioDiv;
		this.aioInput = aioInput;
		this.aioOutput = aioOutput;
		this.aioRem = aioRem;
	}

	@Override
	public String toString() {
		return "AccListDto [aioSeq=" + aioSeq + ", acNum=" + acNum + ", aioDate=" + aioDate + ", aioTime=" + aioTime
				+ ", aioDiv=" + aioDiv + ", aioInput=" + aioInput + ", aioOutput=" + aioOutput + ", aioRem=" + aioRem
				+ "]";
	}
}
