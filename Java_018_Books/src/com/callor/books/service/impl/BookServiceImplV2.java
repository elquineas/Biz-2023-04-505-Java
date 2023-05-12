package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV2 implements BookService {
	public List<BookDto> bList;
	
	public BookServiceImplV2() {
		bList = new ArrayList<>();
	}
	
	@Override
	public void loadBooks() {
		String bookFile = "src/com/callor/books/data/도서정보(2023-05-11)2.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(bookFile + " 해당 파일이 없습니다.");
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			BookDto bDto = new BookDto();
			String line = scan.nextLine();
			String[] book = line.split(",");
			bDto.setbIsbn(book[DataIndex.BOOK.ISBN]);
			bDto.setbTitle(book[DataIndex.BOOK.TITLE]);
			bDto.setbPublisher(book[DataIndex.BOOK.PUBLISHER]);
			bDto.setbAuthor(book[DataIndex.BOOK.AUTHOR]);
			bDto.setbPublishDate(book[DataIndex.BOOK.PDATE]);
			bDto.setbPages(Integer.valueOf(book[DataIndex.BOOK.PAGES]));
			String strPrice = book[DataIndex.BOOK.PRICE].trim();
			bDto.setbPrice(Integer.valueOf(strPrice));
			bList.add(bDto);
		}
		scan.close();
	}

	@Override
	public void printBookList() {
		String printTitle = "﻿ISBN,도서명,출판사,저자,발행일,페이지,가격";
		System.out.println("=".repeat(100));
		System.out.printf("%-13s\t","ISBN");
		System.out.printf("%-20s\t\t","도서명");
		System.out.printf("출판사\t");
		System.out.printf("저자\t");
		System.out.printf("발행일\t\t");
		System.out.printf("페이지\t");
		System.out.printf("가격\n");
		System.out.println("-".repeat(100));
		
		for(BookDto dto : bList) {
			System.out.printf("%-13s\t",dto.getbIsbn());
			if(dto.getbTitle().length() > 10){
				System.out.printf("%-20s\t",dto.getbTitle().substring(0, 10));
			}else {
				System.out.printf("%-20s\t",dto.getbTitle());
			}
			System.out.printf("%s\t",dto.getbPublisher());
			System.out.printf("%s\t",dto.getbAuthor());
			System.out.printf("%s\t",dto.getbPublishDate());
			System.out.printf("%d\t",dto.getbPages());
			System.out.printf("%d\t\n",dto.getbPrice());
//			System.out.println("-".repeat(100));
		}
	}

	@Override
	public BookDto getBook(String isbn) {
		return null;
	}

	@Override
	public List<BookDto> selectAll() {
		return null;
	}

	@Override
	public void updateBook(BookDto bookDto) {
		
	}

	@Override
	public void deleteBook(String isbn) {
		
	}

}
