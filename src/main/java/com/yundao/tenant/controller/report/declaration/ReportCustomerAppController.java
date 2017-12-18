

package com.yundao.tenant.controller.report.declaration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportReqDto;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportResDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailReqDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailResDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankReqDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankResDto;
import com.yundao.tenant.enums.report.ReportCustomGroupEnum;
import com.yundao.tenant.enums.report.ReportFilterTypeEnum;
import com.yundao.tenant.service.report.customer.CustomerAddService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 上午10:15:08 
 * @author   欧阳利
 * @version   
 */

@RestController
@RequestMapping(value = "/report/customer/app/")
@ResponseBody
@Api("报表-->新增客户业绩")
public class ReportCustomerAppController {
	
	@Autowired
	CustomerAddService customerAddService;
	
	/**
	 * 查询部门新增客户排名和报表
	 */
	@RequestMapping(value = "get_department", method = RequestMethod.GET)
	@ApiOperation(value = "获取部门报单业绩")
    public Result<List<DepartAddCustReportResDto>> getDepartmentAddCustomerReport(@ModelAttribute DepartAddCustReportReqDto reqDto)throws BaseException{
        // 默认是本月度
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
    	return customerAddService.getDepartmentAddCustomerReport(reqDto);
    }
    

	
	/**
	 * 查询员新增客户的排名
	 */
	@RequestMapping(value = "get_user_rank_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户新增客户(全部用户, 部门用户, 我的)")
    public Result<PaginationSupport<UserAddCustomerRankResDto>> getUserAddCustomerRank(@ModelAttribute UserAddCustomerRankReqDto reqDto)throws BaseException{
    	return customerAddService.getUserAddCustomerRank(reqDto);
    }
	
	
	/**
	 * 查询员工或者部门新增客户
	 * 报表走势和客户列表
	 */
	@RequestMapping(value = "get_department_or_user_detail", method = RequestMethod.GET)
	@ApiOperation(value = "获取部门新增客户业绩详情")
    public Result<DepartmentAndUserDetailResDto> getDepartmentAndUserAddCustomerDetail(@ModelAttribute DepartmentAndUserDetailReqDto reqDto)throws Exception{
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		if(reqDto.getFilterType() == ReportFilterTypeEnum.CUSTOM.getValue()){
			if(BooleanUtils.isBlank(reqDto.getCustomStart()) || BooleanUtils.isBlank(reqDto.getCustomEnd())){
			    return Result.newFailureResult(Code1200000.CODE_1200170);
		    }
			if(BooleanUtils.isEmpty(reqDto.getStatType())){
				reqDto.setStatType(ReportCustomGroupEnum.MONTH.getValue());
			}
		}
				
		return customerAddService.getDepartmentAndUserAddCustomerDetail(reqDto);
    }
}

