package com.elquineas.bank.service;

import java.util.List;

import com.elquineas.bank.exec.BuyerDto;

public interface BuyerService {

	public List<BuyerDto> selectAll();
	public BuyerDto findById(String id);
	
	public int insert(BuyerDto bDto);
	public int update(BuyerDto bDto);
	public int delete(String id);
	
	
}
