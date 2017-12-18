package com.yundao.tenant.service.product;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.product.ProductCenterListReqDto;
import com.yundao.tenant.dto.product.ProductCenterListResDto;

public interface ProductCenterService {
	
	/**
	 * 分页查询产品中心列表
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	public Result<PaginationSupport<ProductCenterListResDto>> gets(ProductCenterListReqDto reqDto) throws BaseException;
	
	
	 public List<FiledSelectDto> getlevelAndRiskLevelSelect();
}
