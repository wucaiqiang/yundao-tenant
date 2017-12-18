package com.yundao.tenant.service.question.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.question.CustomerRiskPageReqDto;
import com.yundao.tenant.dto.question.CustomerRiskPageResDto;
import com.yundao.tenant.dto.question.CustomerRiskQuestionResDto;
import com.yundao.tenant.dto.question.QuestionAndOptionDto;
import com.yundao.tenant.dto.question.QuestionAndOptionReqDto;
import com.yundao.tenant.dto.question.QuestionDto;
import com.yundao.tenant.dto.question.QuestionOptionDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.enums.question.QuestionTypeCodeEnum;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionAnswerMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionOptionMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionScoreMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionTypeMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcRiskRatingMapper;
import com.yundao.tenant.mapper.question.CcQuestionMapper;
import com.yundao.tenant.model.base.cc.BaseCcQuestion;
import com.yundao.tenant.model.base.cc.BaseCcQuestionAnswer;
import com.yundao.tenant.model.base.cc.BaseCcQuestionAnswerExample;
import com.yundao.tenant.model.base.cc.BaseCcQuestionExample;
import com.yundao.tenant.model.base.cc.BaseCcQuestionOption;
import com.yundao.tenant.model.base.cc.BaseCcQuestionOptionExample;
import com.yundao.tenant.model.base.cc.BaseCcQuestionScore;
import com.yundao.tenant.model.base.cc.BaseCcQuestionScoreExample;
import com.yundao.tenant.model.base.cc.BaseCcQuestionType;
import com.yundao.tenant.model.base.cc.BaseCcQuestionTypeExample;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import com.yundao.tenant.service.question.QuestionService;
import com.yundao.tenant.service.sale.leads.LeadsService;

@Service
public class QuestionServiceImpl extends AbstractService implements QuestionService {

	@Autowired
	private BaseCcQuestionTypeMapper baseCcQuestionTypeMapper;
	@Autowired
	private BaseCcQuestionMapper baseCcQuestionMapper;
	@Autowired
	private BaseCcQuestionOptionMapper baseCcQuestionOptionMapper;
	@Autowired
	private BaseCcRiskRatingMapper baseCcRiskRatingMapper;
	@Autowired
	private BaseCcQuestionScoreMapper baseCcQuestionScoreMapper;
	@Autowired
	private BaseCcQuestionAnswerMapper baseCcQuestionAnswerMapper;

	@Autowired
	private CcQuestionMapper ccQuestionMapper;
	@Autowired
	private LeadsService leadsService;

	@Override
	public List<QuestionDto> getQuestions(String typeCode) throws BaseException {
		// 查询题目类型
		BaseCcQuestionTypeExample questionTypeExample = new BaseCcQuestionTypeExample();
		questionTypeExample.createCriteria().andCodeEqualTo(typeCode);
		BaseCcQuestionType type = baseCcQuestionTypeMapper.selectOne(questionTypeExample);

		// 查询题目
		BaseCcQuestionExample questionExample = new BaseCcQuestionExample();
		questionExample.createCriteria().andTypeIdEqualTo(type.getId());
		List<BaseCcQuestion> list = baseCcQuestionMapper.selectByExample(questionExample);
		if (BooleanUtils.isEmpty(list)) {
			return null;
		}

		List<Long> questionIds = new ArrayList<Long>();
		for (BaseCcQuestion question : list) {
			questionIds.add(question.getId());
		}

		// 查询题目选项
		BaseCcQuestionOptionExample questionOptionExample = new BaseCcQuestionOptionExample();
		questionOptionExample.createCriteria().andQuestionIdIn(questionIds);
		List<BaseCcQuestionOption> optionList = baseCcQuestionOptionMapper.selectByExample(questionOptionExample);

		// 组装数据
		List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
		for (BaseCcQuestion question : list) {
			QuestionDto questionDto = new QuestionDto();
			BeanUtils.copyProperties(question, questionDto);
			questionDtos.add(questionDto);
			List<QuestionOptionDto> questionOptionDtos = new ArrayList<QuestionOptionDto>();
			questionDto.setOptionList(questionOptionDtos);

			for (BaseCcQuestionOption questionOption : optionList) {
				if (!question.getId().equals(questionOption.getQuestionId())) {
					continue;
				}
				QuestionOptionDto questionOptionDto = new QuestionOptionDto();
				BeanUtils.copyProperties(questionOption, questionOptionDto);
				questionOptionDtos.add(questionOptionDto);
			}

		}

		return questionDtos;
	}

