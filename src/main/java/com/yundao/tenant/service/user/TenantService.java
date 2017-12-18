

package com.yundao.tenant.service.user;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.tenant.TenantDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月21日 下午2:26:23 
 * @author   wucq
 * @version   
 */
public interface TenantService {
   public TenantDto get()throws BaseException;
}

