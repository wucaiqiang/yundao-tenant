
package com.yundao.tenant.service.sale.declaration;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;

/**
 * Function: Reason: Date: 2017年9月5日 下午7:41:54
 * 
 * @author wucq
 * @version
 */
public interface DeclarationCredentialsRelService {
	public BaseCustomerCredentials getCustomerCredentialsByDeclarationId(Long declarationId) throws BaseException;

	public Integer add(BaseCustomerCredentials customerCredentials, Long declarationId) throws BaseException;
}
