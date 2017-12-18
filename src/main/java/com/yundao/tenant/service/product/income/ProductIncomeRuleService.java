package com.yundao.tenant.service.product.income;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.product.income.IncomeRuleUpdateDto;

public interface ProductIncomeRuleService {
	/**
	 * 添加收益
	 * @param productIncomeRuleDtos
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> saveProductIncomeRuleDtos(List<ProductIncomeRuleDto> productIncomeRuleDtos,Long productId)throws Exception;
	
	/**
	 * 对象转换
	 * @param productIncomeRuleDtos
	 * @return
	 * @throws BaseException
	 */
	public List<ProductIncomeRuleDto> getProductIncomeRuleDto(String productIncomeRuleDtos) throws BaseException;
	
	
	/**
	 * 获取更新收益规则
	 * @param productIncomeRuleDtos
	 * @return
	 * @throws BaseException
	 */
	public List<IncomeRuleUpdateDto> getIncomeRuleUpdateDtos(String productIncomeRuleDtos) throws BaseException;
	/**
	 * 批量获取收益规则
	 * getInComeRuleByProductIds:
	 * @author: wucq
	 * @param productIds
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<ProductIncomeRuleDto> getInComeRuleByProductIds(String productIds)throws BaseException;
	
	
	/**
	 * 修改产品收益
	 * @param productIncomeRuleDtos
	 * @param productId
	 * @return
	 * @throws BaseException
	 */
	public Result<Integer> updateIncomeRule(List<IncomeRuleUpdateDto> productIncomeRuleDtos,Long productId) throws Exception;
	
	
	/**
	 * 通过产品id获取收益信息
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<IncomeRuleDetailDto> getIncomeRuleDetailDtos(Long productId) throws Exception;
	
	/**
	 * 检查收益规则 for add
	 * @param productIncomeRuleDtos
	 * @return
	 * @throws BaseException
	 */
	public Result<Boolean> checkIncomeRuleAddDtos(List<ProductIncomeRuleDto> productIncomeRuleDtos,Integer isScale, Double  productScale)throws BaseException;
	
	
	/**
	 * 检查收益规则 for update
	 * @param productIncomeRuleDtos
	 * @return
	 * @throws BaseException
	 */
	public Result<Boolean> checkIncomeRuleUpdateDtos(List<IncomeRuleUpdateDto> productIncomeRuleDtos,Integer isScale, Double  productScale)throws BaseException;
}
