

package com.yundao.tenant.service.aa;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.dto.aa.plan.PlanDescriptionDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午1:57:46 
 * @author   欧阳利
 * @version   
 */
public interface AssetPlanService {

	
	/**
	 * 通过资产配置id获取方案说明
	 * getPlanDescriptionDto:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PlanDescriptionDto> getPlanDescriptionDto(Integer id)throws BaseException;
	
	
	/**
	 * 获取配置方案
	 * getAssetAllocationDtoToUser:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<AssetPlanDto> getAssetAllocationDtoToUser(Long id)throws BaseException;
	
	
	
	/**
	 * 获取方案说明
	 */
	public Result<PlanDescriptionDto> getCustomerPlanDescriptionDto(Long customerId)throws BaseException;
	
	
	/**
	 * 获取配置方案
	 */
	public Result<AssetPlanDto> getCustomerPlan(Long customerId)throws BaseException;
	
}

