package com.yundao.tenant.controller.question;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.question.CustomerRiskPageReqDto;
import com.yundao.tenant.dto.question.CustomerRiskPageResDto;
import com.yundao.tenant.dto.question.CustomerRiskQuestionResDto;
import com.yundao.tenant.dto.question.CustomerRiskResDto;
import com.yundao.tenant.dto.question.QuestionAndOptionReqDto;
import com.yundao.tenant.dto.question.QuestionDto;
import com.yundao.tenant.dto.question.RiskEvaluationReqDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.enums.question.QuestionTypeCodeEnum;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.question.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/question/")
@ResponseBody
@Api("题目管理")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CcCustomerUserRelService ccCustomerUserRelService;

	
	@RequestMapping(value = "gets_risk_question", method = RequestMethod.GET)
	@ApiOperation(value = "获取风险评估题目")
	public Result<List<QuestionDto>> getRiskQuestions() throws Exception {
		List<QuestionDto> list = questionService.getQuestions(QuestionTypeCodeEnum.RISK.getCode());
		return Result.newSuccessResult(list);
	}

	
	@RequestMapping(value = "risk/evaluation", method = RequestMethod.POST)
	@ApiOperation(value = "风险测评")
	public Result<RiskEvaluationResDto> riskEvaluation(@Validated @ModelAttribute RiskEvaluationReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		// 数据转换和基本校验
		BindingResultHandler.handleByException(bindingResult);
		if (BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}
		List<QuestionAndOptionReqDto> QuestionAndOptionDtoList = null;
		JavaType javaType = JsonUtils.getCollectionType(List.class, QuestionAndOptionReqDto.class);
		if (!BooleanUtils.isBlank(reqDto.getQuestionAndOptionDtos())) {
			QuestionAndOptionDtoList = JsonUtils.jsonToObject(reqDto.getQuestionAndOptionDtos(), javaType);
		}
		if (BooleanUtils.isEmpty(QuestionAndOptionDtoList)) {
			return Result.newFailureResult(CodeConstant.CODE_1200125);
		}

		// 保存结果
		Result<RiskEvaluationResDto> result = questionService.doRiskEvaluation(QuestionAndOptionDtoList);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		return result;
	}
	

	@RequestMapping(value = "get/risk_evaluation_result", method = RequestMethod.GET)
	@ApiOperation(value = "获取分析测评结果(投资者id)")
	public Result<RiskEvaluationResDto> getRiskEvaluation(@RequestParam Long userId) throws Exception {
		if(userId == null){
			return Result.newFailureResult(CodeConstant.CODE_1200124);
		}
		return questionService.getRiskEvaluation(userId);
	}
	
	
	@RequestMapping(value = "get/customer/risk_evaluation_result", method = RequestMethod.GET)
	@ApiOperation(value = "获取分析测评结果(客户id)")
	public Result<CustomerRiskResDto> getRiskEvaluationByCustomerId(@RequestParam Long customerId) throws Exception {
		if(customerId == null){
			return Result.newFailureResult(CodeConstant.CODE_1220047);
		}
		// 判断客户是否存在
		Boolean isExist = customerService.exist(customerId).getResult();
		if(!isExist){
			return Result.newFailureResult(CodeConstant.CODE_1200084);
		}
		
		CustomerRiskResDto dto = new CustomerRiskResDto();
		dto.setCustomerId(customerId);
		// 查询客户id对应的用户id
		Long userId = ccCustomerUserRelService.getUserIdByCustomerId(customerId);
		if(userId == null){
			dto.setIsExistUserId(false);
			return Result.newSuccessResult(dto);
		}
		dto.setIsExistUserId(true);
		
		// 获取查询结果
		Result<RiskEvaluationResDto> result = questionService.getRiskEvaluation(userId);
		if(!result.getSuccess()){
			if(CodeConstant.CODE_1200123 == result.getCode()){
				dto.setIsEvaluation(false);
				return Result.newSuccessResult(dto);
			}
			return Result.newFailureResult( result.getCode());
		}
		dto.setIsEvaluation(true);
		BeanUtils.copyProperties(result.getResult(), dto);
		
		// 获取测评题目和选择的答案
		List<CustomerRiskQuestionResDto> list = questionService.getRiskEvaluationByUserId(userId);
		dto.setQuestionDtos(list);
		
		return Result.newSuccessResult(dto);
	}

	
	/**
	 * 分页获取我的客户测评
	 */
	@RequestMapping(value = "get/customer/risk_evaluation_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取分析测评结果(客户id)")
	public Result<PaginationSupport<CustomerRiskPageResDto>> getCustomerRiskPage(@ModelAttribute CustomerRiskPageReqDto reqDto) throws BaseException {
		
		return questionService.getCustomerRiskPage(reqDto);
	}

	
	@RequestMapping(value = "get/current/customer/risk_evaluation_result", method = RequestMethod.GET)
	@ApiOperation(value = "获取分析测评结果(用户客户 id)")
	public Result<List<CustomerRiskQuestionResDto>> getCurrentCustomerRiskPage() throws BaseException {
		 HeaderUser result = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		List<CustomerRiskQuestionResDto> list = questionService.getRiskEvaluationByUserId(result.getUserId());
		return Result.newSuccessResult(list);
	}
	
}
