

package com.yundao.tenant.service.field;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseNumberConfig;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月3日 下午7:50:57 
 * @author   wucq
 * @version   
 */
public interface NumberConfigService {
	public BaseNumberConfig selectByFieldId(Long fieldId)throws BaseException;
}

