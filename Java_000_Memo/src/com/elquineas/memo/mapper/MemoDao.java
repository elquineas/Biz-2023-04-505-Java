package com.elquineas.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elquineas.memo.models.MemoDto;

public interface MemoDao {

	@Select(" SELECT * FROM tbl_memo ORDER BY m_seq DESC ")
	public List<MemoDto> selectAll();

	@Select(" SELECT * FROM tbl_memo WHERE m_seq = #{seq} ORDER BY m_seq DESC ")
	public List<MemoDto> serch(String seq);

	@Select(" SELECT * FROM tbl_memo "
			+ "WHERE m_subject LIKE '%' || #{strText} || '%' "
			+ "   OR m_content LIKE '%' || #{strText} || '%' "
			+ "ORDER BY m_seq DESC ")
	public List<MemoDto> serchText(String strText);
	
	@Insert(" INSERT INTO tbl_memo(m_seq,m_writer,m_date,m_subject,m_content) "
		  + " VALUES(seq_memo.nextval,#{m_writer},#{m_date},#{m_subject},#{m_content}) ")
	public int insert(MemoDto dto);

	@Update(" UPDATE tbl_memo"
		  + " SET    m_writer = #{m_writer}, m_subject = #{m_subject}, m_content = #{m_content} "
		  + " WHERE  m_seq = #{m_seq} ")
	public int update(MemoDto dto);
	
	@Delete(" DELETE FROM tbl_memo "
		  + " WHERE  m_seq = #{strNum} ")
	public int delete(String strNum);
	
}
