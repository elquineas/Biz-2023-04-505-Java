package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.service.AccService;
import com.callor.bank.utils.Line;

public class AccServiceImplV1 implements AccService {
	protected List<AccDto> acList;
	protected AccDto acDto;
	
	public AccServiceImplV1() {
		acList = new ArrayList<>();
		acDto  = new AccDto();
	}
	
	@Override
	public void accInit() {
		
	}

	
	@Override
	public void inout() {
		String acNum = "0001";
		Scanner scan = new Scanner(System.in);
		int total = getTotal();
		while(true) {
			acDto = new AccDto();
			System.out.println(Line.dLine(100));
			System.out.println("1. 입금 2.출금 3.잔액조회");
			System.out.print(">>> ");
			String text = scan.nextLine();
			System.out.println(Line.sLine(100));
			if(text.equals("1")) {
				System.out.print("입금액을 입력하세요 >>> ");
				String acInputString = scan.nextLine();
				try {
					int acInput =  Integer.valueOf(acInputString);
					acDto.acNum   = acNum;
					acDto.acDiv   = "입금";
					acDto.acInput = acInput;
					acDto.acDate  = "";
					acDto.acTime  = "";
					acList.add(acDto);
					
					System.out.println("입금이 완료되었습니다.");
				} catch (Exception e) {
					System.err.println("숫자만 입력해주세요.");
				}
			}else if(text.equals("2")) {
				System.out.print("출금액을 입력하세요 >>> ");
				String acOutputString = scan.nextLine();
				try {
					int acOutput =  Integer.valueOf(acOutputString);
					total = getTotal();
					if(total < acOutput) {
						System.err.println("잔액이 부족합니다.");
					}else if(total >= acOutput) {
						acDto.acNum    = acNum;
						acDto.acDiv    = "출금";
						acDto.acOutput = acOutput;
						acDto.acDate   = "";
						acDto.acTime   = "";
						acList.add(acDto);
						System.out.println("출금이 완료되었습니다.");
					}
				} catch (Exception e) {
					System.err.println("숫자만 입력해주세요.");
				}
			}else if(text.equals("3")) {
				total = getTotal();
				System.out.printf("잔액 >>> %d\n",total);
			}
		}
		
		
		
		
	}
	

	public int getTotal() {
		int total = 0;
		for(AccDto dto : acList) {
			total += dto.acInput;
			total -= dto.acOutput;
		}
		return total;
	}
	
	

	@Override
	public void printAccList() {
		
	}

	@Override
	public void saveAccList() {
		
	}

	@Override
	public void loadAccList() {
		
	}

}
