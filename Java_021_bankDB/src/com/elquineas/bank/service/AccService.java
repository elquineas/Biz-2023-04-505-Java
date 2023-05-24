package com.elquineas.bank.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.elquineas.bank.models.AccDto;

public interface AccService {
	
	public List<AccDto> selectAll();
	// PK 칼럼이 아닌 칼럼으로 조회시 결과는 0 이상
	// 결과가 1개라는 확신이 있더라도 List로 취급해야한다.
//	public AccDto findById(String acbuid);
	public List<AccDto> db2List(PreparedStatement pStr) throws SQLException;
	public List<AccDto> findById(String acbuid);
	
	public int insert(AccDto dto);
	public int update(AccDto dto);
	public int delete(String acbuid);
	
}
