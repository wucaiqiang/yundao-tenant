

package com.yundao.tenant.service.aa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.dto.aa.plan.PieDto;
import com.yundao.tenant.dto.aa.plan.PlanDescriptionDto;
import com.yundao.tenant.dto.customer.customer.CustomerDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.mapper.base.aa.BaseAaProductTypeMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaProductTypeRiskRatingMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaQuestionScoreMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionTypeMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcRiskRatingMapper;
import com.yundao.tenant.model.base.aa.BaseAaProductType;
import com.yundao.tenant.model.base.aa.BaseAaProductTypeExample;
import com.yundao.tenant.model.base.aa.BaseAaProductTypeRiskRating;
import com.yundao.tenant.model.base.aa.BaseAaProductTypeRiskRatingExample;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScore;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import com.yundao.tenant.service.aa.AssetPlanService;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.question.QuestionService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午5:50:19 
 * @author   欧阳利
 * @version   
 */
@Service
public class AssetPlanServiceImpl implements AssetPlanService {
	
	@Autowired
	BaseCcRiskRatingMapper baseCcRiskRatingMapper;
	@Autowired
	BaseAaQuestionScoreMapper baseAaQuestionScoreMapper;
	@Autowired
	BaseCcQuestionTypeMapper baseCcQuestionTypeMapper;
	@Autowired
	UserService userService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BaseAaProductTypeRiskRatingMapper baseAaProductTypeRiskRatingMapper;
	@Autowired
	BaseAaProductTypeMapper baseAaProductTypeMapper;	
	@Autowired
	UserDetailService userDetailService;
	@Autowired
	CcCustomerUserRelService ccCustomerUserRelService;
	@Autowired
	QuestionService questionService;
	
	
	/**
	 * 通过资产配置id获取方案说明
	 * getPlanDescriptionDto:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PlanDescriptionDto> getPlanDescriptionDto(Integer riskValue)throws BaseException{
		BaseCcRiskRating baseRisk =  null;
		BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
		riskExample.createCriteria().andValueEqualTo(riskValue);
		baseRisk = baseCcRiskRatingMapper.selectOne(riskExample);
		
		PlanDescriptionDto dto = new PlanDescriptionDto();
		BeanUtils.copyProperties(baseRisk, dto);
		dto.setRiskText(baseRisk.getLabel());
		dto.setRiskValue(baseRisk.getValue());
		return Result.newSuccessResult(dto);
	}
	
	
	/**
	 * 获取配置方案
	 * getAssetAllocationDtoToUser:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<AssetPlanDto> getAssetAllocationDtoToUser(Long id)throws BaseException{
		AssetPlanDto dto = new AssetPlanDto();
		BaseAaQuestionScore baseAaQuestionScore = baseAaQuestionScoreMapper.selectByPrimaryKey(id);
		if(baseAaQuestionScore == null){
			return Result.newFailureResult(Code1200000.CODE_1200182);
		}
		// 设置风险类型信息
		BaseCcRiskRating baseRisk  = null;
		if(baseAaQuestionScore != null){
			BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
			riskExample.createCriteria().andGradeMaxGreaterThanOrEqualTo(baseAaQuestionScore.getGrade())
			.andGradeMinLessThanOrEqualTo(baseAaQuestionScore.getGrade());
			baseRisk  = baseCcRiskRatingMapper.selectOne(riskExample);
			BeanUtils.copyProperties(baseRisk, dto);
			dto.setRiskText(baseRisk.getLabel());
			dto.setRiskValue(baseRisk.getValue());
		}
		UserInfoDto userInfo = userService.getUserInfo(baseAaQuestionScore.getUserId());
		CustomerDto customerDto = customerService.get(baseAaQuestionScore.getCustomerId()).getResult();
		dto.setId(id);
		dto.setUserId(baseAaQuestionScore.getUserId());
		dto.setCustomerId(baseAaQuestionScore.getCustomerId());
		dto.setCustomerName(customerDto.getName());
		dto.setUsername(userDetailService.getUserRealName(baseAaQuestionScore.getUserId()));
		dto.setUserMobile(userInfo.getMobile());
		dto.setPie(getPieDtos(baseRisk.getId()));
		return Result.newSuccessResult(dto);
	}
	
	/**
	 * 通过风险类型id查询资产配置饼图
	 * getPieDtos:
	 * @author: 欧阳利
	 * @param riskId
	 * @return
	 * @description:
	 */
	private List<PieDto> getPieDtos(Long riskId){
		BaseAaProductTypeRiskRatingExample example = new BaseAaProductTypeRiskRatingExample();
		example.createCriteria().andRiskRatingIdEqualTo(riskId);
		List<BaseAaProductTypeRiskRating> list = baseAaProductTypeRiskRatingMapper.selectByExample(example);
		
		BaseAaProductTypeExample typeExample = new BaseAaProductTypeExample();
		List<BaseAaProductType> ProductTypes = baseAaProductTypeMapper.selectByExample(typeExample);
		
		List<PieDto> dtos = new ArrayList<PieDto>();
		if(!BooleanUtils.isEmpty(list)){
			for(BaseAaProductTypeRiskRating risk : list){
				PieDto dto = new PieDto();
				dtos.add(dto);
				dto.setInvestmentRatio(risk.getRate());
				if(!BooleanUtils.isEmpty(ProductTypes)){
					for(BaseAaProductType type: ProductTypes){
						if(risk.getProductTypeId().equals(type.getId())){
							dto.setClassCodeName(type.getName());
						}
					}
				}
			}
		}
		return dtos;
	}
	
	
	
	
	/**
	 * 获取方案说明
	 */
	public Result<PlanDescriptionDto> getCustomerPlanDescriptionDto(Long customerId)throws BaseException{
		Long userId = ccCustomerUserRelService.getUserIdByCustomerId(customerId);
        if(userId == null){
			return Result.newFailureResult(Code1200000.CODE_1200188);
		}
		Result<RiskEvaluationResDto> result = questionService.getRiskEvaluation(userId);
		
		if(!result.getSuccess()){
			return Result.newFailureResult(result.getCode());
		}
		
		BaseCcRiskRating baseRisk =  null;
		if(result != null){
			BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
			riskExample.createCriteria().andGradeMaxGreaterThanOrEqualTo(result.getResult().getGrade())
			.andGradeMinLessThanOrEqualTo(result.getResult().getGrade());
			baseRisk = baseCcRiskRatingMapper.selectOne(riskExample);
		}
		PlanDescriptionDto dto = new PlanDescriptionDto();
		BeanUtils.copyProperties(baseRisk, dto);
		dto.setRiskText(baseRisk.getLabel());
		dto.setRiskValue(baseRisk.getValue());
		return Result.newSuccessResult(dto);
	}
	
	
	/**
	 * 获取配置方案
	 */
	public Result<AssetPlanDto> getCustomerPlan(Long customerId)throws BaseException{
		Long userId = ccCustomerUserRelService.getUserIdByCustomerId(customerId);
		if(userId == null){
			return Result.newFailureResult(Code1200000.CODE_1200188);
		}
		Result<RiskEvaluationResDto> result = questionService.getRiskEvaluation(userId);
		if(!result.getSuccess()){
			return Result.newFailureResult(result.getCode());
		}
		// 设置风险类型信息
		BaseCcRiskRating baseRisk  = null;
		BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
		riskExample.createCriteria().andGradeMaxGreaterThanOrEqualTo(result.getResult().getGrade())
		.andGradeMinLessThanOrEqualTo(result.getResult().getGrade());
		baseRisk  = baseCcRiskRatingMapper.selectOne(riskExample);
		
		AssetPlanDto dto = new AssetPlanDto();
		BeanUtils.copyProperties(baseRisk, dto);
		dto.setRiskText(baseRisk.getLabel());
		dto.setRiskValue(baseRisk.getValue());
		
		CustomerDto customerDto = customerService.get(customerId).getResult();
		dto.setCustomerId(customerId);
		dto.setCustomerName(customerDto.getName());
		dto.setPie(getPieDtos(baseRisk.getId()));
		return Result.newSuccessResult(dto);
	}
}

