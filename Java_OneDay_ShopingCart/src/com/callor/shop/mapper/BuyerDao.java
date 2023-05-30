package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.shop.models.BuyerDto;


public interface BuyerDao {
	@Select(" SELECT * FROM tbl_buyer ORDER BY buName DESC ")
	public List<BuyerDto> selectAll();
	
	@Select(" SELECT * FROM tbl_buyer WHERE buId = #{id} ")
	public BuyerDto select(String id);
	
	@Select(" SELECT MAX(buid) FROM tbl_buyer ")
	public String maxId();
	
	@Insert(" INSERT INTO tbl_buyer (buid, buname, butel, buAddr) "
		  + " VALUES( #{buId}, #{buName}, #{buTel}, #{buAddr} ) ")
	public int insert(BuyerDto dto);
}
