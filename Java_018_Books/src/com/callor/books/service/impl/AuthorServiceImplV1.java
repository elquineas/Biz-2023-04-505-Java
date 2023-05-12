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
import com.callor.books.models.BookDto;
import com.callor.books.service.AuthorService;

public class AuthorServiceImplV1 implements AuthorService {
	private List<AuthorDto> aList;
	
	public AuthorServiceImplV1() {
		aList = new ArrayList<>();
	}
	
	@Override
	public void loadAuthor() {
		String authFile = "src/com/callor/books/data/저자정보(2023-05-11).txt";
		Scanner scan = null;
		InputStream is = null;
		
		try {
			is = new FileInputStream(authFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(authFile + " 파일이 없습니다.");
			return;
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line   = scan.nextLine();
			String[] author = line.split(",");
			AuthorDto aDto = new AuthorDto();
			aDto.setAuCode(author[DataIndex.AUTHOR.AUCODE]);
			aDto.setAuName(author[DataIndex.AUTHOR.AUNAME]);
			aDto.setAuTel(author[DataIndex.AUTHOR.AUTEL]);
			aDto.setAuAddress(author[DataIndex.AUTHOR.AUADDRESS]);
			aList.add(aDto);
		}
		
		
	}

	@Override
	public void printAuthorList() {
		System.out.println(Utils.dLine(100));
		System.out.printf("%-10s\t","﻿저자코드");
		System.out.printf("%-10s\t","﻿저자명");
		System.out.printf("%-10s\t","﻿전화번호");
		System.out.printf("%s\n","﻿주소");
		System.out.println(Utils.sLine(100));
		
		for(AuthorDto dto : aList) {
			System.out.printf("%-10s\t",dto.getAuCode());
			if(dto.getAuName().length() > 3) {
				System.out.printf("%-10s\t",dto.getAuName().substring(0,3));
			}else {
				System.out.printf("%-10s\t",dto.getAuName());
			}
			System.out.printf("%-10s\t",dto.getAuTel());
			System.out.printf("%s\n",dto.getAuAddress());
		}
	}

	@Override
	public AuthorDto getAuthor(String author) {
		for(AuthorDto dto : aList) {
			if(dto.getAuCode().equals(author)) {
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<AuthorDto> getAuthorList() {
		loadAuthor();
		return aList;
	}

}
