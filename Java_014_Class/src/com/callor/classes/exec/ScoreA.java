package com.callor.classes.exec;

import com.callor.classes.models.ScoreDto;

public class ScoreA {
	public static void main(String[] args) {
		ScoreDto scoreDto = new ScoreDto();
		scoreDto.setStNum("0001");
		scoreDto.setScKor(80);
		scoreDto.setScMath(79);
		scoreDto.setScMusic(84);
		scoreDto.setScArt(95);
		
		System.out.println(scoreDto.toString());
	}
}
