package com.callor.shop.service;

import java.util.Scanner;

import com.callor.shop.config.CartInfo;
import com.callor.shop.service.impl.BuyerServiceImpl;
import com.callor.shop.service.impl.IoListServiceImpl;
import com.callor.shop.service.impl.ProductServiceImpl;

public class ShopingCartService {
	private ProductService pService;
	private BuyerService bService;
	private IoListService ioService;
	private Scanner scan;
	
	public ShopingCartService() {
		scan = new Scanner(System.in);
		pService = new ProductServiceImpl();
		bService = new BuyerServiceImpl();
		ioService = new IoListServiceImpl();
	}
	
	public void shopingCart(){
		while(true) {
			CartInfo.headerPrint();
			System.out.print("선택 >> ");
			String select = scan.nextLine();
			if(select.equals("QUIT")) {
				System.out.println("종료합니다.");
				return;
			}
			int intSelect = 0;
			try {
				intSelect = Integer.valueOf(select);
			} catch (Exception e) {
				System.err.printf("업무 선택은 QUIT(끝내기), 1 ~ 7 정수만 입력할 수 있습니다( %s )\n",select);
				continue;
			}
			if(intSelect < 1 || intSelect > 7) {
				System.err.println("업무 선택은 1 ~ 7 까지 중에서 선택하세요");
				continue;
			}else if(intSelect == 1) {
				pService.productList();
			}else if(intSelect == 2) {
				pService.itemUpdate();
			}else if(intSelect == 3) {
				bService.selectAll();
			}else if(intSelect == 4) {
				bService.insert();
			}else if(intSelect == 5) {
				ioService.setIoList();
			}else if(intSelect == 6) {
				ioService.IoIdList();
			}else if(intSelect == 7) {
				ioService.IoSearchList();
			}
		}
	}
	
	
	
	
}