	/**
	 * 对投资者进行风险评测
	 * 
	 * @param userId
	 * @param questionOptionIds
	 * @return
	 * @throws BaseException
	 */
	public Result<RiskEvaluationResDto> doRiskEvaluation(List<QuestionAndOptionReqDto> questionAndOptionDtoList) throws BaseException {
		Long userId = this.getHeaderUserId();
		// 查询题目
		List<QuestionAndOptionDto> list = ccQuestionMapper
				.getQuestionAndOptionDtos(QuestionTypeCodeEnum.RISK.getCode());
		// 校验数据
		Result<Integer> result = checkRisk(list, questionAndOptionDtoList);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		// 获取所有选项
		List<Long> questionOptionIds = getQuestionOptionIds(questionAndOptionDtoList);
		// 保存数据
		saveAndUpdateScore(userId, list, questionOptionIds, QuestionTypeCodeEnum.RISK.getCode());
		return getRiskEvaluation(userId);
	}

	public List<Long> getQuestionOptionIds(List<QuestionAndOptionReqDto> questionAndOptionDtoList) {
		List<Long> questionOptionIds = new ArrayList<Long>();
		for (QuestionAndOptionReqDto dto : questionAndOptionDtoList) {
			if (BooleanUtils.isEmpty(dto.getOptionIdList())) {
				continue;
			}
			for (Long optionId : dto.getOptionIdList()) {
				questionOptionIds.add(optionId);
			}
		}
		return questionOptionIds;
	}

	/**
	 * 保存测评数据
	 * 
	 * @param userId
	 * @param list
	 * @param questionOptionIds
	 * @param questionTypeCode
	 */
	private void saveAndUpdateScore(Long userId, List<QuestionAndOptionDto> list, List<Long> questionOptionIds,
			String questionTypeCode) {
		// 保存分数
		Integer score = getScore(list, questionOptionIds);

		// 查询题目类型
		BaseCcQuestionTypeExample questionTypeExample = new BaseCcQuestionTypeExample();
		questionTypeExample.createCriteria().andCodeEqualTo(questionTypeCode);
		BaseCcQuestionType type = baseCcQuestionTypeMapper.selectOne(questionTypeExample);

		BaseCcQuestionScoreExample example = new BaseCcQuestionScoreExample();
		example.createCriteria().andUserAccountIdEqualTo(userId).andQuestionTypeIdEqualTo(type.getId());
		BaseCcQuestionScore base = baseCcQuestionScoreMapper.selectOne(example);

		if (base != null) {
			baseCcQuestionScoreMapper.deleteByPrimaryKey(base.getId());

			BaseCcQuestionAnswerExample answerExample = new BaseCcQuestionAnswerExample();
			answerExample.createCriteria().andScoreIdEqualTo(base.getId());
			baseCcQuestionAnswerMapper.deleteByExample(answerExample);
		}

		BaseCcQuestionScore baseScore = new BaseCcQuestionScore();
		baseScore.setCreateDate(new Date());
		baseScore.setCreateUserId(userId);
		baseScore.setGrade(score);
		baseScore.setQuestionTypeId(type.getId());
		baseScore.setTenantId(this.getHeaderTenantId());
		baseScore.setUserAccountId(userId);
		baseScore.setIsDelete(0);
		baseCcQuestionScoreMapper.insert(baseScore);

		for (Long questionOptionId : questionOptionIds) {
			for (QuestionAndOptionDto dto : list) {
				if (questionOptionId.equals(dto.getOptionId())) {
					BaseCcQuestionAnswer record = new BaseCcQuestionAnswer();
					record.setUpdateDate(new Date());
					record.setCreateUserId(userId);
					record.setQuestionId(dto.getId());
					record.setOptionId(dto.getOptionId());
					record.setIsDelete(0);
					record.setScoreId(baseScore.getId());
					baseScore.setTenantId(this.getHeaderTenantId());
					baseCcQuestionAnswerMapper.insert(record);
				}
			}
		}
	}

