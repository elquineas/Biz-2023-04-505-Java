package com.elquineas.memo.service;

import java.util.Scanner;

import com.elquineas.memo.config.MemoInfo;
import com.elquineas.memo.service.impl.MemoServiceImpl;
import com.elquineas.memo.utils.AnsiConsol;

public class MainService {
	private static MemoService mService;
	private static Scanner scan;
	
	public MainService() {
		mService = new MemoServiceImpl();
		scan = new Scanner(System.in);
	}
	
	public void startMemo() {
		while(true) {
			MemoInfo.headerPrint();
			System.out.print(">> ");
			String str = scan.nextLine();
			if(str.equals("1")) {
				mService.selectAll();
			}else if(str.equals("2")) {
				mService.insert();
			}else if(str.equals("3")) {
				mService.update();
			}else if(str.equals("4")) {
				mService.delete();
			}else if(str.equals("5")) {
				mService.serch();
			}else if(str.equals("9")) {
				System.out.println(AnsiConsol.BLUE("종료합니다."));
				return;
			}else {
				System.out.println(AnsiConsol.RED("선택지 번호만 입력해주세요."));
				continue;
			}
		}
	}
	
}
