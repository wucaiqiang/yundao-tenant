

package com.yundao.tenant.service.aa.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.aa.asset.AddAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageResDto;
import com.yundao.tenant.dto.aa.asset.UpdateAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.dto.question.QuestionAndOptionDto;
import com.yundao.tenant.enums.question.QuestionTypeCodeEnum;
import com.yundao.tenant.mapper.aa.AaQuestionScoreMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaProductRefMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaQuestionAnswerMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaQuestionScoreMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcQuestionTypeMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcRiskRatingMapper;
import com.yundao.tenant.mapper.question.CcQuestionMapper;
import com.yundao.tenant.model.base.aa.BaseAaProductRef;
import com.yundao.tenant.model.base.aa.BaseAaProductRefExample;
import com.yundao.tenant.model.base.aa.BaseAaQuestionAnswer;
import com.yundao.tenant.model.base.aa.BaseAaQuestionAnswerExample;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScore;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScoreExample;
import com.yundao.tenant.model.base.cc.BaseCcQuestionType;
import com.yundao.tenant.model.base.cc.BaseCcQuestionTypeExample;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import com.yundao.tenant.service.aa.AssetPlanService;
import com.yundao.tenant.service.aa.AssetService;
import com.yundao.tenant.service.question.QuestionService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午1:58:52 
 * @author   欧阳利
 * @version   
 */
@Service
public class AssetServiceImpl extends AbstractService implements AssetService {
   
	@Autowired
	CcQuestionMapper ccQuestionMapper;
	@Autowired
	BaseCcQuestionTypeMapper baseCcQuestionTypeMapper;
	@Autowired
	QuestionService questionService;
	@Autowired
	BaseAaQuestionScoreMapper baseQuestionScoreMapper;
	@Autowired
	BaseAaQuestionAnswerMapper baseQuestionAnswerMapper;
	@Autowired
	AssetPlanService assetPlanService;
	@Autowired
	BaseAaProductRefMapper baseProductRefMapper;
	@Autowired
	AaQuestionScoreMapper aaQuestionScoreMapper;
	@Autowired
	BaseCcRiskRatingMapper baseCcRiskRatingMapper;
	
