package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreServiceV1;
import com.callor.classes.service.ScoreServiceV2;

public class ExecD {
	public static void main(String[] args) {
		List<ScoreDto> scList = new ArrayList<>();
		ScoreServiceV2 scService = new ScoreServiceV2(scList);

		scService.makeScore();
		scService.makeScore(scList);
		//System.out.println(scList.toString());
	}
}
