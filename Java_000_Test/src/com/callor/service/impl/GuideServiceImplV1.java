package com.callor.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.models.GuideDto;
import com.callor.service.GuideService;

public class GuideServiceImplV1 implements GuideService{
	List<GuideDto> gList;
	
	public GuideServiceImplV1() {
		gList = new ArrayList<>();
	}
	
	@Override
	public void loadGuide() {
		String guideFile = "src/com/callor/data/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(guideFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(guideFile+" 해당 파일이 없습니다.");
			return;
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] guide = line.split(",");
			GuideDto gDto = new GuideDto();
			gDto.guId    = guide[0];
			gDto.guList  = guide[1];
			gDto.guSeq 	 = guide[2];
			gDto.guGuide = guide[3];
			gList.add(gDto);
		}
		scan.close();
		
	}

	@Override
	public void printGuideList() {
		System.out.println("=".repeat(100));
		System.out.printf("%s\t","﻿ID");
		System.out.printf("%-20s\t\t","﻿종목명");
		System.out.printf("%s\t","﻿순서");
		System.out.printf("%s\n","﻿방법");
		String id = "";
		for(GuideDto dto : gList) {
//			System.out.println(dto.guId +" : "+id);
			if(!dto.guId.equals(id)) {
				System.out.println("-".repeat(100));
			}
			System.out.printf("%s\t",dto.guId);
			System.out.printf("%-20s\t",dto.guList);
			System.out.printf("%s회\t",dto.guSeq);
			System.out.printf("%s\n",dto.guGuide);
			id = dto.guId;
		}
		System.out.println("=".repeat(100));
	}

}
