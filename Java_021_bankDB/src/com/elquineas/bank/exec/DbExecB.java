package com.elquineas.bank.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elquineas.bank.config.DBContract;

public class DbExecB {
	/*
	 * DB(DBMS Server)에 연결하는 절차
	 * 1. Driver를 활성화(실행)
	 * 2. 접속정보를 통하여 연결
	 * 3. SQL 전송
	 * 4. 결과 받기
	 */
	public static void main(String[] args) {
		String sql = " SELECT buid, buname, butel, buaddr, bubirth, bujob FROM tbl_buyer ";
		
		//DB와 연결하기 위한 Input장치
		Connection conn = null;
		
		// jdbcDriver를 Loading하여 활성화
		try {
			Class.forName(DBContract.jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 연결정보를 설정하여 연결 준비
		try {
			conn = DriverManager.getConnection(
					DBContract.DB_URL,
					DBContract.USER_NAME,
					DBContract.PASSWORD
					);
			// DBMS에 연결하여 SQL 명령문 보내기
			// 문자열로 되어있는 SQL 명령문은 DBMS에 전달
			// 변환이 성공하면 pStr 객체에 저장
			PreparedStatement pStr = conn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			
			//DBMS 서버로 부터 전달된 데이터를 읽어오기
			// newx() method를 실행하여 가져오기
			// 더이상 읽을 데이터가 없으면 next는 false 리턴
			while(result.next()) {
				System.out.print(result.getString(DBContract.BUYER.BUID)+ "\t");
				System.out.print(result.getString(DBContract.BUYER.BUNAME)+ "\t");
				System.out.print(result.getString(DBContract.BUYER.BUTEL)+ "\t");
				System.out.print(result.getString(DBContract.BUYER.BUADDRESS)+ "\t");
				System.out.print(result.getString(DBContract.BUYER.BUBIRTH)+ "\t");
				System.out.println(result.getString(DBContract.BUYER.BUJOB));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
