package com.yundao.tenant.service.question;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.question.CustomerRiskPageReqDto;
import com.yundao.tenant.dto.question.CustomerRiskPageResDto;
import com.yundao.tenant.dto.question.CustomerRiskQuestionResDto;
import com.yundao.tenant.dto.question.QuestionAndOptionDto;
import com.yundao.tenant.dto.question.QuestionAndOptionReqDto;
import com.yundao.tenant.dto.question.QuestionDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;

public interface QuestionService {
    
	/**
	 * 获取题目列表
	 * @param typeCode  题目类型
	 * @return
	 * @throws Exception
	 */
	public List<QuestionDto>  getQuestions(String typeCode)throws BaseException;
	
	/**
	 * 对投资者进行风险评测
	 * @param userId
	 * @param questionOptionIds
	 * @return
	 * @throws BaseException
	 */
    public Result<RiskEvaluationResDto> doRiskEvaluation(List<QuestionAndOptionReqDto> QuestionAndOptionDtoList)throws BaseException;
    
    /**
     * 查询投资者的风险评测结果
     * @param userId
     * @return
     * @throws BaseException
     */
    public Result<RiskEvaluationResDto> getRiskEvaluation(Long userId)throws BaseException;
    
    
    /**
     * 查询客户的风险评测结果
     * getRiskEvaluationByCustomerId:
     * @author: 欧阳利
     * @param userId  投资者id
     * @return
     * @throws BaseException
     * @description:
     */
    public List<CustomerRiskQuestionResDto> getRiskEvaluationByUserId(Long userId) throws BaseException;
    
    
    /**
     * 答题检查
     * checkRisk:
     * @author: 欧阳利
     * @param list
     * @param questionAndOptionDtoList
     * @return
     * @description:
     */
    public Result<Integer> checkRisk(List<QuestionAndOptionDto> list,List<QuestionAndOptionReqDto> questionAndOptionDtoList);
    
    public List<Long> getQuestionOptionIds(List<QuestionAndOptionReqDto> questionAndOptionDtoList);
    
    public int getScore(List<QuestionAndOptionDto> list, List<Long> questionOptionIds);
    
    
    public Result<PaginationSupport<CustomerRiskPageResDto>> getCustomerRiskPage(CustomerRiskPageReqDto reqDto) throws BaseException;
    
}
