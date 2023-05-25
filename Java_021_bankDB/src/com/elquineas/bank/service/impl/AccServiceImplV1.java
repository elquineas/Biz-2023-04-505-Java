package com.elquineas.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elquineas.bank.config.DBConnection;
import com.elquineas.bank.config.DBContract;
import com.elquineas.bank.models.AccDto;
import com.elquineas.bank.models.BuyerDto;
import com.elquineas.bank.service.AccService;

public class AccServiceImplV1 implements AccService {
	protected final Connection dbConn;
	
	public AccServiceImplV1() {
		dbConn = DBConnection.getDBConn();
	}
	
	public List<AccDto> db2List(PreparedStatement pStr) throws SQLException{
		ResultSet result =  pStr.executeQuery();
		List<AccDto> accList = new ArrayList<>();
		while(result.next()) {
			AccDto accDto = result2Dto(result);
			accList.add(accDto);
		}
		pStr.close();
		result.close();
		return accList;
	}
	
	protected AccDto result2Dto(ResultSet result) throws SQLException {
		AccDto accDto = new AccDto();
		accDto.acNum     = result.getString(DBContract.ACC.ACNUM);
		accDto.acDiv     = result.getString(DBContract.ACC.ACDIV);
		accDto.acBuId    = result.getString(DBContract.ACC.ACBUID);
		accDto.acBalance = result.getInt(DBContract.ACC.ACBALANCE);
		return accDto;
	}
	
	@Override
	public List<AccDto> selectAll() {
		String sql = "SELECT   acnum, acdiv, acbuid, acbalance "
				   + "FROM     tbl_acc "
				   + "ORDER BY acnum ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			List<AccDto> accList = db2List(pStr);
			return accList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccDto findByAcNum(String acNum) {
		String sql = "SELECT   acnum, acdiv, acbuid, acbalance " 
				   + "FROM     tbl_acc " 
				   + "WHERE    acnum = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acNum);
			ResultSet result =  pStr.executeQuery();
			
			AccDto accDto = null;
			while(result.next()) {
				accDto = result2Dto(result);
			}
			pStr.close();
			result.close();
			return accDto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<AccDto> findByBuId(String acbuid) {
		String sql = "SELECT   acnum, acdiv, acbuid, acbalance " 
				   + "FROM     tbl_acc " 
				   + "WHERE    acbuid = ? "
				   + "ORDER BY acnum ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acbuid);
			List<AccDto> accList = db2List(pStr);
			return accList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(AccDto dto) {
		String sql = "INSERT INTO tbl_acc(acnum, acdiv, acbuid, acbalance) "
				   + "VALUES (?,?,?,?) ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.acDiv);
			pStr.setString(3, dto.acBuId);
			pStr.setInt(4, dto.acBalance);
			
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(AccDto dto) {
		String sql = "UPDATE tbl_acc "
				   + "   SET acbalance  = ? "
				   + " WHERE acNum      = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, dto.acBalance);
			pStr.setString(2, dto.acNum);
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int delete(String acbuid) {
		return 0;
	}
	
	public String MaxAcNum(String date) {
		String sql = "SELECT substr(MAX(acnum),9) "
				   + "FROM   tbl_acc "
				   + "WHERE  substr(acnum,0,8) = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				String MaxNum = result.getString(1);
				if(MaxNum == null) return "0";
				else return result.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
}
