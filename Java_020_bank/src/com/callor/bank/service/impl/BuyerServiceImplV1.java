package com.callor.bank.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Config;
import com.callor.bank.utils.Index;
import com.callor.bank.utils.Line;

public class BuyerServiceImplV1 implements BuyerService {
	protected Scanner scan;
	protected List<BuyerDto> buList;
	
	public BuyerServiceImplV1() {
		scan = new Scanner(System.in);
		buList = new ArrayList<>();
	}
	
	
	@Override
	public void loadBuyer() {
		buList = new ArrayList<>();
		InputStream is = null;
		
		try {
			is = new FileInputStream(Config.BUYER_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(Config.BUYER_FILE + " 해당 파일이 없습니다.");
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line   = scan.nextLine();
			String[] data = line.split("\t");
			
			BuyerDto buDto = new BuyerDto();
			buDto.buId    = data[Index.BUYER.BU_ID];
			buDto.buName  = data[Index.BUYER.BU_NAME];
			buDto.buTel   = data[Index.BUYER.BU_TEL];
			buDto.buAddr  = data[Index.BUYER.BU_ADDR];
			buDto.buBirth = data[Index.BUYER.BU_BIRTH];
			buDto.buJob   = data[Index.BUYER.BU_JOB];
			buList.add(buDto);
		}	
		printBuyerList();	
	}

	@Override
	public BuyerDto getBuyer(String buId) {
		return null;
	}

	protected int getMaxId() {
		int maxId = 0;
		for(BuyerDto dto : buList) {
			int intId = Integer.valueOf(dto.buId);
			if(intId > maxId) maxId = intId;
		}
		return maxId+1;
	}
	
	protected BuyerDto buyerItemInput() {
		BuyerDto buDto = new BuyerDto();
		String buId = "";
//		int index = 0;
		boolean newData = true;
		while(true) {
			System.out.print("ID >>> ");
			buId = scan.nextLine();
			if(buId.equals("QUIT")) {
				return null;
			}else if(buId.equals("")) {
				if(buList.size() < 1) {
					buId = "0001";
				}else {
//					buId = String.format("%04d", Integer.valueOf(buList.get(buList.size()-1).buId)+1);
					buId = String.format("%04d", getMaxId());
				}
//				buId = String.format("%04d", 1);
			}
			try {
				int num = Integer.valueOf(buId);
				buId = String.format("%04d", num);
				for(BuyerDto dto : buList) {
					if(dto.buId.equals(buId)) {
						buDto = dto;
						newData = false;
						break;
					}
//					index++;
				}
				break;
			} catch (Exception e) {
				System.err.println("정수만 입력해주세요.");
			}
		}
		
//		System.out.printf("이름(%s)\n", (index >= buList.size() ? "신규":buDto.buName));
		System.out.printf("이름(%s)\n", (newData ? "신규":buDto.buName));
		System.out.print(">>>  ");
		String buName = scan.nextLine();
		if(buName.equals("QUIT")) {
			return null;
		}else if(buName.equals("")) {
			buName = buDto.buName;
		}

		System.out.printf("전화번호(%s)\n", (newData ? "신규":buDto.buTel));
		System.out.print(">>>  ");
		String buTel = scan.nextLine();
		if(buTel.equals("QUIT")) {
			return null;
		}else if(buTel.equals("")) {
			buTel = buDto.buTel;
		}

		System.out.printf("주소(%s)\n", (newData ? "신규":buDto.buAddr));
		System.out.print(">>>  ");
		String buAddr = scan.nextLine();
		if(buAddr.equals("QUIT")) {
			return null;
		}else if(buAddr.equals("")) {
			buAddr = buDto.buAddr;
		}
		
		System.out.printf("생년월일(%s)\n", (newData ? "신규":buDto.buBirth));
		System.out.print(">>>  ");
		String buBirth = scan.nextLine();
		if(buBirth.equals("QUIT")) {
			return null;
		}else if(buBirth.equals("")) {
			buBirth = buDto.buBirth;
		}

		System.out.printf("직업(%s)\n", (newData ? "신규":buDto.buJob));
		System.out.print(">>>  ");
		String buJob = scan.nextLine();
		if(buJob.equals("QUIT")) {
			return null;
		}else if(buJob.equals("")) {
			buJob = buDto.buJob;
		}
		
		buDto.buId    = buId;
		buDto.buName  = buName;
		buDto.buTel   = buTel;
		buDto.buAddr  = buAddr;
		buDto.buBirth = buBirth;
		buDto.buJob   = buJob;
		return buDto;
	}
	
	@Override
	public void InputBuyer() {		
		while(true) {
			System.out.println(Line.dLine(100));
			System.out.println("고객정보 관리(QUIT : 종료)");
			System.out.println(Line.sLine(100));
			
			BuyerDto buDto = buyerItemInput();
			if(buDto == null) break;
			if( !(buList.contains(buDto)) ) {
				buList.add(buDto);
			}
//			System.out.println(buList.toString());
		}
		System.out.println("고객정보 관리 종료");
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(Config.BUYER_FILE);
			out = new PrintWriter(os);
			printBuyerList(out);
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void printBuyerList() {
		OutputStream os = System.out;
		PrintWriter out = new PrintWriter(os);

		System.out.println(Line.dLine(100));
		System.out.println("고객정보 리스트");
		System.out.println(Line.sLine(100));
		System.out.println("고객ID\t고객명\t전화번호\t주소\t생년월일\t직업");
		printBuyerList(out);
		out.close();
		System.out.println(Line.dLine(100));
	}


	@Override
	public void printBuyerList(PrintWriter out) {
		for(BuyerDto dto : buList) {
			out.printf("%s\t",dto.buId);
			out.printf("%s\t",dto.buName);
			out.printf("%s\t",dto.buTel);
			out.printf("%s\t",dto.buAddr);
			out.printf("%s\t",dto.buBirth);
			out.printf("%s\n",dto.buJob);
		}
	}

}
