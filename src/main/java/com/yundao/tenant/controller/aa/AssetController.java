

package com.yundao.tenant.controller.aa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.aa.asset.AddAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageResDto;
import com.yundao.tenant.dto.aa.asset.UpdateAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.dto.question.QuestionAndOptionReqDto;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScore;
import com.yundao.tenant.service.aa.AssetService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
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
@Api(value = "资产配置管理")
@ResponseBody
public class AssetController {

	@Autowired
	AssetService assetService;
	@Autowired
	UserCustomerService userCustomerService;
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加资产配置")
	public Result<AssetPlanDto> addAssetAllocation(@Validated @ModelAttribute AddAssetAllocationReqDto reqDto,
			BindingResult bindingResult) throws Exception {
    	// 数据转换和基本校验
		BindingResultHandler.handleByException(bindingResult);
		if (BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}
		List<QuestionAndOptionReqDto> questionAndOptionDtoList = null;
		JavaType javaType = JsonUtils.getCollectionType(List.class, QuestionAndOptionReqDto.class);
		if (!BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			questionAndOptionDtoList = JsonUtils.jsonToObject(reqDto.getQuestionAndOptionDtos(), javaType);
			reqDto.setQuestionAndOptionDtoList(questionAndOptionDtoList);
		}
		if (BooleanUtils.isEmpty(questionAndOptionDtoList)) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}
		
		if(reqDto.getCustomerId() == null){
			return Result.newFailureResult(CodeConstant.CODE_1220047);
		}
		
		// 检查客户是否是自己的
		Long userId = userCustomerService.getUserIdByCustomer(reqDto.getCustomerId());
		HeaderUser result =(HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		if(userId == null || result == null || !result.getUserId().equals(userId)){
			return Result.newFailureResult(Code1200000.CODE_1200181);
		}
		
		return assetService.addAssetAllocation(reqDto);
	}
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改资产配置(重新做题)")
	public Result<AssetPlanDto> updateAssetAllocation(@Validated @ModelAttribute UpdateAssetAllocationReqDto reqDto,
			BindingResult bindingResult) throws Exception {
    	// 数据转换和基本校验
		BindingResultHandler.handleByException(bindingResult);
		if (BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}
		List<QuestionAndOptionReqDto> questionAndOptionDtoList = null;
		JavaType javaType = JsonUtils.getCollectionType(List.class, QuestionAndOptionReqDto.class);
		if (!BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			questionAndOptionDtoList = JsonUtils.jsonToObject(reqDto.getQuestionAndOptionDtos(), javaType);
			reqDto.setQuestionAndOptionDtoList(questionAndOptionDtoList);
		}
		if (BooleanUtils.isEmpty(questionAndOptionDtoList)) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}
		
		// 检查资产配置是否是自己的
		BaseAaQuestionScore base = assetService.getBaseAaQuestionScore(reqDto.getId());
		if(base == null){
			return Result.newFailureResult(Code1200000.CODE_1200182);
		}
		HeaderUser result =(HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		if(!base.getUserId().equals(result.getUserId())){
			return Result.newFailureResult(Code1200000.CODE_1200183);
		}
		
		return assetService.updateAssetAllocation(reqDto);
	}


	
    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询资产配置(历史配置)")
	public Result<PaginationSupport<AssetAllocationPageResDto>> getAssetAllocationPage(@ModelAttribute AssetAllocationPageReqDto reqDto)throws Exception{
		return assetService.getAssetAllocationPage(reqDto);
	}
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除资产配置")
    public Result<Integer> delete(String ids)throws Exception{
    	if(BooleanUtils.isBlank(ids)){
    		return null;
    	}
    	List<Long> idList = SymbolStrUtils.toLong(ids);
    	
    	return assetService.delete(idList);
    }
    
	
}

