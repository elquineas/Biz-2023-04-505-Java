package com.callor.bank.exec;

import java.util.Scanner;

import com.callor.bank.service.AccService;
import com.callor.bank.service.BuyerService;
import com.callor.bank.service.impl.AccServiceImplV1;
import com.callor.bank.service.impl.BuyerServiceImplV1;

public class BankExecA {
	public static void main(String[] args) {
		BuyerService buService = new BuyerServiceImplV1();
		AccService acService = new AccServiceImplV1();
		Scanner scan = new Scanner(System.in);
//		buService.loadBuyer();
//		buService.InputBuyer();

//		PrintWriter out = new PrintWriter(System.out);
//		buService.printBuyerList(out);
//		out.close();
//		buService.printBuyerList();

		acService.inout();
	}
}
