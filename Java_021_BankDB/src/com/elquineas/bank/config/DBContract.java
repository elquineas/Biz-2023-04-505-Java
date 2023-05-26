package com.elquineas.bank.config;

/*
 * DB와 연결하는 Session(통로)를 만든 클래스 도구
 */
public class DBContract {
	public static final String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER_NAME = "C##myuser";
	public static final String PASSWORD = "12341234";
	
	public static class BUYER {
		public static final int  BUID    	= 1;
		public static final int  BUNAME    	= 2;
		public static final int  BUTEL     	= 3;
		public static final int  BUADDRESS 	= 4;
		public static final int  BUBIRTH 	= 5;
		public static final int  BUJOB 		= 6;
	}

	public static class ACC {
		public static final int  ACNUM    	= 1;
		public static final int  ACDIV    	= 2;
		public static final int  ACBUID    	= 3;
		public static final int  ACBALANCE 	= 4;
	}

	public static String[] ACC_DIV = {"입출금","적금","대출"};
	
}