	/**
     * 添加资产配置
     * addAssetAllocation:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<AssetPlanDto> addAssetAllocation(AddAssetAllocationReqDto reqDto)throws BaseException{
		// 查询题目
		List<QuestionAndOptionDto> list = ccQuestionMapper
				.getQuestionAndOptionDtos(QuestionTypeCodeEnum.RISK.getCode());
		
		// 校验数据
		Result<Integer> result = questionService.checkRisk(list, reqDto.getQuestionAndOptionDtoList());
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		// 获取所有选项
		List<Long> questionOptionIds = questionService.getQuestionOptionIds(reqDto.getQuestionAndOptionDtoList());
		// 保存数据
		Long id = saveScore(reqDto.getCustomerId(), list, questionOptionIds, QuestionTypeCodeEnum.RISK.getCode());
		return assetPlanService.getAssetAllocationDtoToUser(id);
	}
	
	
	/**
	 *  通过测评id查询测评
	 * getBaseAaQuestionScore:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public BaseAaQuestionScore getBaseAaQuestionScore(Long id)throws BaseException{
		if(id == null){
			return null;
		}
		return baseQuestionScoreMapper.selectByPrimaryKey(id);
	}
	
	
	
	
	/**
	 * 保存测评数据
	 * 
	 * @param userId
	 * @param list
	 * @param questionOptionIds
	 * @param questionTypeCode
	 */
	private Long saveScore(Long customerId, List<QuestionAndOptionDto> list, List<Long> questionOptionIds,
			String questionTypeCode) {
		// 保存分数
		Integer score = questionService.getScore(list, questionOptionIds);

		// 查询题目类型
		BaseCcQuestionTypeExample questionTypeExample = new BaseCcQuestionTypeExample();
		questionTypeExample.createCriteria().andCodeEqualTo(questionTypeCode);
		BaseCcQuestionType type = baseCcQuestionTypeMapper.selectOne(questionTypeExample);

		BaseAaQuestionScore baseScore = null;
		baseScore = new BaseAaQuestionScore();
		baseScore.setCreateDate(new Date());
		baseScore.setCreateUserId(this.getHeaderUserId());
		baseScore.setGrade(score);
		baseScore.setQuestionTypeId(type.getId());
		baseScore.setTenantId(this.getHeaderTenantId());
		baseScore.setUserId(this.getHeaderUserId());
		baseScore.setCustomerId(customerId);
		baseScore.setIsDelete(0);
		baseQuestionScoreMapper.insert(baseScore);

		for (Long questionOptionId : questionOptionIds) {
			for (QuestionAndOptionDto dto : list) {
				if (questionOptionId.equals(dto.getOptionId())) {
					BaseAaQuestionAnswer record = new BaseAaQuestionAnswer();
					record.setUpdateDate(new Date());
					record.setCreateUserId(this.getHeaderUserId());
					record.setQuestionId(dto.getId());
					record.setOptionId(dto.getOptionId());
					record.setIsDelete(0);
					record.setScoreId(baseScore.getId());
					record.setTenantId(this.getHeaderTenantId());
					baseQuestionAnswerMapper.insert(record);
				}
			}
		}
		
		return baseScore.getId();
	}
    
	
	/**
	 * 保存测评数据
	 * 
	 * @param userId
	 * @param list
	 * @param questionOptionIds
	 * @param questionTypeCode
	 */
	private void updateScore(Long id, List<QuestionAndOptionDto> list, List<Long> questionOptionIds) {
		// 保存分数
		Integer score = questionService.getScore(list, questionOptionIds);
		BaseAaQuestionScoreExample example = new BaseAaQuestionScoreExample();
		example.createCriteria().andIdEqualTo(id);
		BaseAaQuestionScore base = baseQuestionScoreMapper.selectOne(example);
		if (base == null) {
            return ;
		}
		BaseAaQuestionScore baseScore = new BaseAaQuestionScore();
		baseScore = new BaseAaQuestionScore();
		baseScore.setId(id);
		baseScore.setGrade(score);
		baseScore.setUpdateDate(new Date());
		baseScore.setUpdateUserId(this.getHeaderUserId());
		baseQuestionScoreMapper.updateByPrimaryKeySelective(baseScore);

		BaseAaQuestionAnswerExample answerExample = new BaseAaQuestionAnswerExample();
		answerExample.createCriteria().andScoreIdEqualTo(id);
		baseQuestionAnswerMapper.deleteByExample(answerExample);

		for (Long questionOptionId : questionOptionIds) {
			for (QuestionAndOptionDto dto : list) {
				if (questionOptionId.equals(dto.getOptionId())) {
					BaseAaQuestionAnswer record = new BaseAaQuestionAnswer();
					record.setUpdateDate(new Date());
					record.setCreateUserId(this.getHeaderUserId());
					record.setQuestionId(dto.getId());
					record.setOptionId(dto.getOptionId());
					record.setIsDelete(0);
					record.setScoreId(baseScore.getId());
					record.setTenantId(this.getHeaderTenantId());
					baseQuestionAnswerMapper.insert(record);
				}
			}
		}
	}
	
	
    /**
     * 修改资产配置(重新做题)
     * updateAssetAllocation:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<AssetPlanDto> updateAssetAllocation(UpdateAssetAllocationReqDto reqDto)throws BaseException{
		// 查询题目
		List<QuestionAndOptionDto> list = ccQuestionMapper
				.getQuestionAndOptionDtos(QuestionTypeCodeEnum.RISK.getCode());
		
		// 校验数据
		Result<Integer> result = questionService.checkRisk(list, reqDto.getQuestionAndOptionDtoList());
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		// 获取所有选项
		List<Long> questionOptionIds = questionService.getQuestionOptionIds(reqDto.getQuestionAndOptionDtoList());
		// 保存数据
		updateScore(reqDto.getId(), list, questionOptionIds);
		return assetPlanService.getAssetAllocationDtoToUser(reqDto.getId());
	}

	
    /**
     * 分页查询资产配置(历史配置)
     * getAssetAllocationPage:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<PaginationSupport<AssetAllocationPageResDto>> getAssetAllocationPage(AssetAllocationPageReqDto reqDto)throws BaseException{
		PaginationSupport<AssetAllocationPageResDto> page = reqDto.getPaginationSupport();
		int totalCount = aaQuestionScoreMapper.getPageCount(reqDto);
		if(totalCount > 0){
			List<AssetAllocationPageResDto> datas = aaQuestionScoreMapper.getPage(reqDto);
			page.setDatas(datas);
			// 设置产品id和个数
			setProductIdsAndCount(datas);
			// 设置风险信息
			setRiskText(datas);
		}
		page.setTotalCount(totalCount);
		return Result.newSuccessResult(page);
	}
    
	
	private void setProductIdsAndCount(List<AssetAllocationPageResDto> datas){
		if(BooleanUtils.isEmpty(datas)){
			return;
		}
		List<Long> ids = new ArrayList<Long>();
		for(AssetAllocationPageResDto dto : datas){
			ids.add(dto.getId());
		}
		BaseAaProductRefExample example = new BaseAaProductRefExample();
		example.createCriteria().andScoreIdIn(ids);
		List<BaseAaProductRef> list = baseProductRefMapper.selectByExample(example);
		for(AssetAllocationPageResDto dto : datas){
			List<Long> productIds = new ArrayList<Long>();
			if(!BooleanUtils.isEmpty(list)){
			    for(BaseAaProductRef base : list){
			    	if(dto.getId().equals(base.getScoreId())){
			    		productIds.add(base.getProductId());
			    	}
			    }	
			}
			dto.setProductIds(productIds);
			dto.setProductCount(productIds.size());
		}
		
		
	}
	
	
	private void setRiskText(List<AssetAllocationPageResDto> datas){
		if(BooleanUtils.isEmpty(datas)){
			return;
		}
		BaseCcRiskRatingExample example = new BaseCcRiskRatingExample();
		List<BaseCcRiskRating> list = baseCcRiskRatingMapper.selectByExample(example);
		if(BooleanUtils.isEmpty(list)){
			return;
		}
		
		for(AssetAllocationPageResDto dto : datas){
			for(BaseCcRiskRating risk : list){
				if(dto.getGrade()>=risk.getGradeMin() && dto.getGrade() <=risk.getGradeMax()){
					dto.setRiskText(risk.getLabel());
					dto.setRiskValue(risk.getValue());
				}
			}
		}
		
	}
	
	
    /**
     * 删除资产配置
     * delete:
     * @author: 欧阳利
     * @param ids
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<Integer> delete(List<Long> ids)throws BaseException{
    	if(BooleanUtils.isEmpty(ids)){
    		return Result.newSuccessResult(0);
    	}
    	
    	BaseAaQuestionScoreExample exampleCondition = new BaseAaQuestionScoreExample();
    	exampleCondition.createCriteria().andIdIn(ids).andUserIdEqualTo(this.getHeaderUserId());
    	List<BaseAaQuestionScore> list = baseQuestionScoreMapper.selectByExample(exampleCondition);
    	if(BooleanUtils.isEmpty(list)){
    		return Result.newSuccessResult(0);
    	}
    	
    	if(list.size() != ids.size()){
    		return Result.newSuccessResult(0);
    	}
    	
    	//  删除测评
		BaseAaQuestionScoreExample example = new BaseAaQuestionScoreExample();
		example.createCriteria().andIdIn(ids);
		baseQuestionScoreMapper.deleteByExample(example);
		
		// 删除选题
        BaseAaQuestionAnswerExample answerExample = new BaseAaQuestionAnswerExample();
        answerExample.createCriteria().andScoreIdIn(ids);
		baseQuestionAnswerMapper.deleteByExample(answerExample);
		
		
		// 删除配置的产品
		BaseAaProductRefExample productExample = new BaseAaProductRefExample();
		answerExample.createCriteria().andScoreIdIn(ids);
		baseProductRefMapper.deleteByExample(productExample);
		return Result.newSuccessResult(1);
	}
}

