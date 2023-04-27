package com.callor.score.model;

public class ScoreDto {
	// 나 - 국어, 영어, 수학, 음악, 미술 성적을 저장할 ScoreDto 클래스를 모델링합니다
	public String stName;
	public String stNum;
	
	public int kor;
	public int eng;
	public int math;
	public int music;
	public int art;
	
	public int getTotal(ScoreDto score) {
		int total = score.kor + score.eng + score.math + score.music + score.art;
		return total;
	}
	
	public float getAvg(ScoreDto score) {
		int total = score.kor + score.eng + score.math + score.music + score.art;
		float avg = total/5f;
		return avg;
	}
	
}
