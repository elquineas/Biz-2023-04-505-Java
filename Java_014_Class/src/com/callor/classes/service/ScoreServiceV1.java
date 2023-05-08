package com.callor.classes.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;

/*
 * 매개변수로 일반 변수가 아닌 참조형 객체변수를 사용했다.
 * 참조형 객체변수는 실제 저장된 값이 전달되는 거싱 아니고 기억장소의 주소가 전달된다
 * main() method에서 보낼때 scoreList의 주소가 전달되고
 * makeScore()에서 값을 변결 시키면 main() method의 scoreList가 같이 바뀐다.
 */

public class ScoreServiceV1 {
	// 학생 수
	private int classSize = 10;
	// 줄긋기 수
	private int barSize = 50;
	

	public void makeScore(List<ScoreDto> scoreList) {
		for (int i = 0; i < classSize; i++) {
			String stNum = String.format("%04d", i + 1);
			int scKor = (int) (Math.random() * 50) + 51;
			int scMath = (int) (Math.random() * 50) + 51;
			int scMusic = (int) (Math.random() * 50) + 51;
			int scArt = (int) (Math.random() * 50) + 51;

			/*
			 * 배열에서는 먼저 배열선언, 초기화후 각 요소에 데이터 저장 List type의 데이터 1.먼저 비어있는 List type을 생성하고
			 * 2.Dto 객체변수를 생성하고 3.Dto 각 변수에 값을 setting(setter) 4.List에 Dto를 add
			 */
			ScoreDto scoreDto = new ScoreDto();
			scoreDto.setStNum(stNum);
			scoreDto.setScKor(scKor);
			scoreDto.setScMath(scMath);
			scoreDto.setScMusic(scMusic);
			scoreDto.setScArt(scArt);
			scoreList.add(scoreDto);
		}
	}

	public void printScore(List<ScoreDto> scoreList) {
		System.out.println("=".repeat(barSize));
		System.out.println("학번\t국어\t수학\t음악\t미술\t총점");
		System.out.println("-".repeat(barSize));
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.printf("%s\t", scoreList.get(i).getStNum());
			System.out.printf("%5d\t", scoreList.get(i).getScKor());
			System.out.printf("%5d\t", scoreList.get(i).getScMath());
			System.out.printf("%5d\t", scoreList.get(i).getScMusic());
			System.out.printf("%5d\t", scoreList.get(i).getScArt());
			System.out.printf("%5d\t\n", scoreList.get(i).getTotal());
		}
		System.out.println("-".repeat(barSize));
	}
	
	public void sortScore(List<ScoreDto> scoreList) {
		for(int i = 0; i < scoreList.size(); i++) {
			for(int j = i+1; j < scoreList.size(); j++) {
				if(scoreList.get(i).getTotal() > scoreList.get(j).getTotal()) {
					ScoreDto sList = scoreList.get(i);
					scoreList.set(i, scoreList.get(j));
					scoreList.set(j, sList);
				}
			}
		}
	}


	private int totalKor   = 0;
	private int totalMath  = 0;
	private int totalMusic = 0;
	private int totalArt   = 0;
	
	public void totalScore(List<ScoreDto> scoreList) {
		for(int i = 0; i< scoreList.size(); i++) {
			totalKor   += scoreList.get(i).getScKor();
			totalMath  += scoreList.get(i).getScMath();
			totalMusic += scoreList.get(i).getScMusic();
			totalArt   += scoreList.get(i).getScArt();
		}
		System.out.printf("총합\t");
		System.out.printf("%5d\t",totalKor);
		System.out.printf("%5d\t",totalMath);
		System.out.printf("%5d\t",totalMusic);
		System.out.printf("%5d\n",totalArt);
	}

	public void avgScore(List<ScoreDto> scoreList) {
		float avgKor   = (float)totalKor/scoreList.size();
		float avgMath  = (float)totalMath/scoreList.size();
		float avgMusic = (float)totalMusic/scoreList.size();
		float avgArt   = (float)totalArt/scoreList.size();
		
		System.out.printf("평균\t");
		System.out.printf("%5.2f\t",avgKor);
		System.out.printf("%5.2f\t",avgMath);
		System.out.printf("%5.2f\t",avgMusic);
		System.out.printf("%5.2f\n",avgArt);
		System.out.println("=".repeat(barSize));
		
	}

	public void add(int num1, int num2) {
		num1 = 1000;
		num2 = 2000;
	}

}
