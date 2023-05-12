package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV1 implements BookService {
	public List<BookDto> bList;
	
	
	public BookServiceImplV1() {
		bList = new ArrayList<>();
	}
	
	@Override
	public void loadBooks() {
		String bookFile = "src/com/callor/books/data/도서정보(2023-05-11)2.txt";
		Scanner scan = null;
		InputStream is = null;
		
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
			bDto.setbIsbn(book[0]);
			bDto.setbTitle(book[1]);
			bDto.setbPublisher(book[2]);
			bDto.setbAuthor(book[3]);
			bDto.setbPublishDate(book[4]);
			bDto.setbPages(Integer.valueOf(book[5]));
			bDto.setbPrice(Integer.valueOf(book[6].trim()));
			bList.add(bDto);
		}
		scan.close();
	}

	@Override
	public void printBookList() {
		System.out.println("=".repeat(100));
		System.out.println("﻿ISBN\t도서명\t출판사\t저자\t발행일\t페이지\t가격");
		System.out.println("-".repeat(100));
		
		for(BookDto dto : bList) {
			System.out.printf("%s\t",dto.getbIsbn());
			System.out.printf("%s\t",dto.getbTitle());
			System.out.printf("%s\t",dto.getbPublisher());
			System.out.printf("%s\t",dto.getbAuthor());
			System.out.printf("%s\t",dto.getbPublishDate());
			System.out.printf("%d\t",dto.getbPages());
			System.out.printf("%d\t\n",dto.getbPrice());
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
