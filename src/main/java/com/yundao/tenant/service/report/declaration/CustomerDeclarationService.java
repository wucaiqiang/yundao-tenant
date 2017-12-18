

package com.yundao.tenant.service.report.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午11:08:32 
 * @author   欧阳利
 * @version   
 */
public interface CustomerDeclarationService {

	/**
	 * 获取客户报单排名
	 * getCustomerRankPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<DeclarationRankResDto>> getCustomerRankPage(DeclarationRankReqDto reqDto)throws BaseException;
	
	
	/**
	 * 查询客户的报单详情
	 * getCustomerDeclarationPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<DepartmentUserDeclarationDto>> getCustomerDeclarationPage(CustomerDeclarationReqDto reqDto)throws BaseException;
}

