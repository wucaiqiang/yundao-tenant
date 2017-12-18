 

package com.yundao.tenant.mapper.report.customer;

import java.util.List;
import java.util.Map;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.report.customer.CustomerReportDto;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportResDto;
import com.yundao.tenant.dto.report.customer.DepartmentUserAddCustomerReportDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankReqDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankResDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportSelectDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:57:43 
 * @author   欧阳利
 * @version   
 */
public interface CustomerAddMapper {
	
	/**
	 * 查询部门添加客户信息
	 * getDepartmentAddCustomerReport:
	 * @author: 欧阳利
	 */
	public List<DepartAddCustReportResDto> getDepartmentAddCustomerReport(DepartmentReportSelectDto reqDto)throws BaseException;
	/**
	 * 查询部门的用户添加客户信息
	 * getDepartmentUserAddCustomerReport:
	 * @author: 欧阳利
	 */
	public List<DepartAddCustReportResDto>  getDepartmentUserAddCustomerReport(DepartmentReportSelectDto reqDto)throws BaseException;
	
	
	/**
	 * 分页查询添加的客户列表
	 * getDepartmentUserCustomerDtoPage:
	 * @author: 欧阳利
	 */
	public List<CustomerReportDto> getDepartmentUserCustomerDtoPage(Map<String, Object> param );
	public int getDepartmentUserCustomerDtoCount(Map<String, Object> param );
	
	
	
	/**
	 * 按月分组查询新增客户报表
	 * getDepartmentOrUserMonthGroupReport:
	 * @author: 欧阳利
	 */
	List<DepartmentUserAddCustomerReportDto> getDepartmentOrUserMonthGroupReport(Map<String, Object> param);
	
	/**
	 * 按天分组查询新增客户报表
	 * getDepartmentOrUserDayGroupReport:
	 * @author: 欧阳利
	 */
	List<DepartmentUserAddCustomerReportDto> getDepartmentOrUserDayGroupReport(Map<String, Object> param);
	
	
	
	
	/**
	 * 用户添加客户的排名
	 * getUserAddCustomerRankCount:
	 * @author: 欧阳利
	 */
	int getUserAddCustomerRankCount(UserAddCustomerRankReqDto reqDto);
	List<UserAddCustomerRankResDto> getUserAddCustomerRankPage(UserAddCustomerRankReqDto reqDto);
	
}

