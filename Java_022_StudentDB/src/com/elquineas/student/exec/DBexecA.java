package com.elquineas.student.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.elquineas.student.comfig.DBConnection;
import com.elquineas.student.mapper.StudentDao;
import com.elquineas.student.models.StudentDto;

public class DBexecA {
	public static void main(String[] args) {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		
		StudentDao stDao = sqlSession.getMapper(StudentDao.class);
		
		List<StudentDto> stDto = stDao.selectAll();
		System.out.println(stDto);
	}
}
