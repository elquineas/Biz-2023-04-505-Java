package com.elquineas.bank.exec;

import java.util.Scanner;

import com.elquineas.bank.service.BankService;

public class DbExecF_Acc {
	public static void main(String[] args) {
		BankService bService = new BankService();
		bService.printAccList();
		bService.findByAcc();
	}
}
