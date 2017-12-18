
package com.yundao.tenant.service.sale.declaration;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;

/**
 * Function: Reason: Date: 2017年9月5日 下午5:56:45
 * 
 * @author wucq
 * @version
 */
public interface DeclarationBankRelService {
	public BaseCustomerBank getCustomerBankByDeclarationId(Long declarationId) throws BaseException;
}
