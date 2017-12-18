

package com.yundao.tenant.mapper.report.declaration;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.report.declaration.DepartmentReportDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportSelectDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationDto;
import com.yundao.tenant.dto.report.declaration.IndexTopDto;
import com.yundao.tenant.dto.report.declaration.ReportDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankResDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationReqDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationUserDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 下午5:02:35 
 * @author   欧阳利
 * @version   
 */
public interface ReportDeclarationMapper {
	
	/**
	 * 查询大于month 月的公司业绩
	 * getIndexDeclarationDtos:
	 * @author: 欧阳利
	 * @param month
	 * @return
	 * @description:
	 */
	public List<ReportDto> getIndexReportDtos(@Param("month") String month);
	
	/**
	 * 查询某个月的业绩排名
	 * getIndexTopDtos:
	 * @author: 欧阳利
	 * @param count
	 * @param month
	 * @return
	 * @description:
	 */
	public List<IndexTopDto> getIndexTopDtos(@Param("count") int count, @Param("month") String month);
	
	
	List<DepartmentReportDto> getDepartmentReportDtos(DepartmentReportSelectDto dto);
	
	
	List<DepartmentReportDto> getDepartmentUserReportDtos(DepartmentReportSelectDto dto);
	
	
	
	List<DepartmentUserDeclarationDto> getDepartmentUserDeclarationDtoPage(Map<String,Object> param);
	int getDepartmentUserDeclarationDtoCount(Map<String,Object> param);
	
	/**
	 * 分组查询报单
	 */
	public List<ReportDto> getDepartmentOrUserMonthGroupReport(Map<String,Object> param);
	public List<ReportDto> getDepartmentOrUserDayGroupReport(Map<String,Object> param);
	/**
	 * 用户报单排名
	 */
	List<UserDeclarationRankResDto> getUserDeclarationRankPage(UserDeclarationRankReqDto reqDto);
	int getUserDeclarationRankCount(UserDeclarationRankReqDto reqDto);
	
	/**
	 * 客户报单排名
	 */
	List<DeclarationRankResDto> getCustomerDeclarationRankResDtoPage(DeclarationRankReqDto reqDto);
	int getCustomerDeclarationRankResDtoPageCount(DeclarationRankReqDto reqDto);
	List<CustomerDeclarationUserDto> getCustomerDeclarationUsers(DeclarationRankReqDto reqDto);
	
	/**
	 * 客户订单列表
	 */
	List<DepartmentUserDeclarationDto> getCustomerDeclarationPage(CustomerDeclarationReqDto dto);
	int getCustomerDeclarationPageCount(CustomerDeclarationReqDto dto);
	
	/**
	 * 通过客户类型查询客户
	 */
	List<Long> getCustomerByCustomerType(@Param("customerType") Integer customerType);
	
}