	/**
	 * 查询投资者的风险评测结果
	 * 
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	public Result<RiskEvaluationResDto> getRiskEvaluation(Long userId) throws BaseException {
		if(userId == null){
			return Result.newFailureResult(CodeConstant.CODE_1200014);
		}
		// 查询题目类型
		BaseCcQuestionTypeExample questionTypeExample = new BaseCcQuestionTypeExample();
		questionTypeExample.createCriteria().andCodeEqualTo(QuestionTypeCodeEnum.RISK.getCode());
		BaseCcQuestionType type = baseCcQuestionTypeMapper.selectOne(questionTypeExample);

		BaseCcQuestionScoreExample example = new BaseCcQuestionScoreExample();
		example.createCriteria().andUserAccountIdEqualTo(userId).andQuestionTypeIdEqualTo(type.getId());
		BaseCcQuestionScore base = baseCcQuestionScoreMapper.selectOne(example);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200123);
		}
		
		BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
		riskExample.createCriteria().andGradeMaxGreaterThanOrEqualTo(base.getGrade())
		.andGradeMinLessThanOrEqualTo(base.getGrade());
		BaseCcRiskRating baseRisk = baseCcRiskRatingMapper.selectOne(riskExample);
		
		RiskEvaluationResDto dto = new RiskEvaluationResDto();
		dto.setUserId(userId);
		dto.setGrade(base.getGrade());
		dto.setRiskValue(baseRisk.getValue());
		dto.setRiskText(baseRisk.getLabel());
		dto.setEvaluationTime(base.getCreateDate());
		return Result.newSuccessResult(dto);
	}

	/**
	 * 检查答题选择是否正确
	 * 
	 * @param list
	 * @param questionOptionIds
	 * @return
	 */
	public Result<Integer> checkRisk(List<QuestionAndOptionDto> list,List<QuestionAndOptionReqDto> questionAndOptionDtoList) {
		if (BooleanUtils.isEmpty(list)) {
			return Result.newFailureResult(CodeConstant.CODE_1200118);
		}
		if (BooleanUtils.isEmpty(questionAndOptionDtoList)) {
			return Result.newFailureResult(CodeConstant.CODE_1200119);
		}
		
		for(QuestionAndOptionReqDto reqDto : questionAndOptionDtoList){
			if(BooleanUtils.isEmpty(reqDto.getOptionIdList())){
				return null;
			}
			boolean isRadio = false;
			for(Long optionId:reqDto.getOptionIdList()){
				boolean isExist = false;
				for(QuestionAndOptionDto dto:list){
					if(reqDto.getQuestionId().equals(dto.getId()) && optionId.equals(dto.getOptionId())){
						isExist = true;
						if(dto.getType() == 0){
							isRadio = true;
						}
						
					}
				}
				// 检查选项值错误
				if(!isExist){
					return Result.newFailureResult(CodeConstant.CODE_1200121);
				}
			}
			
			// 单选不能选择多个
			if(isRadio && reqDto.getOptionIdList().size() > 1){
				return Result.newFailureResult(CodeConstant.CODE_1200120);
			}
		}
		
		
		// 检查所有题目是否选择
		for(QuestionAndOptionDto dto:list){
			Boolean isExist = false;
			for(QuestionAndOptionReqDto reqDto : questionAndOptionDtoList){
				if(dto.getId().equals(reqDto.getQuestionId())){
					 isExist = true;
				}
			}
			
			if(!isExist){
				return Result.newFailureResult(CodeConstant.CODE_1200122);
			}
			
		}
		
		return Result.newSuccessResult(1);
	}

