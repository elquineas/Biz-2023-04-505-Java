package com.callor.exam.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.exam.models.GuideDto;
import com.callor.exam.service.GuideService;

public class GuideServiceImplV1 implements GuideService{
	protected final List<GuideDto> gList;
	
	public GuideServiceImplV1() {
		this.gList = new ArrayList<>();
	}
	
	@Override
	public void loadGuide() {
		String guideFile = "src/com/callor/data/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(guideFile);
		} catch (Exception e) {
		}
		
		int rows = 0;
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] guide = line.split(",");
			
			GuideDto guDto = new GuideDto();
			try {
				guDto.id = guide[0];
				guDto.item = guide[1];
				guDto.seq = Integer.valueOf(guide[2]);
				guDto.guide = guide[3];
				gList.add(guDto);
			} catch (Exception e) {
				System.out.println(rows+" 번째 에서 Exceoption 발생");
			}
		}
		scan.close();
		System.out.println("로딩된 데이터 갯수 : "+ gList.size());
	}

	@Override
	public void printGuideList() {
		System.out.println("=".repeat(150));
		System.out.println("ID\t종목명\t순서\t가이드");
		String id = "";
		for(GuideDto dto : gList) {
//			System.out.println(dto.guId +" : "+id);
			if(!dto.id.equals(id)) {
				System.out.println("-".repeat(100));
			}
			System.out.printf("%s\t",dto.id);
			System.out.printf("%-20s\t",dto.item);
			System.out.printf("%s회\t",dto.seq);
			System.out.printf("%s\n",dto.guide);
			id = dto.id;
		}
		System.out.println("=".repeat(100));
		
	}

}
