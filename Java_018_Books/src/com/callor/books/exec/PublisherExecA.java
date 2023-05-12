package com.callor.books.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.models.PublisherDto;
import com.callor.books.service.PublisherService;
import com.callor.books.service.impl.PublisherServiceImplV1;

public class PublisherExecA {
	public static void main(String[] args) {
		PublisherService pService = new PublisherServiceImplV1();
		PublisherDto pDto = new PublisherDto();
		List<PublisherDto> pList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		pService.loadPubliser();
		pService.printPubliser();
		
		String code = "C0001";
		pDto = pService.getPubliser(code);		
		pList = pService.getPubliserList();
		String name = "ook";
		pList = pService.getPubliserListByName(name);

	}
}
