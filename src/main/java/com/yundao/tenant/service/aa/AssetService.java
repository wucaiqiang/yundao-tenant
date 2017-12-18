

package com.yundao.tenant.service.aa;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.aa.asset.AddAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageResDto;
import com.yundao.tenant.dto.aa.asset.UpdateAssetAllocationReqDto;
import com.yundao.tenant.dto.aa.plan.AssetPlanDto;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScore;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午1:57:16 
 * @author   欧阳利
 * @version   
 */
public interface AssetService {

    /**
     * 添加资产配置
     * addAssetAllocation:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<AssetPlanDto> addAssetAllocation(AddAssetAllocationReqDto reqDto)throws BaseException;
    
    /**
     * 修改资产配置(重新做题)
     * updateAssetAllocation:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<AssetPlanDto> updateAssetAllocation(UpdateAssetAllocationReqDto reqDto)throws BaseException;
	
	
	/**
	 *  通过测评id查询测评
	 * getBaseAaQuestionScore:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public BaseAaQuestionScore getBaseAaQuestionScore(Long id)throws BaseException;

	
    /**
     * 分页查询资产配置(历史配置)
     * getAssetAllocationPage:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
	public Result<PaginationSupport<AssetAllocationPageResDto>> getAssetAllocationPage( AssetAllocationPageReqDto reqDto)throws BaseException;
    
    /**
     * 删除资产配置
     * delete:
     * @author: 欧阳利
     * @param ids
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<Integer> delete(List<Long> ids)throws BaseException;
	
}

