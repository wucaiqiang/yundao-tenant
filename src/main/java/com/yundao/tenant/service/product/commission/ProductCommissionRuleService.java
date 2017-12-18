package com.yundao.tenant.service.product.commission;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.add.ProductCommissionRuleDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleUpdateDto;

public interface ProductCommissionRuleService {
	/**
	 * 添加产品佣金信
	 * @param commissionDtos
	 * @param productId
	 * @return
	 */
	public Result<Integer> saveCommissionDtos(List<ProductCommissionRuleDto> commissionDtos,Long productId)throws Exception;
	
	/**
	 * 对象转换
	 * @param commissionDtos
	 * @return
	 * @throws BaseException
	 */
	public List<ProductCommissionRuleDto> getProductCommissionRuleDto(String commissionDtos) throws BaseException;
	
	
	/**
	 * 对象转换
	 * @param commissionDtos
	 * @return
	 * @throws BaseException
	 */
	public List<ProductCommissionRuleUpdateDto> getProductCommissionRuleUpdateDtos(String commissionDtos) throws BaseException;
	
	
	/**
	 * 修改产品佣金规则列表
	 * @param commissionDtos
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> updateCommissionDtos(List<ProductCommissionRuleUpdateDto>  commissionDtos,Long productId)throws Exception;
	

	/**
	 * 获取产品的佣金信息
	 * @param productId
	 * @return
	 * @throws Exception
	 */
    public List<ProductCommissionRuleDetailDto> getCommissionRuleDetailDtos(Long productId)throws Exception;
    
    /**
     * 检查佣金规则for add
     * @param commissionDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkCommissionRuleAddDtos(List<ProductCommissionRuleDto> commissionDtos,Integer isScale, Double  productScale) throws BaseException;
    
    /**
     * 检查佣金规则for update
     * @param commissionDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkCommissionRuleUpdateDtos(List<ProductCommissionRuleUpdateDto> commissionDtos,Integer isScale, Double  productScale) throws BaseException;
}
