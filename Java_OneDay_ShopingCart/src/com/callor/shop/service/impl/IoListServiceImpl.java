package com.callor.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.IoListDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.IoListDto;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.BuyerService;
import com.callor.shop.service.IoListService;
import com.callor.shop.service.ProductService;
import com.callor.shop.utils.Line;

public class IoListServiceImpl implements IoListService {
	private static ProductService pService;
	private static BuyerService bService;
	private static SqlSession sqlSession;
	private static IoListDao ioListDao;
	private static Scanner scan;
	
	public IoListServiceImpl() {
		pService = new ProductServiceImpl();
		bService = new BuyerServiceImpl();
		sqlSession = DBConnection.getFactory().openSession(true);
		ioListDao = sqlSession.getMapper(IoListDao.class);
		scan = new Scanner(System.in);
	}


	@Override
	public void setIoList() {
		bService.selectAll();
		System.out.print("고객ID >> ");
		String strBuId = scan.nextLine();
		List<ProductDto> pList = pService.productList();

		int price = 0;
		String strPCode = "";
		ProductDto pDto = null;
		while(true) {
			System.out.print("상품코드 >> ");
			strPCode = scan.nextLine();
			pDto = pService.codeSelect(strPCode);
			if(pDto == null) {
				System.err.println("없는 상품코드 입니다.");
			}else {
				price = pDto.pOPrice;
				break;
			}
		}
		
		String strQuan = "";
		int intQuan = 0;
		while(true) {
			System.out.print("수량 >> ");
			strQuan = scan.nextLine();
			try {
				intQuan = Integer.valueOf(strQuan);
				break;
			} catch (Exception e) {
				System.out.println("0이상 정수만 입력해주세요");
			}
		}
		while(true) {
			System.out.printf("판매단가(%d) >> ",price);
			String strPrice = scan.nextLine();
			if(strPrice.equals("")) {
				break;
			}
			try {
				price = Integer.valueOf(strPrice);
				break;
			} catch (Exception e) {
				System.out.println("정수만 입력해주세요");
			}
		}
		
		IoListDto ioDto = new IoListDto();  
		ioDto.ioBuid  = strBuId;
		ioDto.ioPCode = strPCode;
		ioDto.ioQuan  = intQuan;
		ioDto.ioDate  = getTodayDate();
		ioDto.ioTime  = getTodayTime();
		ioDto.ioPrice = price * intQuan;
		
		int result = ioListDao.insert(ioDto);
		if(result < 1) {
			System.err.println("데이터 입력에 실패하셨습니다.");
		}else {
			System.out.println("데이터를 입력했습니다.");
		}	
	}
	
	@Override
	public void IoIdList() {
		List<BuyerDto> bList = bService.selectAll();
		System.out.print("고객ID >> ");
		String strBuId = scan.nextLine();

		List<IoListDto> ioList = ioListDao.ioIdList(strBuId);
		System.out.println(ioList.isEmpty());
		if(ioList.isEmpty()) {
			System.err.println("장바구니가 비어있습니다.");
			return;
		}
		System.out.println(Line.dLine(100));
		System.out.println("상품판매 리스트");
		listPrint(ioList);
		
	}
	
	@Override
	public void IoSearchList() {
		List<IoListDto> ioList = new ArrayList<>();
		System.out.println(Line.dLine(100));
		System.out.println("전체거래 리스트");
		System.out.println(Line.dLine(100));
		System.out.println("1. 전체 거래리스트");
		System.out.println("2. 기간별 거래리스트");
		System.out.println("3. 고객별 거래리스트");
		System.out.println("4. 상품별 거래리스트");
		System.out.println("5. 고객+기간별 리스트");
		System.out.print("선택 >> ");
		String strSelect = scan.nextLine();
		int intSelect = 0;
		try {
			intSelect = Integer.valueOf(strSelect);
		} catch (Exception e) {
			
		}
		
		
		if(intSelect == 1) {
			ioList = ioListDao.ioList();
		}else if(intSelect == 2) {
			System.out.print("시작 날짜 >> ");
			String strdate1 = scan.nextLine();
			System.out.print("끝 날짜 >> ");
			String strdate2 = scan.nextLine();
			ioList = ioListDao.ioDateList(strdate1, strdate2);
		}else if(intSelect == 3) {
			System.out.print("고객ID >> ");
			String strbuId = scan.nextLine();
			ioList = ioListDao.ioIdList(strbuId);
		}else if(intSelect == 4) {
			System.out.print("상품명 >> ");
			String strpName = scan.nextLine();
			ioList = ioListDao.ioCodeList(strpName);
		}else if(intSelect == 5) {
			System.out.print("고객ID >> ");
			String strbuId = scan.nextLine();
			System.out.print("시작 날짜 >> ");
			String strdate1 = scan.nextLine();
			System.out.print("끝 날짜 >> ");
			String strdate2 = scan.nextLine();
			ioList = ioListDao.ioIdDateList(strbuId,strdate1,strdate2);
		}
			
			
		listPrint(ioList);
		
	}
	
	
	protected void listPrint(List<IoListDto> ioList) {
		System.out.println(Line.dLine(100));
		System.out.println("거래일자\t거래시각\t고객ID\t고객이름\t전화번호\t상품코드\t상품명\t판매단가\t수량\t판매합계");
		System.out.println(Line.sLine(100));
		for(IoListDto dto : ioList) {
			BuyerDto buDto = bService.select(dto.ioBuid);
			ProductDto pDto = pService.codeSelect(dto.ioPCode);
			System.out.printf("%s\t",dto.ioDate);
			System.out.printf("%s\t",dto.ioTime);
			System.out.printf("%s\t",dto.ioBuid);
			System.out.printf("%s\t",buDto.buName);
			System.out.printf("%s\t",buDto.buTel);
			System.out.printf("%s\t",dto.ioPCode);
			System.out.printf("%s\t",pDto.pName);
			System.out.printf("%s\t",pDto.pOPrice);
			System.out.printf("%s\t",dto.ioQuan);
			System.out.printf("%s\n",dto.ioPrice);
		}
		System.out.println(Line.dLine(100));
	}

	
	protected String getTodayDate() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		return todayString;
	}
	protected String getTodayTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat  = new SimpleDateFormat("HH:mm:ss");
		String timeString  = timeFormat.format(date);
		return timeString;
	}
	
}
