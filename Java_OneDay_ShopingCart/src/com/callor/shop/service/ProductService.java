package com.callor.shop.service;

import java.util.List;

import com.callor.shop.models.ProductDto;


public interface ProductService {
	public List<ProductDto> productList();
	public ProductDto codeSelect(String code);
	public void itemUpdate();
	public int insert(String pCode);
	public int update(ProductDto dto);
}
