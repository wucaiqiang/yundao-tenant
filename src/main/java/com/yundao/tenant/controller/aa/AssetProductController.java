

package com.yundao.tenant.controller.aa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.aa.product.AssetAllocationProductPageReqDto;
import com.yundao.tenant.dto.product.ProductSimpleResDto;
import com.yundao.tenant.service.aa.AssetProductService;
import com.yundao.tenant.util.SymbolStrUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 上午11:56:10 
 * @author   欧阳利
 * @version   
 */
@Controller
@RequestMapping(value = "/asset")
@Api(value = "资产配置管理-->产品管理")
@ResponseBody
public class AssetProductController {

	@Autowired
	AssetProductService assetProductService;
	
 	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
 	@ApiOperation(value = "资产配置修改产品")
 	public Result<Integer> addAssetAllocationProduct(@RequestParam Long id,@RequestParam  String productIds)throws BaseException{
 		if(id == null){
    		return Result.newFailureResult(Code1200000.CODE_1200178);
    	}
    	List<Long> productIdList = SymbolStrUtils.toLong(productIds);
 		return assetProductService.addAssetAllocationProduct(id, productIdList);
 	}
 	
    
	@RequestMapping(value = "/product/get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询资产配置的产品列表")
	public Result<PaginationSupport<ProductSimpleResDto>> getAssetAllocationProductPage(@ModelAttribute AssetAllocationProductPageReqDto reqDto)throws BaseException{
		if(reqDto.getAssetId() == null){
    		return Result.newFailureResult(Code1200000.CODE_1200178);
    	}
		
		return assetProductService.getAssetAllocationProductPage(reqDto);
	}
	
	
	@RequestMapping(value = "/product/get_productIds", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询资产配置的产品列表")
	public Result<List<Long>> getProductIds(@RequestParam Long id)throws BaseException{
		return assetProductService.getProductIds(id);
	}
	
}

