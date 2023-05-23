package com.elquineas.bank.exec;

import java.util.Scanner;

import com.elquineas.bank.service.BankService;

public class DbExecE {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankService bService = new BankService();

		while(true) {
			System.out.println("=".repeat(100));
			System.out.println("대한은행 고객관리 시스템");
			System.out.println("=".repeat(100));
			System.out.println("수행할 업무를 선택하세요.");
			System.out.println("  1. 고객 추가");
			System.out.println("  2. 고객 정보 수정");
			System.out.println("  3. 고객 정보 삭제");
			System.out.println("  4. 고객 리스트");
			System.out.println("  5. 고객 검색");
			System.out.println("  9. 업무 종료");
			System.out.println("-".repeat(100));
			System.out.print(">> ");
			String strSelect = scan.nextLine();
			int intSelect = 0;
			try {
				intSelect = Integer.valueOf(strSelect);
			} catch (Exception e) {
				System.err.printf("업무 선택을 잘못하였습니다.(%s)\n",strSelect);
				continue;
			}
			if(intSelect == 9) break;
			else if(intSelect == 1) bService.insertBuyer();
			else if(intSelect == 2) bService.update();
			else if(intSelect == 3) bService.deleteBuyer();
			else if(intSelect == 4) bService.printBuyerList();
			else if(intSelect == 5) bService.findByBuyer();
			
		}
		System.out.println("업무 종료.");
	}
}
