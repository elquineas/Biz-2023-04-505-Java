package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.models.ProductDto;


public interface ProductDao {
	@Select(" SELECT * FROM tbl_product ORDER BY pCode ASC ")
	public List<ProductDto> productList();
	
	@Select(" SELECT * FROM tbl_product WHERE pCode = #{pCode} ")
	public ProductDto codeSelect(String pCode);
	
	@Insert(" INSERT INTO tbl_product (pcode, pname, pitem, piprice, poprice) "
		  + " VALUES(#{pCode},#{pName},#{pItem},#{pIPrice},#{pOPrice}) ")
	public int insert(ProductDto dto);

	@Update(" UPDATE tbl_product "
		  + " SET    pname   = #{pName}, "
		  + "        pitem   = #{pItem}, "
		  + "        piprice = #{pIPrice}, "
		  + "        poprice = #{pOPrice} "
		  + " WHERE  pcode   = #{pCode} ")
	public int update(ProductDto dto);
}
