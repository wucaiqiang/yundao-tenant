

package com.yundao.tenant.service.report.customer;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportReqDto;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportResDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailReqDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailResDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankReqDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午9:48:00 
 * @author   欧阳利
 * @version   
 */
public interface CustomerAddService {
     
	/**
	 * 查询部门添加客户报表
	 * getDepartmentAddCustomerReport:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	 public Result<List<DepartAddCustReportResDto>> getDepartmentAddCustomerReport(DepartAddCustReportReqDto reqDto)throws BaseException;
	 
	 
	 
	 
	 /**
	  * 用户新增客户排名
	  * getUserAddCustomerRank:
	  * @author: 欧阳利
	  * @param reqDto
	  * @return
	  * @throws BaseException
	  * @description:
	  */
	 public Result<PaginationSupport<UserAddCustomerRankResDto>> getUserAddCustomerRank(UserAddCustomerRankReqDto reqDto)throws BaseException;
	 
	 
	 /**
	  * 部门或者用户添加客户详情
	  * getDepartmentAndUserAddCustomerDetail:
	  * @author: 欧阳利
	  * @param reqDto
	  * @return
	  * @throws BaseException
	  * @description:
	  */
	 public Result<DepartmentAndUserDetailResDto> getDepartmentAndUserAddCustomerDetail(DepartmentAndUserDetailReqDto reqDto)throws Exception;
	 
}

