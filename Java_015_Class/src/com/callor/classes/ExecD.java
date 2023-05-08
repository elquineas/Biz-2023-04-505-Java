package com.callor.classes;

import java.util.ArrayList;
import java.util.List;

import com.callor.models.StudentDto;

public class ExecD {
	public static void main(String[] args) {
		StudentDto stDto = new StudentDto();
		// 각 변수에 값을 setting 하기
		stDto.setStNum("0001");
		stDto.setStName("홍길동");
		stDto.setStDept("정보통신학과");
		stDto.setStGrade(3);
		stDto.setStTel("010-1111-2222");
		
		// 리스트에 추가하기
		List<StudentDto> stList = new ArrayList<>();
		stList.add(stDto);
		
		// 새로운 학생정보를 임의생성자를 통해서 데이터가 담긴 객체를 생성 
		stDto = new StudentDto("0002", "이몽룡", "전자공학", 2, "010-2222-3333");
		stList.add(stDto);
		
		System.out.println(stList.toString());
		
	}
}
