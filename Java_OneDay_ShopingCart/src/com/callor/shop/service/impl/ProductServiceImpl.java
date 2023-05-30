package com.callor.shop.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.ProductService;
import com.callor.shop.utils.Line;

public class ProductServiceImpl implements ProductService {
	private static SqlSession sqlSession;
	private static ProductDao productDao;
	private static Scanner scan;
	
	
	public ProductServiceImpl() {
		sqlSession = DBConnection.getFactory().openSession(true);
		productDao = sqlSession.getMapper(ProductDao.class);
		scan = new Scanner(System.in);
	}
	
	@Override
	public List<ProductDto> productList() {
		List<ProductDto> productList = productDao.productList();
		if(productList.size() < 1) {
			System.err.println("데이터가 없습니다.");
			return null;
		}
		System.out.println(Line.dLine(100));
		System.out.println("상품코드\t상품명\t품목\t매입단가\t매출단가");
		System.out.println(Line.sLine(100));
		for(ProductDto dto : productList) {
			System.out.printf("%s\t",dto.pCode);
			System.out.printf("%s\t",dto.pName);
			System.out.printf("%s\t",dto.pItem);
			System.out.printf("%s\t\t",dto.pIPrice);
			System.out.printf("%s\n",dto.pOPrice);
		}
		System.out.println(Line.dLine(100));
		return productList;
	}
	
	public ProductDto codeSelect(String pCode) {
		ProductDto pDto = productDao.codeSelect(pCode);
		return pDto;
	}
	
	public void itemUpdate() {
		System.out.println(Line.dLine(100));
		System.out.println("상품등록");
		System.out.println(Line.sLine(100));
		String pCode = "";
		while(true) {
			System.out.print("상품코드 >> ");
			pCode = scan.nextLine();
			if(pCode.length() != 13) System.out.println("13자리 상품코드를 입력해주세요");
			else break;
		}
		ProductDto pDto = productDao.codeSelect(pCode);
		int result = 0;
		if(pDto == null){
			result = insert(pCode);
		}else {
			result = update(pDto);
		}
		
		if(result < 1) {
			System.err.println("데이터 입력에 실패하셨습니다.");
		}else {
			System.out.println("데이터를 입력했습니다.");
		}
		
	}
	
	@Override
	public int insert(String pCode) {
		System.out.print("상품명 >> ");
		String pName = scan.nextLine();
		System.out.print("품목(식품, 야채, 과자) >> ");
		String pItem = scan.nextLine();
		int intPrice = 0;
		while(true){
			System.out.print("매입단가 >> ");
			String pIPrice = scan.nextLine();
			try {
				intPrice = Integer.valueOf(pIPrice);
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
		ProductDto dto = new ProductDto();
		dto.pCode 	= pCode;
		dto.pName 	= pName;
		dto.pItem	= pItem;
		dto.pIPrice = intPrice;
		dto.pOPrice = intPrice + (int)(intPrice * 0.22);
		int result = productDao.insert(dto);
		return result;
	}

	@Override
	public int update(ProductDto dto) {
		System.out.printf("상품명(%s) >> ",dto.pName);
		String pName = scan.nextLine();
		if(pName.equals("")) {dto.pName = dto.pName;}
		else dto.pName = pName;
		
		System.out.printf("품목(%s)(식품, 야채, 과자) >> ",dto.pItem);
		String pItem = scan.nextLine();
		if(pItem.equals("")) {dto.pItem = dto.pItem;}
		else dto.pItem = pItem;
		
		int intPrice = 0;
		while(true){
			System.out.printf("매입단가(%d) >> ",dto.pIPrice);
			String pIPrice = scan.nextLine();
			try {
				intPrice = Integer.valueOf(pIPrice);
				if(pIPrice.equals("")) {dto.pIPrice = dto.pIPrice;}
				else dto.pIPrice = intPrice;
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
		dto.pOPrice = intPrice + (int)(intPrice * 0.22);
		int result = productDao.update(dto);
		return result;
	}



}
