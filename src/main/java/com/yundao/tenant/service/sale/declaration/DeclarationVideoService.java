

package com.yundao.tenant.service.sale.declaration;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.sale.BaseDeclaration;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月29日 下午5:53:31 
 * @author   欧阳利
 * @version   
 */
public interface DeclarationVideoService{
	
	
	/**
	 * 修改合规双录
	 * addComplianceRecord:
	 * @author: 欧阳利
	 * @return
	 * @description:
	 */
    public Result<Integer> updateComplianceRecord(String compliance, BaseDeclaration declaration) throws BaseException;
	

    
    /**
     * 获取合规双录视频id集合
     * getComplianceRecordVideoId:
     * @author: 欧阳利
     * @param declarationId
     * @return
     * @description:
     */
    public List<Long> getComplianceRecordVideoId(Long declarationId);
}

