package com.elquineas.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.elquineas.bank.exec.BuyerDto;
import com.elquineas.bank.service.impl.BuyerServiceImplV1;

public class BankService {
	protected List<BuyerDto> buyerList;
	protected final BuyerService buService;
	protected final Scanner scan;
	
	public BankService() {
		buyerList = new ArrayList<>();
		buService = new BuyerServiceImplV1();
		scan = new Scanner(System.in);
	}
	
	public void printBuyerList() {
		buyerList = buService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for(BuyerDto bDto : buyerList) {
			System.out.printf("%s\t",bDto.buId);
			System.out.printf("%s\t",bDto.buName);
			System.out.printf("%s\t",bDto.buTel);
			System.out.printf("%s\t",bDto.buAddr);
			System.out.printf("%s\t",bDto.buBirth);
			System.out.printf("%s\n",bDto.buJob);
		}	
		System.out.println("=".repeat(100));
	}
	
	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하려는 고객ID를 입력하세요");
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		BuyerDto buyerDto = buService.findById(strId);
		
		if(buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
		}else {
			System.out.println(buyerDto.toString());
		}
	}
	
	public void insertBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("고객정보 등록");
		System.out.println("=".repeat(100));

		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		System.out.print("고객명 >>> ");
		String strName = scan.nextLine();
		System.out.print("전화번호 >>> ");
		String strTel = scan.nextLine();
		
		BuyerDto buyerDto = new BuyerDto();
		buyerDto.buId = strId;
		buyerDto.buName = strName;
		buyerDto.buTel = strTel;
		
		buService.insert(buyerDto);
	}
	
	public void deleteBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객ID를 입력하세요");
		System.out.println("=".repeat(100));
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		
		BuyerDto buyerDto = buService.findById(strId);
		if(buyerDto == null) {
			System.out.printf("%s 고객ID는 없는 정보입니다.", strId);
		}else {
			System.out.println(buyerDto.toString());
			System.out.println("고객정보를 정말로 삭제할까요? (YES/NO)");
			String strYn = scan.nextLine();
			if(strYn.equals("YES")) {
				int result = buService.delete(strId);
				if(result > 0 ) {
					System.out.println("고객정보를 삭제했습니다.");
				}else {
					System.out.println("고객정보를 삭제하지 못했습니다.");
				}
			}else {
				System.out.println("고객정보 삭제를 취소했습니다.");
			}
		}
	}
	
	public void update() {
		while(true) {
			System.out.println("수정할 고객 ID를 입력하세요(취소 : QUIT)");
			System.out.print(">>> ");
			String strId = scan.nextLine();
			if(strId.equals("QUIT")){
				break;
			}
			BuyerDto buyerDto = buService.findById(strId);
			if(buyerDto == null) {
				System.out.printf("%s 고객ID는 없는 정보입니다.", strId);
				continue;
			}
			System.out.println(buyerDto.toString());
			System.out.printf("고객ID >> %s\n",buyerDto.buId);
			System.out.printf("고객이름(%s) >> ",buyerDto.buName);
			String strName = scan.nextLine();
			if( !strName.equals("") ) { buyerDto.buName = strName; }
			System.out.printf("전화번호(%s) >> ",buyerDto.buTel);
			String strTel = scan.nextLine();
			if( !strTel.equals("") ) { buyerDto.buTel = strTel; }
			
			int result = buService.update(buyerDto);
			if(result > 0 ) System.out.println("변경 성공");
			else System.out.println("변경 실패");
			
		}
	}
	
}