	/**
	 * 获取分数
	 * 
	 * @param list
	 * @param questionOptionIds
	 * @return
	 */
	public int getScore(List<QuestionAndOptionDto> list, List<Long> questionOptionIds) {
		if (BooleanUtils.isEmpty(list) || BooleanUtils.isEmpty(questionOptionIds)) {
			return 0;
		}
		int score = 0;
		for (Long questionOptionId : questionOptionIds) {
			for (QuestionAndOptionDto dto : list) {
				if (questionOptionId.equals(dto.getOptionId())) {
					score = score + dto.getGrade();
				}
			}
		}
		return score;
	}
	
	
    /**
     * 查询客户的风险评测结果
     * getRiskEvaluationByCustomerId:
     * @author: 欧阳利
     * @param userId  投资者id
     * @return
     * @throws BaseException
     * @description:
     */
    public List<CustomerRiskQuestionResDto> getRiskEvaluationByUserId(Long userId) throws BaseException{
    	 List<CustomerRiskQuestionResDto> list = ccQuestionMapper.getRiskEvaluationByUserId(userId,QuestionTypeCodeEnum.RISK.getCode());
    	 return list;
    }

    
    public Result<PaginationSupport<CustomerRiskPageResDto>> getCustomerRiskPage(CustomerRiskPageReqDto reqDto) throws BaseException{
    	PaginationSupport<CustomerRiskPageResDto> page = reqDto.getPaginationSupport();
    	int totalCount = ccQuestionMapper.getCustomerRiskPageCount(reqDto);
    	if(totalCount > 0){
    		List<CustomerRiskPageResDto> datas = ccQuestionMapper.getCustomerRiskPage(reqDto);
        	page.setDatas(datas);
        	setRiskText(datas);
        	setHasReservation(datas);
    	}
    	page.setTotalCount(totalCount);
    	return  Result.newSuccessResult(page);
    }
    
	
	private void setHasReservation(List<CustomerRiskPageResDto> datas)throws BaseException{
		if(BooleanUtils.isEmpty(datas)){
			return;
		}
		List<Long> customerIds = new ArrayList<Long>();
		for(CustomerRiskPageResDto dto:datas){
			customerIds.add(dto.getCustomerId());
			dto.setHasReservation(false);
		}
		
		List<Long> hasCustomerIds = leadsService.getHasConsultFpCustomerIds(customerIds);
		for(Long customerId:hasCustomerIds){
			for(CustomerRiskPageResDto dto:datas){
				if(customerId.equals(dto.getCustomerId())){
					dto.setHasReservation(true);
				}
			}
		}
	
	}
	
	
    
	/**
	 * 设置风险类型
	 * setRiskText:
	 * @author: 欧阳利
	 * @param datas
	 * @description:
	 */
	private void setRiskText(List<CustomerRiskPageResDto> datas){
		if(BooleanUtils.isEmpty(datas)){
			return;
		}
		BaseCcRiskRatingExample example = new BaseCcRiskRatingExample();
		List<BaseCcRiskRating> list = baseCcRiskRatingMapper.selectByExample(example);
		if(BooleanUtils.isEmpty(list)){
			return;
		}
		
		for(CustomerRiskPageResDto dto : datas){
			for(BaseCcRiskRating risk : list){
				if(dto.getGrade() != null && dto.getGrade() > 0){
					if(dto.getGrade()>=risk.getGradeMin() && dto.getGrade() <=risk.getGradeMax()){
						dto.setRiskText(risk.getLabel());
						dto.setRiskValue(risk.getValue());
					}	
				}
				
			}
		}
		
	}
}
