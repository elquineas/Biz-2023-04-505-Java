package com.callor.books.exec;

import java.util.List;
import java.util.Scanner;

import com.callor.books.models.AuthorDto;
import com.callor.books.service.AuthorService;
import com.callor.books.service.BookService;
import com.callor.books.service.impl.AuthorServiceImplV1;
import com.callor.books.service.impl.BookServiceImplV1;

public class AuthorExecA {
	public static void main(String[] args) {
		AuthorService aService = new AuthorServiceImplV1();
		Scanner scan = new Scanner(System.in);
		
		aService.loadAuthor();
		
		aService.printAuthorList();

		System.out.print(">>> ");
		String author = scan.nextLine();
		AuthorDto aDto = aService.getAuthor(author);
		List<AuthorDto> aList = aService.getAuthorList();
		
		System.out.println(aDto.toString());
		System.out.println(aList.toString());
	}
}
