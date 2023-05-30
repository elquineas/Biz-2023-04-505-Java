package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.shop.models.IoListDto;
import com.callor.shop.models.ProductDto;

public interface IoListDao {

	@Insert(" INSERT INTO tbl_iolist (ioseq,  iobuid, iopcode, iodate, iotime, ioquan, ioprice) "
		   + "VALUES( seq_iolist.nextval, #{ioBuid}, #{ioPCode}, #{ioDate}, #{ioTime}, #{ioQuan}, #{ioPrice} )")
	public int insert(IoListDto dto);
	
	@Select(" SELECT * FROM tbl_iolist WHERE iobuid = #{ioBuid} ")
	public List<IoListDto> ioIdList(String ioBuid);
	
	@Select(" SELECT * FROM tbl_iolist ORDER BY ioseq ")
	public List<IoListDto> ioList();

	@Select(" SELECT * FROM tbl_iolist "
		  + " WHERE ioDate between #{arg0} AND #{arg1} ")
	public List<IoListDto> ioDateList(String arg0, String arg1);
	
	@Select(" SELECT * FROM tbl_iolist A, tbl_product B "
		  + " WHERE A.ioPCode = B.pCode AND B.pName LIKE '%' || #{pName} || '%' ")
	public List<IoListDto> ioCodeList(String pName);
	
	@Select(" SELECT * FROM tbl_iolist "
		  + " WHERE iobuid = #{arg0} "
		  + " AND   ioDate between #{arg1} AND #{arg2} ")
	public List<IoListDto> ioIdDateList(String arg0, String arg1, String arg2);
	
	
	
}
