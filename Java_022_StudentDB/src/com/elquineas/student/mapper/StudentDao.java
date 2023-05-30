package com.elquineas.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.elquineas.student.models.StudentDto;
/*
 * Dao(Data Access Object)
 *  = Mapper(SQL문과 DTO를 자동으로 매칭시킨다)
 *  
 *  DB와 연결하여 CRUD를 처리하는 객체
 *  
 *  Mybatis를 사용하게 되면 Dao interface를 생성하고
 *  각 method에 Annotation을 부착하여 SQL 명령문을 설정한다
 *  
 *  그러면 나머지 여러가지 코드
 *  	DBMS에서 데이터를 가져와서 DTO에 담고, 다시 List add 하여
 *  	return 하는 이러한 코드를 Mybatis의 SqlSessionFactory가 대신 생성해 준다.
 *  
 */
public interface StudentDao {
	
	@Select(" SELECT * FROM tbl_student ")
	public List<StudentDto> selectAll();
	
	@Select(" SELECT * FROM tbl_student WHERE st_Num = #{id} ")
	public StudentDto findById(String id);
	
	@Delete(" DELECT FROM tbl_student WHERE st_num = #{id} ")
	public int delete();
	
	
}
