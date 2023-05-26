package com.callor.bank.service.impl;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.AccService;
import com.callor.bank.utils.AnsiConsol;
import com.callor.bank.utils.Config;
import com.callor.bank.utils.Line;

/*
 * 신규계좌 등록하기
 * 1. 고객번호를 입력받기
 * 2. 고객번호를 입력하면 고객정보가 있는가 확인
 * 		BuyerServiceImplV1.getBuyer() 메소드를 사용하여 고객정보 찾기
 * 		없으면 : 고객정보를 등록하세요 라고 메시지 표현
 * 3. 고객번호가 있으면 신규 계좌를 생성
 */


public class AccServiceImplV1 implements AccService {
	protected BuyerServiceImplV1 buService;
	protected Scanner scan;
	protected List<AccDto> acList;
	
	public AccServiceImplV1() {
		buService = new BuyerServiceImplV1();
		scan = new Scanner(System.in);
		acList = new ArrayList<>();
	}
	
	protected String getNewAccNum() {
		// 컴퓨터의 현재 시각을 get하는 클래스
		// System.currentTimeMillis()
		//		1970.01.01.00:00:00.000 부터 시작하여
		//		현재시점까지 카운트된 밀리세컨드 값
		// 이 값을 Date 클래스의 생성자에 전달하면
		// 현재날짜, 시각 정보를 알수 있는 객체로 생성해 준다.
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		
		
		int maxNum = 0;
		String numBank = "1000";
		for(AccDto acDto : acList) {
			String acNum  = acDto.acNum;
			
			// bank 코드 추출
			numBank = acNum.substring(0,4) ;
			// 날짜부분 추출
			String numDate = acNum.substring(5, 
					String.format("%s-%s",numBank,todayString).length());
			
			if(numDate != null && numDate.equals(todayString)){
				// 일련번호 부분만 추출하기
				String lastNum = acNum.substring(
						String.format("%s-%s-",numBank,todayString).length());
				int intNum = Integer.valueOf(lastNum);
				if(intNum > maxNum) maxNum = intNum;
			}
		}// end for
		
		// maxNum 은 0 또는 최대값
		String newNum = String.format("%s-%s-%04d", numBank, todayString, maxNum+1);
		return newNum;
	}
	
	@Override
	public void accInit() {
		String buId;
		Config.bankTitle("계좌생성");
		while(true) {
//			System.out.println(Line.dLine(100));
			while(true) {
				System.out.println(AnsiConsol.blue+ "고객번호를 입력해주세요."+AnsiConsol.exit);
				System.out.print(">>> ");
				buId = scan.nextLine();
				if(buId.equals("QUIT")) break;
				
				try {
					int intBuId = Integer.valueOf(buId);
					buId = String.format("%04d", intBuId);
					BuyerDto buDto =  buService.getBuyer(buId);
					AccDto acDto = new AccDto();
					
					if(buDto == null) {
						System.out.println(AnsiConsol.red+ "고객정보가 없습니다.");
						System.out.println("고객정보를 등록해주세요."+AnsiConsol.exit);
						System.out.println(Line.sLine(100));
						continue;
					}else {
						// 계좌확인
						// 있으면 PAA
						// 없으면 바로생성
//						for(AccDto dto : acList) {
//							if(dto.buId.equals(buId)) {
//								System.out.println(AnsiConsol.red);
//								System.out.println("이미 생성된 계좌가 있습니다.");
//								System.out.println(AnsiConsol.exit);
//							}
//							
//						}
//						if() {
//							
//						}
						System.out.println("계좌가 생성되었습니다.");
						String accNum = getNewAccNum();
						acDto.acNum = accNum;
						acDto.buId = buId;
						acDto.acDiv = "";
						acDto.acBalance = 0;
						acList.add(acDto);
						System.out.println(acList.toString());
						
					}
					
				} catch (Exception e) {
					System.out.println("올바른 고객번호를 입력해주세요");
					continue;
				}
			}
//			System.out.println(Line.dLine(100));
//			System.out.println("신규 계좌를 생성합니다.");
//			System.out.println(Line.sLine(100));
			
		}
		
	}

	@Override
	public void inout() {
		
	}

	@Override
	public void printAccList() {
		OutputStream os = System.out;
		PrintWriter out = new PrintWriter(os);

		System.out.println(Line.dLine(100));
		System.out.println("계좌 정보 리스트");
		System.out.println(Line.sLine(100));
		System.out.println("고객ID\t계좌번호\t최종잔액\t계좌구분");
		printAccList(out);
		out.println(Line.dLine(100));
		out.close();
	}
	
	@Override
	public void printAccList(PrintWriter out) {
		for(AccDto dto : acList) {
			out.printf("%s\t",dto.buId);
			out.printf("%s\t",dto.acNum);
			out.printf("%s\t",dto.acDiv);
			out.printf("%d\n",dto.acBalance);
		}
	}
	
	

	@Override
	public void saveAccList() {
		
	}

	@Override
	public void loadAccList() {
		
	}
	
}
