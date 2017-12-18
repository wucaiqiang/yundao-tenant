package com.yundao.tenant.service.product.income;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.product.add.ProductIncomeDto;
import com.yundao.tenant.dto.product.income.ProductIncomeUpdateDto;
import com.yundao.tenant.model.base.product.BaseProductIncome;

public interface ProductIncomeService {
	
	/**
	 * 删除产品收益
	 * @param incomeRuleIds
	 * @return
	 */
    public Result<Integer> deleteIncome(List<Long> incomeRuleIds);
    
    
    /**
     * 修改收益规则详情列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> updateIncome(List<ProductIncomeUpdateDto> dtos,Long incomeRuleId);
    
    /**
     * 添加收益列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> addIncome(List<ProductIncomeUpdateDto> dtos,Long incomeRuleId);
    
    /**
     * 添加收益列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> addIncome2(List<ProductIncomeDto> dtos,Long incomeRuleId);
    
    /**
     * 通过收益规则查询收益详情
     * @param incomeRuleIds
     * @return
     */
    public List<BaseProductIncome> getBaseProductIncomes(List<Long> incomeRuleIds);
    
    
    
}
