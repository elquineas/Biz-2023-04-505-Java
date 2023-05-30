package com.callor.shop.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.service.BuyerService;
import com.callor.shop.utils.Line;

public class BuyerServiceImpl implements BuyerService {
	private static SqlSession sqlSession;
	private static BuyerDao buyerDao;
	private static Scanner scan;
	
	public BuyerServiceImpl() {
		sqlSession = DBConnection.getFactory().openSession(true);
		buyerDao = sqlSession.getMapper(BuyerDao.class);
		scan = new Scanner(System.in);
	}

	@Override
	public List<BuyerDto> selectAll() {
		List<BuyerDto> buList = buyerDao.selectAll();
		if(buList.size() < 1) {
			System.err.println("데이터가 없습니다.");
			return null;
		}
		System.out.println(Line.dLine(100));
		System.out.println("고객ID\t\t고객이름\t전화번호\t주소");
		System.out.println(Line.sLine(100));
		for(BuyerDto dto : buList) {
			System.out.printf("%s\t",dto.buId);
			System.out.printf("%s\t\t",dto.buName);
			System.out.printf("%s\t",dto.buTel);
			System.out.printf("%s\n",dto.buAddr);
		}
		System.out.println(Line.dLine(100));
		return buList;
	}

	@Override
	public BuyerDto select(String id) {
		BuyerDto dto = buyerDao.select(id);
		return dto;
	}
	
	public String maxId() {
		String strMaxId = buyerDao.maxId();
		int maxId = 0;
		if(strMaxId == null){
			maxId = 0;
		}else {
			maxId = Integer.valueOf(strMaxId) + 1;
		}
		strMaxId = String.format("%010d", maxId);
		return strMaxId;
	}
	
	@Override
	public void insert() {
		String strMaxId = maxId();
		
		System.out.printf("고객ID (%s)\n",strMaxId);
		String buName = "";
		while(true) {
			System.out.print("고객이름 >> ");
			buName = scan.nextLine();
			if(buName.equals("")) {
				System.err.println("고객이름은 빈칸으로 입력하실 수 없습니다.");
			}else {
				break;
			}
		}
		System.out.print("전화번호 >> ");
		String buTel = scan.nextLine();
		System.out.print("고객주소 >> ");
		String buAddr = scan.nextLine();
		
		BuyerDto bDto = new BuyerDto();
		bDto.buId   = strMaxId;
		bDto.buName = buName;
		bDto.buTel  = buTel;
		bDto.buAddr = buAddr;
		
		int result = buyerDao.insert(bDto);
		if(result < 1) {
			System.err.println("데이터 입력에 실패하셨습니다.");
		}else {
			System.out.println("데이터를 입력했습니다.");
		}
	}

}
