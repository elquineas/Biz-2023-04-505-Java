package com.callor.exam;

import com.callor.exam.service.GuideService;
import com.callor.exam.service.impl.GuideServiceImplV1;

public class ExamB {
	public static void main(String[] args) {
		GuideService gService = new GuideServiceImplV1();
		
		gService.loadGuide();
		gService.printGuideList();
	}
}
