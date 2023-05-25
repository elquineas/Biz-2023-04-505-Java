package com.elquineas.bank.exec;

import java.util.Scanner;

import com.elquineas.bank.config.BankInfo;
import com.elquineas.bank.service.BankService;

public class DbExecG_AccList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankService bService = new BankService();
		while(true) {
			bService.insertAccList();
		}
	}
}
