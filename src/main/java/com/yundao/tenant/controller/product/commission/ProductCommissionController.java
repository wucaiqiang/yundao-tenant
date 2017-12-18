package com.yundao.tenant.controller.product.commission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleUpdateDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.commission.ProductCommissionRuleService;
import com.yundao.tenant.service.product.examine.ProductExamineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/commission")
@ResponseBody
@Api("产品佣金管理")
public class ProductCommissionController {
	
	@Autowired
	ProductCommissionRuleService productCommissionRuleService;
	@Autowired
	ProductSelectService productSelectService;
	@Autowired
	ProductExamineService productExamineService;
	/**
	 * 修改佣金
	 * @param reqDto
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "修改佣金")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Integer> updateProductCommission(@ModelAttribute ProductCommissionRuleUpdateReqDto reqDto)throws Exception{
		// 检查是否有权限修改
		if(reqDto.getProductId() == null){
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		
		// 审核中的产品不能修改
		boolean isApprovaling = productExamineService.checkProductIsApprovaling(reqDto.getProductId());
		if(isApprovaling){
			return Result.newFailureResult(CodeConstant.CODE_1200093);
		}
		
    	BaseProduct baseProduct = productSelectService.getBaseProduct(reqDto.getProductId());
    	if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
    	BaseProductSale baseProductSale = productSelectService.selectBaseProductSaleByProductId(reqDto.getProductId());
    	if(baseProductSale == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200042);
    	}
		// 对象转换
		List<ProductCommissionRuleUpdateDto>  list = productCommissionRuleService.getProductCommissionRuleUpdateDtos(reqDto.getCommissionDtos());
		
		// 校验佣金
		Result<Boolean> commissionResult = productCommissionRuleService.checkCommissionRuleUpdateDtos(list,
				baseProductSale.getIsScale(),baseProductSale.getProductScale());
		if(!commissionResult.getSuccess()){
			return Result.newFailureResult(commissionResult.getCode());
		}
		
		// 修改数据
    	return productCommissionRuleService.updateCommissionDtos(list, reqDto.getProductId());
	}
}
