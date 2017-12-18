package com.yundao.tenant.service.product.attach.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.product.add.ProductAttachDto;
import com.yundao.tenant.dto.product.attach.ProductAttachAddReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.attach.ProductAttachUpdateReqDto;
import com.yundao.tenant.mapper.base.product.BaseProductAttachMapper;
import com.yundao.tenant.mapper.product.ProductAttachMapper;
import com.yundao.tenant.model.base.product.BaseProductAttach;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.ProductSendService;
import com.yundao.tenant.service.product.attach.ProductAttachService;

/**
 * 产品附件管理
 * 
 * @author 欧阳利 2017年7月7日
 */
@Service
public class ProductAttachServiceImpl extends AbstractService implements ProductAttachService {

	@Autowired
	BaseProductAttachMapper baseProductAttachMapper;

	@Autowired
	ProductAttachMapper productAttachMapper;
	@Autowired
	ProductSendService productSendService;

	/**
	 * 添加产品附件
	 * 
	 * @return
	 */
	public Result<Long> saveProductAttach(ProductAttachAddReqDto attachDto) throws Exception {
		BaseProductAttach record = new BaseProductAttach();
		BeanUtils.copyProperties(attachDto, record);
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setIsDelete(0);
		record.setTenantId(this.getHeaderTenantId());
		baseProductAttachMapper.insertSelective(record);

		// 添加附件发送消息
		productSendService.addProductAttach(attachDto.getProductId(), record.getId(), attachDto.getSourceName(),
				attachDto.getUrl());
		return Result.newSuccessResult(record.getId());
	}

	@Override
	public Result<Long> update(ProductAttachUpdateReqDto reqDto) throws Exception {
		BaseProductAttach record = new BaseProductAttach();
		record.setId(reqDto.getId());
		record.setShowType(reqDto.getShowType());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		int count = baseProductAttachMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(record.getId());

	}

	/**
	 * 删除产品附件
	 * 
	 * @param id
	 * @return
	 */
	public Result<Integer> delete(long id) throws Exception {
		BaseProductAttach record = new BaseProductAttach();
		record.setId(id);
		record.setIsDelete(1);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		int count = baseProductAttachMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(count);
	}

	/**
	 * 查询产品附件
	 * 
	 * @param reqDto
	 * @return
	 */
	public Result<PaginationSupport<ProductAttachListResDto>> gets(ProductAttachListReqDto reqDto) throws Exception {
		PaginationSupport<ProductAttachListResDto> result = reqDto.getPaginationSupport();
		int totalCount = productAttachMapper.getProductAttachCount(reqDto);
		if (totalCount > 0) {
			List<ProductAttachListResDto> list = productAttachMapper.getProductAttachByPage(reqDto);
			result.setDatas(list);
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	/**
	 * 查询产品的所有附件
	 * 
	 * @param ReqDto
	 * @return
	 */
	public List<ProductAttachListResDto> getAll(Long productId) throws Exception {
		if (productId == null) {
			return null;
		}
		return productAttachMapper.getAll(productId);
	}

	/**
	 * 添加产品附件
	 */
	@Override
	public Result<Integer> saveProductAttach(List<ProductAttachDto> attachDtos, Long productId) throws Exception {
		if (BooleanUtils.isEmpty(attachDtos)) {
			return Result.newSuccessResult(0);
		}
		for (ProductAttachDto dto : attachDtos) {
			BaseProductAttach record = new BaseProductAttach();
			BeanUtils.copyProperties(dto, record);
			record.setProductId(productId);
			record.setIsDelete(0);
			record.setCreateDate(new Date());
			record.setCreateUserId(this.getHeaderUserId());
			record.setTenantId(this.getHeaderTenantId());
			baseProductAttachMapper.insert(record);
		}
		return Result.newSuccessResult(attachDtos.size());
	}

	/**
	 * 从请求中获取附件集合
	 * 
	 * @param request
	 *            请求request
	 */
	public List<ProductAttachDto> getProductAttachDto(String productAttachDtos) throws BaseException {
		if (BooleanUtils.isBlank(productAttachDtos)) {
			return null;
		}
		JavaType javaType = JsonUtils.getCollectionType(List.class, ProductAttachDto.class);
		List<ProductAttachDto> productAttachList = JsonUtils.jsonToObject(productAttachDtos, javaType);
		return productAttachList;
	}

	/**
	 * 通过附件id 查询附件基本信息
	 * 
	 * @param id
	 * @throws BaseException
	 */
	public BaseProductAttach getBaseProductAttach(Long id) throws BaseException {
		return baseProductAttachMapper.selectByPrimaryKey(id);
	}

}
