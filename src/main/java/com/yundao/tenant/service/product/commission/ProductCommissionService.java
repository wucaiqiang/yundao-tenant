package com.yundao.tenant.service.product.commission;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.product.add.ProductCommissionDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionUpdateDto;
import com.yundao.tenant.model.base.product.BaseProductCommission;

/**
 * 产品佣金管理
 * 
 * @author 欧阳利
 * 2017年7月7日
 */
public interface ProductCommissionService {
	
	/**
	 * 添加佣金列表
	 * @param dtos
	 * @param commissionRuleId
	 * @return
	 */
    public Result<Integer> addProductCommissionUpdateDtos(List<ProductCommissionUpdateDto> dtos, Long commissionRuleId)throws Exception;
	
	/**
	 * 添加佣金列表
	 * @param dtos
	 * @param commissionRuleId
	 * @return
	 */
    public Result<Integer> addProductCommissionDtos(List<ProductCommissionDto> dtos, Long commissionRuleId)throws Exception;
    
    /**
     * 通过佣金规则id集合删除佣金
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> deleteCommissionRuleIds(List<Long> ids)throws Exception;
    
    
    /**
     * 更新佣金详情列表
     * @param commissionDtos
     * @param commissionRuleId
     * @return
     * @throws Exception
     */
    public Result<Integer>  updateProductCommissionUpdateDto( List<ProductCommissionUpdateDto>  commissionDtos,Long commissionRuleId)throws Exception;

    /**
     * 获取产品佣金详情
     * @param commissionRuleIds
     * @return
     * @throws Exception
     */
    public List<BaseProductCommission> getBaseProductCommissions(List<Long> commissionRuleIds)throws Exception;

}
