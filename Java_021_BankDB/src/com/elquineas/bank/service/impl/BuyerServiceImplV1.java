package com.elquineas.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elquineas.bank.config.DBConnection;
import com.elquineas.bank.config.DBContract;
import com.elquineas.bank.models.BuyerDto;
import com.elquineas.bank.service.BuyerService;

public class BuyerServiceImplV1 implements BuyerService{
	
	protected final Connection dbConn;
	
	public BuyerServiceImplV1() {
		dbConn = DBConnection.getDBConn();
	}
	
	/*
	 * SQL 명령문 작성 주의!!!
	 * WHERE절 명령문을 작성할때 
	 * 절대 변수와 전달값을 + 연산으로 묶어서 처리하지 말것
	 * +"WHERE buid = " + id;
	 *  id 변수에 0001 or 1=1 과 같은 문자열이 담겨서 전달될 경우 WHERE가 무력화 된다.
	 *  SQL문이 DELETE와 같은 명령이라면 TABLE의 모든 데이터가 삭제되는 명령이 실행된다.
	 *  ==> SQL Injection 공격 이라고 한다.
	 */
	@Override
	public BuyerDto findById(String id) {
		String sql = 
				"SELECT "
				+"buid, buname, butel, buaddr, bubirth, bujob "
				+"FROM  tbl_buyer "
				+"WHERE buid = ? ";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, id);
			
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				return result2Dto(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(BuyerDto bDto) {
		
		String sql = "INSERT INTO tbl_buyer(buid, buname, butel) "
				   + "VALUES (?,?,?) ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bDto.buId);
			pStr.setString(2, bDto.buName);
			pStr.setString(3, bDto.buTel);
			
			// SQL로 전달하는 명령대로 DB를 변경(INSERT)하라는 의미
			// 정상 적으로 실행시 1
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(BuyerDto bDto) {
		String sql = "UPDATE tbl_buyer "
				   + "SET    buname  = ? , "
				   + "       butel   = ? , "
				   + "       buaddr  = ? , "
				   + "       bubirth = ? , "
				   + "       bujob   = ? "
				   + "WHERE  buid = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bDto.buName);
			pStr.setString(2, bDto.buTel);
			pStr.setString(3, bDto.buAddr);
			pStr.setString(4, bDto.buBirth);
			pStr.setString(5, bDto.buJob);
			pStr.setString(6, bDto.buId);
			return pStr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM tbl_buyer "
				   + "WHERE buid = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, id);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	protected BuyerDto result2Dto(ResultSet result) {
		BuyerDto buyerDto = new BuyerDto();
		try {
			buyerDto.buId    = result.getString(DBContract.BUYER.BUID);
			buyerDto.buName  = result.getString(DBContract.BUYER.BUNAME);
			buyerDto.buTel   = result.getString(DBContract.BUYER.BUTEL);
			buyerDto.buAddr  = result.getString(DBContract.BUYER.BUADDRESS);
			buyerDto.buBirth = result.getString(DBContract.BUYER.BUBIRTH);
			buyerDto.buJob 	 = result.getString(DBContract.BUYER.BUJOB);
			return buyerDto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BuyerDto> selectAll() {
		List<BuyerDto> buyerList = new ArrayList<>();
//		buyerList.clear();
		String sql = "SELECT   buid, buname, butel, buaddr, bubirth, bujob "
				   + "FROM     tbl_buyer "
				   + "ORDER BY buid ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			
			while(result.next()) {
				BuyerDto buyerDto = result2Dto(result);
				buyerList.add(buyerDto);
			}
			return buyerList;
			
		} catch (SQLException e) {

		}
		return null;
	}
	

}
