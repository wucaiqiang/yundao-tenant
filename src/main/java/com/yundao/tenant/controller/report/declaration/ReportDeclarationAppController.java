

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
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.report.declaration.DepartUserDeclarationReportReqDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportReqDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationReportDetailDto;
import com.yundao.tenant.dto.report.declaration.IndexDto;
import com.yundao.tenant.dto.report.declaration.IndexTopDto;
import com.yundao.tenant.dto.report.declaration.ReportDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankResDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankResDto;
import com.yundao.tenant.enums.report.ReportCustomGroupEnum;
import com.yundao.tenant.enums.report.ReportFilterTypeEnum;
import com.yundao.tenant.service.report.declaration.CustomerDeclarationService;
import com.yundao.tenant.service.report.declaration.DepartmentUserReportDetailService;
import com.yundao.tenant.service.report.declaration.ReportDeclarationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 新增客户业绩
 * date: 2017年12月1日 下午3:06:44
 * @author:欧阳利
 * @description:
 */

@RestController

@RequestMapping(value = "/report/declaration/app/")
@ResponseBody
@Api("报表-->报表报单业绩")
public class ReportDeclarationAppController {

	
	@Autowired
	ReportDeclarationService reportDeclarationService;
	@Autowired
	DepartmentUserReportDetailService departmentUserReportDetailService;
	@Autowired
	CustomerDeclarationService customerDeclarationService;
	/**
	 * 获取数据报表首页
	 * getIndexDto:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	@RequestMapping(value = "get_index", method = RequestMethod.GET)
	@ApiOperation(value = "获取数据报表首页")
    public Result<IndexDto> getIndexDto() throws BaseException{
    	IndexDto indexDto = new IndexDto();
    	List<ReportDto> reportDtos = reportDeclarationService.getIndexReportDtos();
    	indexDto.setReportDtos(reportDtos);;
    	List<IndexTopDto> indexTopDtos = reportDeclarationService.getIndexTopDtos(5);
    	indexDto.setIndexTopDtos(indexTopDtos);
    	return Result.newSuccessResult(indexDto);
    }
	
	
	@RequestMapping(value = "get_department_or_user_detail", method = RequestMethod.GET)
	@ApiOperation(value = "获取部门报单业绩详情")
	public Result<DepartmentUserDeclarationReportDetailDto> getDepartmentOrUserDetailDto(@ModelAttribute DepartUserDeclarationReportReqDto reqDto)throws Exception{
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
		return departmentUserReportDetailService.getDepartmentOrUserDetailDto(reqDto);
	}
	
	
	@RequestMapping(value = "get_department", method = RequestMethod.GET)
	@ApiOperation(value = "获取部门报单业绩")
	public Result<List<DepartmentReportDto>> getDepartmentReportDtos(@ModelAttribute DepartmentReportReqDto reqDto)throws BaseException{
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		return reportDeclarationService.getDepartmentReportDtos(reqDto);
	}
	
	
	@RequestMapping(value = "get_user_rank_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户报单业绩(全部用户, 部门用户, 我的)")
	public Result<PaginationSupport<UserDeclarationRankResDto>> getUserRankPage(@ModelAttribute UserDeclarationRankReqDto reqDto)throws BaseException{
		if(reqDto.getUserId() == null && reqDto.getDepartmentId() == null){
			return Result.newFailureResult(Code1200000.CODE_1200171);
		}
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		if(reqDto.getFilterType() == 1 && 
				(BooleanUtils.isBlank(reqDto.getCustomStart()) || BooleanUtils.isBlank(reqDto.getCustomEnd()))){
			return Result.newFailureResult(Code1200000.CODE_1200170);
		}
		return departmentUserReportDetailService.getUserRankPage(reqDto);
	}
	
	
	
	@RequestMapping(value = "get_customer_rank_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户成交(全部用户, 部门用户, 我的)")
	public Result<PaginationSupport<DeclarationRankResDto>> getCustomerRankPage(@ModelAttribute DeclarationRankReqDto reqDto)throws BaseException{
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		if(reqDto.getFilterType() == 1 && 
				(BooleanUtils.isBlank(reqDto.getCustomStart()) || BooleanUtils.isBlank(reqDto.getCustomEnd()))){
			return Result.newFailureResult(Code1200000.CODE_1200170);
		}
		return customerDeclarationService.getCustomerRankPage(reqDto);
	}
	
	
	@RequestMapping(value = "get_customer_declaration_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户报单列表")
	public Result<PaginationSupport<DepartmentUserDeclarationDto>> getCustomerDeclarationPage(@ModelAttribute CustomerDeclarationReqDto reqDto)throws BaseException{
		if(reqDto.getCustomerId() == null){
			return Result.newFailureResult(CodeConstant.CODE_1220047);
		}
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		if(reqDto.getFilterType() == 1 && 
				(BooleanUtils.isBlank(reqDto.getCustomStart()) || BooleanUtils.isBlank(reqDto.getCustomEnd()))){
			return Result.newFailureResult(Code1200000.CODE_1200170);
		}
		return customerDeclarationService.getCustomerDeclarationPage(reqDto);
	}
	

}

