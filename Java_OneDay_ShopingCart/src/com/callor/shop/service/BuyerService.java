package com.callor.shop.service;

import java.util.List;

import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.ProductDto;


public interface BuyerService {
	public List<BuyerDto> selectAll();
	public BuyerDto select(String id);
	public void insert();
}
