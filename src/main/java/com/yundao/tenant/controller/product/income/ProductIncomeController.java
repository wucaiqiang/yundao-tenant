package com.yundao.tenant.controller.product.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.income.IncomeRuleUpdateDto;
import com.yundao.tenant.dto.product.income.IncomeRuleUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.examine.ProductExamineService;
import com.yundao.tenant.service.product.income.ProductIncomeRuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/income")
@ResponseBody
@Api("产品收益管理")
public class ProductIncomeController {
	
	@Autowired
	ProductIncomeRuleService productIncomeRuleService;
	@Autowired
	ProductSelectService productSelectService;
	@Autowired
	ProductExamineService productExamineService;
	
	/**
	 * 修改收益
	 * @param reqDto
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "修改收益")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Integer> updateProductIncome(@ModelAttribute IncomeRuleUpdateReqDto reqDto)throws Exception{
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
		
		List<IncomeRuleUpdateDto>  list = productIncomeRuleService.getIncomeRuleUpdateDtos(reqDto.getIncomeDtos());
		
		
		// 校验佣金
		Result<Boolean> incomeResult =productIncomeRuleService.checkIncomeRuleUpdateDtos(list,
				baseProductSale.getIsScale(),baseProductSale.getProductScale());
		if(!incomeResult.getSuccess()){
			return Result.newFailureResult(incomeResult.getCode());
		}
		
		// 修改数据
    	return productIncomeRuleService.updateIncomeRule(list, reqDto.getProductId());
	}
	
}
