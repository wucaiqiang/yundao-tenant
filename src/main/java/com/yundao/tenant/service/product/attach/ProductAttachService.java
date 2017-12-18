package com.yundao.tenant.service.product.attach;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.product.add.ProductAttachDto;
import com.yundao.tenant.dto.product.attach.ProductAttachAddReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.attach.ProductAttachUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProductAttach;

/**
 * 产品附件管理
 * 
 * @author 欧阳利
 * 2017年7月7日
 */
public interface ProductAttachService {

	/**
	 * 添加产品附件
	 * @return
	 */
	public Result<Long> saveProductAttach(ProductAttachAddReqDto attachDto)throws Exception;
	public Result<Long> update(@ModelAttribute ProductAttachUpdateReqDto reqDto)throws Exception;
	
	/**
	 * 删除产品附件
	 * @param id
	 * @return
	 */
	 public Result<Integer> delete(long id)throws Exception;
	
	 /**
	  * 查询产品附件
	  * @param ReqDto
	  * @return
	  */
	 public Result<PaginationSupport<ProductAttachListResDto>> gets(ProductAttachListReqDto ReqDto)throws Exception;
	 
	 /**
	  * 查询产品的所有附件
	  * @param ReqDto
	  * @return
	  */
	 public List<ProductAttachListResDto> getAll(Long productId)throws Exception;
	 
	/**
	 * 添加产品附件
	 * @return
	 */
	public Result<Integer> saveProductAttach(List<ProductAttachDto> attachDtos,Long productId)throws Exception;
	
	/**
	 * 对象转换
	 * @param productAttachDtos
	 * @return
	 * @throws BaseException
	 */
	public List<ProductAttachDto> getProductAttachDto(String productAttachDtos) throws BaseException;
	
	
	/**
	 * 通过附件id 查询附件基本信息
	 * @param id
	 * @throws BaseException
	 */
	public BaseProductAttach getBaseProductAttach(Long id)throws BaseException;
}
