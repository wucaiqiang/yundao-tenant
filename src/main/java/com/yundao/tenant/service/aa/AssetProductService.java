

package com.yundao.tenant.service.aa;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.aa.product.AssetAllocationProductPageReqDto;
import com.yundao.tenant.dto.product.ProductSimpleResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午1:57:46 
 * @author   欧阳利
 * @version   
 */
public interface AssetProductService {
	
 	/**
 	 * 资产配置修改产品
 	 * addAssetAllocationProduct:
 	 * @author: 欧阳利
 	 * @param id
 	 * @param productIds
 	 * @return
 	 * @throws BaseException
 	 * @description:
 	 */
 	public Result<Integer> addAssetAllocationProduct( Long id,  List<Long> productIds)throws BaseException;
 	
    
	/**
	 * 分页查询资产配置的产品列表
	 * getAssetAllocationProductPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<ProductSimpleResDto>> getAssetAllocationProductPage( AssetAllocationProductPageReqDto reqDto)throws BaseException;
	
	
	/**
	 * 查询资产配置关联的产品id集合
	 * getProductIds:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<List<Long>> getProductIds(@RequestParam Long id)throws BaseException;
	
}

