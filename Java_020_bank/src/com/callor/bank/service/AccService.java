package com.callor.bank.service;

import java.io.PrintWriter;
import com.callor.bank.models.AccDto;

/*
 * 계좌정보에 대한 interface
 * 
 * 1. 계좌개설
 * 	  계좌번호 신설
 * 2. 입금과 출금
 * 3. 입출금 리스트 출력
 * 4. 계좌데이터 저장
 * 5. 시작할때 계좌 데이터 읽어오기
 */

public interface AccService {
	public void accInit();			// 신규개설
	// 계좌번호 중복 확인
	// AccList에 계좌정보 항목만 setting하여 List에 추가
	
	public void inout();			// 입출금 등록
	/*
	 * 계좌번호 조회 : 이미 개설된 계좌인가?
	 * 				   아니면 거부
	 * 입금인가 출금인가?
	 * 			입금 : 금액입력 => 입력내용을 리스트에 추가
	 * 			출금 : 금액입력 => 출금할수 있나?
	 *  						   잔액 > 출금 => 출금 내용 추가
	 *  						   잔액 < 출금 => 출금 거부
	 * 
	 */
	public void printAccList();		// 계좌 리스트 출력

	public void saveAccList();		// 계좌 리스트 저장
	public void loadAccList();		// 계좌 데이터 읽어오기

}
