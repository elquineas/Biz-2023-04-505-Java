package com.elquineas.bank.service;

import java.util.List;

import com.elquineas.bank.models.AccDto;
import com.elquineas.bank.models.AccListDto;

public interface AccListService {
	
	public List<AccListDto> selectAll();
	public AccListDto findById(long seq);
	
	public int insert(AccListDto dto);
	
	public List<AccListDto> findByDateDestance(String sDate, String eDate);
	
	public List<AccListDto> findByAcNum(String acNUm);
	
	public List<AccListDto> findByAcNumAndDateDest(String acNUm, String sDate, String eDate);
	
	// 은행거래의 특성상 데이터 수정과 삭제를 금지한다
	public int update(AccListDto dto);
	public int delete(String acNUm);
	
}
