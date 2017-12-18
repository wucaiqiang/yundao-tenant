

package com.yundao.tenant.controller.aa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.dto.aa.plan.PlanDescriptionDto;
import com.yundao.tenant.service.aa.AssetPlanService;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;

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
@RequestMapping(value = "/asset/plan")
@Api(value = "资产配置管理-->方案")
@ResponseBody
public class AssetPlanController {
   
	@Autowired
	AssetPlanService assetPlanService;
	@Autowired
	CcCustomerUserRelService ccCustomerUserRelService;
	
	@RequestMapping(value = "get_plan_description", method = RequestMethod.GET)
	@ApiOperation(value = "通过资产配置id获取方案说明")
	public Result<PlanDescriptionDto> getPlanDescriptionDto(@RequestParam Integer riskValue)throws Exception{
		if(riskValue == null){
			return Result.newFailureResult(Code1200000.CODE_1200178);
		}
		return assetPlanService.getPlanDescriptionDto(riskValue);
	}
	
	
	@RequestMapping(value = "get_asset_plan", method = RequestMethod.GET)
	@ApiOperation(value = "获取配置方案")
	public Result<AssetPlanDto> getAssetAllocationDto(@RequestParam Long id)throws Exception{
		if(id == null){
			return Result.newFailureResult(Code1200000.CODE_1200178);
		}
		return assetPlanService.getAssetAllocationDtoToUser(id);
	}
	
	
	
	@RequestMapping(value = "get_customer_plan", method = RequestMethod.GET)
	@ApiOperation(value = "获取配置方案")
	public Result<AssetPlanDto> getCustomerAssetAllocationDto(@RequestParam Long customerId)throws Exception{
		if(customerId == null){
			return Result.newFailureResult(Code1200000.CODE_1200178);
		}
		return assetPlanService.getCustomerPlan(customerId);
	}

	
	@RequestMapping(value = "get_current_user_plan", method = RequestMethod.GET)
	@ApiOperation(value = "获取配置方案")
	public Result<AssetPlanDto> getCurrentUserAssetAllocationDto()throws Exception{
		HeaderUser user =  (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		Long customerId = ccCustomerUserRelService.getCustomerIdByUserId(user.getUserId());
		return assetPlanService.getCustomerPlan(customerId);
	}
	
}

