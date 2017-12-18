
package com.yundao.tenant.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.product.ProductCenterListReqDto;
import com.yundao.tenant.dto.product.ProductCenterListResDto;
import com.yundao.tenant.service.product.ProductCenterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品中心
 * 
 * @author 欧阳利
 * 2017年8月24日
 */
@RestController
@RequestMapping("/product/center")
@ResponseBody
@Api("产品中心")
public class ProductCenterController {
	
	@Autowired
	ProductCenterService productCenterService;
	
	/**
	 * 分页产品产品管理列表
	 *
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	@ApiOperation(value = "分页产品中心列表", notes = "分页产品中心列表")
	public Result<PaginationSupport<ProductCenterListResDto>> gets(
			@ModelAttribute ProductCenterListReqDto reqDto) throws BaseException {
		return productCenterService.gets(reqDto);
	}
}
