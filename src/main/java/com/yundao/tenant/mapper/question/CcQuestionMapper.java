package com.yundao.tenant.mapper.question;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.question.CustomerRiskPageReqDto;
import com.yundao.tenant.dto.question.CustomerRiskPageResDto;
import com.yundao.tenant.dto.question.CustomerRiskQuestionResDto;
import com.yundao.tenant.dto.question.QuestionAndOptionDto;

public interface CcQuestionMapper {
	
    /**
     * 获取题目和选项
     * @param typeCode
     * @return
     * @throws BaseException
     */
    public List<QuestionAndOptionDto> getQuestionAndOptionDtos(@Param("typeCode") String typeCode)throws BaseException;
    
    
    
    public List<CustomerRiskQuestionResDto> getRiskEvaluationByUserId(@Param("userId") Long userId,@Param("typeCode") String typeCode)throws BaseException;


    /**
     * 查询客户的风险信息
     */
    public List<CustomerRiskPageResDto> getCustomerRiskPage(CustomerRiskPageReqDto reqDto) throws BaseException;
    public int getCustomerRiskPageCount(CustomerRiskPageReqDto reqDto) throws BaseException;

}
