

package com.yundao.tenant.service.report.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.report.declaration.DepartUserDeclarationReportReqDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationReportDetailDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月4日 上午9:25:42 
 * @author   欧阳利
 * @version   
 */
public interface DepartmentUserReportDetailService {

	
	public Result<DepartmentUserDeclarationReportDetailDto> getDepartmentOrUserDetailDto(DepartUserDeclarationReportReqDto reqDto)throws Exception;

	/**
	 * 查询用户报单排名
	 * @param departmentId
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	public Result<PaginationSupport<UserDeclarationRankResDto>> getUserRankPage(UserDeclarationRankReqDto reqDto)throws BaseException;

}

