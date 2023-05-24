package com.elquineas.bank.exec;

import java.util.Scanner;

import com.elquineas.bank.config.BankInfo;
import com.elquineas.bank.service.BankService;

public class DbExecE {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankService bService = new BankService();

		while(true) {
			BankInfo.headerPrint();
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
			else if(intSelect == 6) bService.findByUserInfo();
			else if(intSelect == 7) bService.makeAcount();
			
		}
		System.out.println("업무 종료.");
	}
}
