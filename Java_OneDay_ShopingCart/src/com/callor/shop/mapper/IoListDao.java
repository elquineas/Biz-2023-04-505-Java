package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.shop.models.IoListDto;

public interface IoListDao {

	@Insert(" INSERT INTO tbl_iolist (ioseq,  iobuid, iopcode, iodate, iotime, ioquan, ioprice) "
		   + "VALUES( seq_iolist.nextval, #{ioBuid}, #{ioPCode}, #{ioDate}, #{ioTime}, #{ioQuan}, #{ioPrice} )")
	public int insert(IoListDto dto);
	
	@Select(" SELECT * FROM tbl_iolist WHERE iobuid = #{ioBuid} ")
	public List<IoListDto> ioIdList(String ioBuid);
	
	@Select(" SELECT * FROM tbl_iolist ORDER BY ioseq ")
	public List<IoListDto> ioList();

	@Select(" SELECT * FROM tbl_iolist "
		  + " WHERE ioDate between #{strdate1} AND #{strdate2} ")
	public List<IoListDto> ioDateList(
			@Param("strdate1") String strdate1, 
			@Param("strdate2") String strdate2);
	
	@Select(" SELECT * FROM tbl_iolist A, tbl_product B "
		  + " WHERE A.ioPCode = B.pCode AND B.pName LIKE '%' || #{pName} || '%' ")
	public List<IoListDto> ioCodeList(String pName);
	
	@Select(" SELECT * FROM tbl_iolist "
		  + " WHERE iobuid = #{strbuId} "
		  + " AND   ioDate between #{strdate1} AND #{strdate2} ")
	public List<IoListDto> ioIdDateList(
			@Param("strbuId") String strbuId, 
			@Param("strdate1") String strdate1, 
			@Param("strdate2") String strdate2);
//	strbuId,strdate1,strdate2
	
	
	
}
