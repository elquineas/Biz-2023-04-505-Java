package com.elquineas.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.elquineas.bank.config.DBConnection;
import com.elquineas.bank.models.AccListDto;
import com.elquineas.bank.service.AccListService;

public class AccListServiceImplV1 implements AccListService {

	protected final Connection dbConn;
	
	public AccListServiceImplV1() {
		dbConn = DBConnection.getDBConn();
	}
	
	@Override
	public List<AccListDto> selectAll() {
		return null;
	}

	@Override
	public AccListDto findById(long seq) {
		return null;
	}

	@Override
	public int insert(AccListDto dto) {
		String sql = "INSERT INTO tbl_accList(aioSeq, acNum, aiodate, aiotime, aiodiv, aioinput, aiooutput) "
				   + "VALUES(seq_accList.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.aioDate);
			pStr.setString(3, dto.aioTime);
			pStr.setString(4, dto.aioDiv);
			pStr.setInt(5, dto.aioInput);
			pStr.setInt(6, dto.aioOutput);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<AccListDto> findByDateDestance(String sDate, String eDate) {
		return null;
	}

	@Override
	public List<AccListDto> findByAcNum(String acNUm) {
		return null;
	}

	@Override
	public List<AccListDto> findByAcNumAndDateDest(String acNUm, String sDate, String eDate) {
		return null;
	}

	@Override
	public int update(AccListDto dto) {
		return 0;
	}

	@Override
	public int delete(String acNUm) {
		return 0;
	}

}
