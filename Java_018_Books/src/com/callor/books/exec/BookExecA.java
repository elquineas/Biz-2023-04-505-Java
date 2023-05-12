package com.callor.books.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BookExecA {
	// ﻿ISBN	도서명	출판사	저자	발행일	페이지	가격
	// 0    1       2       3       4       5       6
	// 도서정보 파일을 열어서 읽어들인 후 데이터 출력해보기
	
	public static void main(String[] args) {
		String bookFile 	= "src/com/callor/books/data/도서정보(2023-05-11).txt";
		String saveFile 	= "src/com/callor/books/data/도서정보(2023-05-11)_save.txt";
		Scanner fileScan = null;
		InputStream is = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(bookFile + " 해당 파일이 없습니다.");
			return;
		}
		
		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			String[] book = fileScan.nextLine().split(",");
			for(int i = 0; i< book.length; i++) {
				System.out.print(book[i] + "\t");
			}
			System.out.println();
		}
		
	}
}
