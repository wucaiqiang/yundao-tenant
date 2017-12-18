

package com.yundao.tenant.service.report.declaration.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.report.declaration.DepartmentReportDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportReqDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportSelectDto;
import com.yundao.tenant.dto.report.declaration.IndexTopDto;
import com.yundao.tenant.dto.report.declaration.ReportDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.mapper.base.BaseDepartmentMapper;
import com.yundao.tenant.mapper.report.declaration.ReportDeclarationMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.model.base.BaseDepartmentExample;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.report.declaration.ReportDeclarationService;
import com.yundao.tenant.service.user.UserDepartmentService;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.ReportDateUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 下午4:56:43 
 * @author   欧阳利
 * @version   
 */
@Service
public class ReportDeclarationServiceImpl extends AbstractService implements ReportDeclarationService {

	@Autowired
	ReportDeclarationMapper reportDeclarationMapper;
	
	@Autowired
	private BaseDepartmentMapper baseDepartmentMapper;
	
	@Autowired
	DepartmentService bepartmentService;
	
	@Autowired
	UserDepartmentService userDepartmentService;
	
	@Override
	public List<ReportDto> getIndexReportDtos() throws BaseException {
		String month = DateUtil.getMonth(-6,new Date());
		List<String> months = DateUtil.getMonthList(-5,-1);
		List<ReportDto> list = reportDeclarationMapper.getIndexReportDtos(month);
		List<ReportDto> newList = new ArrayList<ReportDto>();
		for(String monthStr:months){
			ReportDto dto = new ReportDto();
			newList.add(dto);
			dto.setDate(monthStr);
			dto.setSumDealAmount(0.0d);
			
			if(!BooleanUtils.isEmpty(list)){
				for(ReportDto reportDto:list){
					if(monthStr.equals(reportDto.getDate())){
						dto.setSumDealAmount(reportDto.getSumDealAmount());
					}
				}
			}
			
		}
		return newList;
	}
	
	
	/**
	 * 获取top的业绩信息
	 * indexTopDtos:
	 * @author: 欧阳利
	 * @param count
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<IndexTopDto> getIndexTopDtos(int count)throws BaseException{
		String month = DateUtil.getMonth(0,new Date());
		List<IndexTopDto>  indexTopDtos = reportDeclarationMapper.getIndexTopDtos(count, month);
		return indexTopDtos;
	}
	
	
	
	/**
	 * 获取部门业绩报表
	 * getDepartmentReportDtos:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<List<DepartmentReportDto>> getDepartmentReportDtos(DepartmentReportReqDto reqDto)throws BaseException{
		if(reqDto.getDepartmentId() == null){
			reqDto.setDepartmentId(0l);
		}
		BaseDepartmentExample example = new BaseDepartmentExample();
		BaseDepartment currentDepartment = null;
		if(reqDto.getDepartmentId() > 0){
			currentDepartment = baseDepartmentMapper.selectByPrimaryKey(reqDto.getDepartmentId());
			example.createCriteria().andCodeLike(currentDepartment.getCode()+"%");
		}
		DepartmentReportSelectDto dto = new DepartmentReportSelectDto();
		if(currentDepartment != null){
			dto.setDepartmentCode(currentDepartment.getCode());
		}
        // 默认是本月度
		if(reqDto.getFilterType() == null){
			reqDto.setFilterType(2);
		}
		if(reqDto.getFilterType() == 1){
			dto.setStartDate(DateUtils.format(reqDto.getCustomStart(),DateUtils.YYYY_MM_DD));
			dto.setEndDate(DateUtils.format(reqDto.getCustomEnd(),DateUtils.YYYY_MM_DD));
		}else{
			dto.setStartDate(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(),false));
			dto.setEndDate(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(),false));
		}
		
		// 获取直接子部门的业绩报表
		List<DepartmentReportDto> departmentList = getDirectDepartmentReport(reqDto.getDepartmentId(),dto);
		
		// 查询直接人员 和 查询直接员工业绩
		dto.setDepartmentId(reqDto.getDepartmentId());
		List<DepartmentReportDto> userDepartmentList =  getDepartmentDirectUserReport(reqDto.getDepartmentId() , dto);
		userDepartmentList.addAll(departmentList);
		
		// 排序
		Collections.sort(userDepartmentList);
		return Result.newSuccessResult(userDepartmentList);
	}
	
	
	
	/**
	 * 获取直接子部门的业绩报表
	 * getDirectDepartmentReport:
	 * @author: 欧阳利
	 * @param departmentId
	 * @return
	 * @description:
	 */
	private List<DepartmentReportDto> getDirectDepartmentReport(Long departmentId,DepartmentReportSelectDto dto){
		// 查询直接子部门
		List<BaseDepartment> childDepartments =  bepartmentService.getDirectChilDepartment(departmentId);
		
		// 查询部门的业绩业绩大于0
		List<DepartmentReportDto> departmentList = reportDeclarationMapper.getDepartmentReportDtos(dto);
		List<DepartmentReportDto> reportList = new ArrayList<DepartmentReportDto>();
		List<Long> departmentIds = new ArrayList<Long>();
		if(!BooleanUtils.isEmpty(childDepartments)){
			// 设置直接子部门的业绩总和
			for(BaseDepartment baseDepartment : childDepartments){
				departmentIds.add(baseDepartment.getId());
				DepartmentReportDto reportDto = new DepartmentReportDto();
				reportList.add(reportDto);
				reportDto.setDepartmentId(baseDepartment.getId());
				reportDto.setDepartmentCode(baseDepartment.getCode());
				reportDto.setDepartmentName(baseDepartment.getName());
				Double sumDealAmount = 0.0d;
				if(!BooleanUtils.isEmpty(departmentList)){
					for(DepartmentReportDto departmentReportDto:departmentList){
						if(departmentReportDto.getDepartmentCode().startsWith(reportDto.getDepartmentCode())){
							sumDealAmount = sumDealAmount + departmentReportDto.getSumDealAmount();
						}
					}
				}
				reportDto.setSumDealAmount(sumDealAmount);
			}
			
			// 设置是否有下级部门
			BaseDepartmentExample example = new BaseDepartmentExample();
			example.createCriteria().andParentIdIn(departmentIds);
			List<BaseDepartment> childs = baseDepartmentMapper.selectByExample(example);
			for(DepartmentReportDto reportDto : reportList){
				reportDto.setHasChildDepartment(false);
				if(!BooleanUtils.isEmpty(childs)){
				    for(BaseDepartment department : childs){
				    	if(department.getParentId().equals(reportDto.getDepartmentId())){
				    		reportDto.setHasChildDepartment(true);
				    	}
				    }
				}
			}
			
		}
		
		
		return reportList;
	}
	
//	/**
//	 * 查询部门的直接部门
//	 * getDirectChilDepartment:
//	 * @author: 欧阳利
//	 * @param departmentId
//	 * @return
//	 * @description:
//	 */
//	private List<BaseDepartment> getDirectChilDepartment(Long departmentId){
//		List<BaseDepartment> childDepartments = null;
//		if(departmentId == null || departmentId == 0){
//			BaseDepartmentExample example = new BaseDepartmentExample();
//			example.createCriteria().andParentIdEqualTo(0l);
//			childDepartments = baseDepartmentMapper.selectByExample(example);
//		}else{
//			BaseDepartmentExample example = new BaseDepartmentExample();
//			example.createCriteria().andParentIdEqualTo(departmentId);
//			childDepartments = baseDepartmentMapper.selectByExample(example);
//		}
//		return childDepartments;
//	}
	
	
	/**
	 * 获取部门的直接用户的业绩
	 * getDepartmentDirectUserReport:
	 * @author: 欧阳利
	 * @param departmentId
	 * @param dto
	 * @return
	 * @description:
	 */
	private List<DepartmentReportDto> getDepartmentDirectUserReport(Long departmentId ,DepartmentReportSelectDto dto){
		List<UserInfoDto> allUser = userDepartmentService.getDepartmentDirectUser(departmentId);
		List<DepartmentReportDto> userDepartmentList =  reportDeclarationMapper.getDepartmentUserReportDtos(dto);
		
		List<DepartmentReportDto> list = new ArrayList<DepartmentReportDto>();
		if(!BooleanUtils.isEmpty(allUser)){
			for(UserInfoDto user:allUser){
				DepartmentReportDto departmentReportDto = new DepartmentReportDto();
				list.add(departmentReportDto);
				departmentReportDto.setUserId(user.getId());
				departmentReportDto.setUsername(user.getUsername());
				if(!BooleanUtils.isEmpty(userDepartmentList)){
					for(DepartmentReportDto reportDto : userDepartmentList){
						if(user.getId().equals(reportDto.getUserId())){
							departmentReportDto.setSumDealAmount(reportDto.getSumDealAmount());
						}
					}
				}
				
				if(departmentReportDto.getSumDealAmount() == null){
					departmentReportDto.setSumDealAmount(0.0d);
				}
				
			}
		}
		return list;
	}
	
	
	
	

}

