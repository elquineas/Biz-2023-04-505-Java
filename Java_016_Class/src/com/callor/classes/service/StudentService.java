package com.callor.classes.service;

import com.callor.classes.models.StudentDto;

public interface StudentService {

	public void loadStudent();
	public void printStudent();
	
	// 학번을 전달받아서 stList에서 학번이 일치하는 학생을 찾아서 리턴
	public StudentDto getStudent(String stNum);
}
