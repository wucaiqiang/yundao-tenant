package com.yundao.tenant.service.customercenter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseQueryReqDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseResDto;
import com.yundao.tenant.dto.product.h5.ProductNoticeDto;

public interface ProductH5SelectService {
   
	   public Result<List<ProductH5BaseResDto>> getHotList(ProductH5BaseQueryReqDto reqDto) throws BaseException;
	
	
	/**
	 * 分页查询产品列表
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
    public Result<PaginationSupport<ProductH5BaseResDto>> getList(ProductH5BaseQueryReqDto reqDto) throws BaseException;
    public Result<List<ProductBaseResDto>> getReCommendedListForApp(Integer limit,String issuedStatuses,String platformCode,String positionCode) throws BaseException;
    
    /**
     * 通过产品id查询产品的公告(审核通过并发布的公告)
     * getProductNoticeDtos:
     * @author: 欧阳利
     * @param productId
     * @return
     * @description:
     */
    public List<ProductNoticeDto> getProductNoticeDtos(@Param("productId") Long productId)throws BaseException;

}
