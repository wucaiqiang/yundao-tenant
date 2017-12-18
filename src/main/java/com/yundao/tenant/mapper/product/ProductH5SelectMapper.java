
package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseQueryReqDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseResDto;
import com.yundao.tenant.dto.product.h5.ProductNoticeDto;

/**
 * Function: Reason: Date: 2017年9月7日 上午11:28:48
 * 
 * @author 欧阳利
 * @version
 */
public interface ProductH5SelectMapper {

	/**
	 * 分页查询列表
	 * 
	 * @param reqDto
	 * @return
	 */
	List<ProductH5BaseResDto> getProductList(ProductH5BaseQueryReqDto reqDto);

	List<ProductBaseResDto> getReCommendedList(ProductH5BaseQueryReqDto reqDto);

	/**
	 * 查询列表的总记录数
	 * 
	 * @param reqDto
	 * @return
	 */
	int getProductListCount(ProductH5BaseQueryReqDto reqDto);

	/**
	 * 通过产品id查询产品的公告(审核通过并发布的公告) getProductNoticeDtos:
	 * 
	 * @author: 欧阳利
	 * @param productId
	 * @return
	 * @description:
	 */
	List<ProductNoticeDto> getProductNoticeDtos(@Param("productId") Long productId);
}
