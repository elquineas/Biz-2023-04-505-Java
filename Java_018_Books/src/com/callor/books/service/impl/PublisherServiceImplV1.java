package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.AuthorDto;
import com.callor.books.models.PublisherDto;
import com.callor.books.service.PublisherService;

public class PublisherServiceImplV1 implements PublisherService{
	List<PublisherDto> pList; 
	List<PublisherDto> sList;
	
	public PublisherServiceImplV1() {
		pList = new ArrayList<>();
		sList = new ArrayList<>();
	}
	
	@Override
	public void loadPubliser() {
		String pubFile = "src/com/callor/books/data/출판사정보(2023-05-11).txt";
		Scanner scan = null;
		InputStream is = null;
		
		try {
			is = new FileInputStream(pubFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(pubFile+" 해당 파일이 없습니다.");
			return;
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] publisher = line.split(",");
			PublisherDto pDto = new PublisherDto();
			pDto.setPubCode(publisher[DataIndex.PUBLISHER.PCODE]);
			pDto.setPubName(publisher[DataIndex.PUBLISHER.PNAME]);
			pDto.setPubCeo(publisher[DataIndex.PUBLISHER.PCEO]);
			pDto.setPubTel(publisher[DataIndex.PUBLISHER.PTEL]);
			pDto.setPubAddress(publisher[DataIndex.PUBLISHER.PADDRESS]);
			pList.add(pDto);			
		}
		scan.close();
	}

	@Override
	public void printPubliser() {
		System.out.println(Utils.dLine(100));
		System.out.printf("%-10s\t","﻿출판사코드");
		System.out.printf("%-20s\t","﻿출판사명");
		System.out.printf("%-10s\t","﻿대표");
		System.out.printf("%-10s\t","﻿전화번호");
		System.out.printf("%s\n","﻿주소");
		System.out.println(Utils.sLine(100));
		
		for(PublisherDto dto : pList) {
			System.out.printf("%-10s\t",dto.getPubCode());
			if(dto.getPubName().length() > 15) {
				System.out.printf("%-20s\t",dto.getPubName().substring(0,15));
			}else {
				System.out.printf("%-20s\t",dto.getPubName());
			}
			System.out.printf("%-10s\t",dto.getPubCeo());
			System.out.printf("%-10s\t",dto.getPubTel());
			System.out.printf("%s\n",dto.getPubAddress());
		}
		System.out.println(Utils.dLine(100));
	}

	@Override
	public PublisherDto getPubliser(String code) {
		loadPubliser();
		for(PublisherDto dto : pList) {
			if(dto.getPubCode().equals(code)) {
				sList.add(dto);
				
				System.out.println("Publisger Code Serch");
				printSerchList(sList);
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<PublisherDto> getPubliserList() {
		loadPubliser();

		System.out.println("Publisger List");
		printSerchList(pList);
		return pList;
	}

	@Override
	public List<PublisherDto> getPubliserListByName(String name) {
		loadPubliser();
		List<PublisherDto> serchList = new ArrayList<>();
		for(PublisherDto dto : pList) {
			if(dto.getPubName().contains(name)) {
				serchList.add(dto);
			}
		}

		System.out.println("Publisger Name Serch");
		printSerchList(serchList);
		return serchList;
	}

	
	public void printSerchList(List<PublisherDto> sList) {
		System.out.println(Utils.dLine(100));
		System.out.printf("%-10s\t","﻿출판사코드");
		System.out.printf("%-20s\t","﻿출판사명");
		System.out.printf("%-10s\t","﻿대표");
		System.out.printf("%-10s\t","﻿전화번호");
		System.out.printf("%s\n","﻿주소");
		System.out.println(Utils.sLine(100));
		
		for(PublisherDto dto : sList) {
			System.out.printf("%-10s\t",dto.getPubCode());
			if(dto.getPubName().length() > 15) {
				System.out.printf("%-20s\t",dto.getPubName().substring(0,15));
			}else {
				System.out.printf("%-20s\t",dto.getPubName());
			}
			System.out.printf("%-10s\t",dto.getPubCeo());
			System.out.printf("%-10s\t",dto.getPubTel());
			System.out.printf("%s\n",dto.getPubAddress());
		}
		System.out.println(Utils.dLine(100));
	}
	
	
	
}
