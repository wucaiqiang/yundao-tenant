

package com.yundao.tenant.service.report.declaration.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationReqDto;
import com.yundao.tenant.dto.report.declaration.customer.CustomerDeclarationUserDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.customer.DeclarationRankResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserDto;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.mapper.report.declaration.ReportDeclarationMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.report.declaration.CustomerDeclarationService;
import com.yundao.tenant.util.ReportDateUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午11:09:12 
 * @author   欧阳利
 * @version   
 */
@Service
public class CustomerDeclarationServiceImpl implements CustomerDeclarationService {

	@Autowired
	ReportDeclarationMapper reportDeclarationMapper;
	@Autowired
	DepartmentService departmentService;
	
	@Override
	public Result<PaginationSupport<DeclarationRankResDto>> getCustomerRankPage(DeclarationRankReqDto reqDto)
			throws BaseException {
		PaginationSupport<DeclarationRankResDto> page = reqDto.getPaginationSupport();
		if (reqDto.getFilterType()!= 1) {
			reqDto.setCustomStart(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setCustomEnd(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
		}
		if(reqDto.getCustomerType() != null && reqDto.getCustomerType() != 0){
			List<Long> customerIds = reportDeclarationMapper.getCustomerByCustomerType(reqDto.getCustomerType());
			if(BooleanUtils.isEmpty(customerIds)){
				return Result.newSuccessResult(page); 
			}
			reqDto.setCustomerIds(customerIds);
		}
		
		if (reqDto.getDepartmentId() != null) {
			BaseDepartment baseDepartment = departmentService.getBaseDepartment(reqDto.getDepartmentId()).getResult();
			if (baseDepartment != null) {
				reqDto.setDepartmentCode(baseDepartment.getCode());
			}
		}
		
		int totalCount = reportDeclarationMapper.getCustomerDeclarationRankResDtoPageCount(reqDto);
		if(totalCount > 0){
			List<DeclarationRankResDto> datas = reportDeclarationMapper.getCustomerDeclarationRankResDtoPage(reqDto);
			setDeclarationUser(datas,reqDto);
			page.setDatas(datas);
			
			
			// 查询最大的一个
			reqDto.setCurrentPage(1);
			reqDto.setPageSize(1);
			List<DeclarationRankResDto>  maxList = reportDeclarationMapper.getCustomerDeclarationRankResDtoPage(reqDto);
			if(!BooleanUtils.isEmpty(maxList) && !BooleanUtils.isEmpty(datas)){
				DeclarationRankResDto max = maxList.get(0);
				for(DeclarationRankResDto dto : datas){
					dto.setMaxSumDealAmount(max.getSumDealAmount());
				}
			}
			
		}
		page.setTotalCount(totalCount);
		return Result.newSuccessResult(page);
	}
	
	
	/**
	 * 设置客户报单的理财师信息
	 * setDeclarationUser:
	 * @author: 欧阳利
	 * @param datas
	 * @description:
	 */
	private void setDeclarationUser(List<DeclarationRankResDto> datas,DeclarationRankReqDto reqDto){
		List<CustomerDeclarationUserDto>  list = reportDeclarationMapper.getCustomerDeclarationUsers(reqDto);
		for(DeclarationRankResDto dto:datas){
			for(CustomerDeclarationUserDto customerUserDto : list){
				if(dto.getCustomerId().equals(customerUserDto.getCustomerId())){
					List<DeclarationUserDto> userDtos = dto.getUserDtos();
					if(userDtos == null){
						dto.setUserDtos(new ArrayList<DeclarationUserDto>());
						userDtos = dto.getUserDtos();
					}
					
					if(!DeclarationUserDto.contains(userDtos, customerUserDto.getUserId())){
						userDtos.add(new DeclarationUserDto(customerUserDto.getUserId(),customerUserDto.getUsername()));
					}
				}
			}
		}
	}
	
	
	
	/**
	 * 查询客户的报单详情
	 * getCustomerDeclarationPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<DepartmentUserDeclarationDto>> getCustomerDeclarationPage(CustomerDeclarationReqDto reqDto)throws BaseException{
		PaginationSupport<DepartmentUserDeclarationDto> page = reqDto.getPaginationSupport();
		if (reqDto.getFilterType()!= 1) {
			reqDto.setCustomStart(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setCustomEnd(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
		}
		int totalCount = reportDeclarationMapper.getCustomerDeclarationPageCount(reqDto);
		if(totalCount > 0){
			List<DepartmentUserDeclarationDto> datas = reportDeclarationMapper.getCustomerDeclarationPage(reqDto);
			if(!BooleanUtils.isEmpty(datas)){
				for(DepartmentUserDeclarationDto dto: datas){
					dto.setDeclarationStatusText(DeclarationStatusEnum.getName(dto.getDeclarationStatus()));
				}
			}
			page.setDatas(datas);
		}
		page.setTotalCount(totalCount);
		
		return Result.newSuccessResult(page);
	}

}

