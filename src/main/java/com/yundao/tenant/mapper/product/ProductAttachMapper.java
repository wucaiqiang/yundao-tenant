package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;

public interface ProductAttachMapper {
	
	/**
	 * 分页查询产品附件集合
	 * @param ReqDto
	 * @return
	 */
    public List<ProductAttachListResDto>  getProductAttachByPage(ProductAttachListReqDto ReqDto);
    
    
	/**
	 * 查询产品附件集合个数
	 * @param ReqDto
	 * @return
	 */
    public int  getProductAttachCount(ProductAttachListReqDto ReqDto);
    
    
	/**
	 * 查询产品的所有附件
	 * @param productId
	 * @return
	 */
    public List<ProductAttachListResDto>  getAll(@Param("productId")Long productId);
}
