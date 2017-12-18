package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.product.ProductBaseQueryReqDto;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.ProductCenterListReqDto;
import com.yundao.tenant.dto.product.ProductCenterListResDto;
import com.yundao.tenant.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.dto.product.ProductManagerListResDto;
import com.yundao.tenant.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.dto.product.ProductSelectionForDeclaration;
import com.yundao.tenant.dto.product.ProductSelectionForReceiptPlanDto;

public interface ProductSelectMapper {
	/**
	 * 分页查询产品管理列表
	 *
	 * @param reqDto
	 * @return
	 */
	List<ProductManagerListResDto> getManagerList(ProductManagerListReqDto reqDto);

	List<ProductBaseResDto> selectList(ProductBaseQueryReqDto reqDto);
	List<ProductBaseResDto> selectDirectModelOrHadReservationList(ProductBaseQueryReqDto reqDto);

	/**
	 * 查询产品管理列表的个数
	 *
	 * @param reqDto
	 * @return
	 */
	int getManagerListCount(ProductManagerListReqDto reqDto);

	int selectListCount(ProductBaseQueryReqDto reqDto);

	int selectDirectModelOrHadReservationListCount(ProductBaseQueryReqDto reqDto);

	/**
	 * 查询用户总记录数
	 *
	 * @return
	 */
	List<ProductSelectOptionDto> getProductSelectOptionDtos(@Param("name") String name, @Param("scope") String scope,
			@Param("count") Integer count);

	/**
	 * 查询用户总记录数
	 *
	 * @return
	 */
	List<ProductSelectionForDeclaration> getProductSelectForDeclaration(@Param("name") String name,
			@Param("count") Integer count);

	/**
	 * 获取某个类型的产品下拉列表
	 *
	 * @param typeId
	 * @param count
	 * @return
	 */
	List<ProductSelectOptionDto> getProductSelectOptionDtosByTypeId(@Param("typeId") Long typeId,
			@Param("count") Integer count);

	/**
	 * 分页查询产品中心列表
	 *
	 * @param reqDto
	 * @return
	 */
	List<ProductCenterListResDto> getProductCenterList(ProductCenterListReqDto reqDto);

	/**
	 * 查询产品中心列表的总记录数
	 *
	 * @param reqDto
	 * @return
	 */
	int getProductCenterListCount(ProductCenterListReqDto reqDto);

	/**
	 * 添加回款计划，产品下拉选项
	 *
	 * @param name
	 *            产品名称
	 */
	List<ProductSelectionForReceiptPlanDto> selectForReceiptPlan(@Param("name") String name) throws BaseException;
}
