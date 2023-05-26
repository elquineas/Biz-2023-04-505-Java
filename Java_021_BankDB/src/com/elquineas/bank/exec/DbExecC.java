package com.elquineas.bank.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.prefs.BackingStoreException;

import com.elquineas.bank.config.DBContract;
import com.elquineas.bank.service.BankService;

public class DbExecC {
	
	public static void main(String[] args) {
		BankService bService = new BankService();
		bService.printBuyerList();
	}
}
