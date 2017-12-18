

package com.yundao.tenant.service.report.customer.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.report.customer.CustomerReportDto;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportReqDto;
import com.yundao.tenant.dto.report.customer.DepartAddCustReportResDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailReqDto;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailResDto;
import com.yundao.tenant.dto.report.customer.DepartmentUserAddCustomerReportDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankReqDto;
import com.yundao.tenant.dto.report.customer.UserAddCustomerRankResDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportSelectDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.enums.customer.CustomerLevelEnum;
import com.yundao.tenant.enums.report.ReportCustomGroupEnum;
import com.yundao.tenant.enums.report.ReportFilterTypeEnum;
import com.yundao.tenant.mapper.base.BaseDepartmentMapper;
import com.yundao.tenant.mapper.report.customer.CustomerAddMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.model.base.BaseDepartmentExample;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.report.customer.CustomerAddService;
import com.yundao.tenant.service.user.UserDepartmentService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.util.ReportDateUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:38:40 
 * @author   欧阳利
 * @version   
 */
@Service
public class CustomerAddServiceImpl implements CustomerAddService {
    
	@Autowired
	CustomerAddMapper customerAddMapper;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	private BaseDepartmentMapper baseDepartmentMapper;
	
	@Autowired
	private UserDepartmentService userDepartmentService;
	@Autowired
	private UserDetailService userDetailService;
	private static Log log = LogFactory.getLog(CustomerAddServiceImpl.class);
	@Override
	public Result<List<DepartAddCustReportResDto>> getDepartmentAddCustomerReport(DepartAddCustReportReqDto reqDto)
			throws BaseException {
		if(reqDto.getDepartmentId() == null){
			reqDto.setDepartmentId(0l);
		}
		BaseDepartment currentDepartment = null;
		if(reqDto.getDepartmentId() > 0){
			currentDepartment = baseDepartmentMapper.selectByPrimaryKey(reqDto.getDepartmentId());
		}
		DepartmentReportSelectDto dto = new DepartmentReportSelectDto();
		if(currentDepartment != null){
			dto.setDepartmentCode(currentDepartment.getCode());
		}

		if(reqDto.getFilterType() == 1){
			dto.setStartDate(DateUtils.format(reqDto.getCustomStart(),DateUtils.YYYY_MM_DD));
			dto.setEndDate(DateUtils.format(reqDto.getCustomEnd(),DateUtils.YYYY_MM_DD));
		}else{
			dto.setStartDate(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(),false));
			dto.setEndDate(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(),false));
		}
		
		// 获取直接子部门的业绩报表
		List<DepartAddCustReportResDto> departmentList = getDirectDepartmentReport(reqDto.getDepartmentId(),dto);
		
		// 查询直接人员 和 查询直接员工业绩
		dto.setDepartmentId(reqDto.getDepartmentId());
		List<DepartAddCustReportResDto> userDepartmentList =  getDepartmentDirectUserReport(reqDto.getDepartmentId() , dto);
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
	private List<DepartAddCustReportResDto> getDirectDepartmentReport(Long departmentId,DepartmentReportSelectDto dto)throws BaseException{
		// 查询直接子部门
		List<BaseDepartment> childDepartments = departmentService.getDirectChilDepartment(departmentId);
		
		// 查询部门的业绩业绩大于0
		List<DepartAddCustReportResDto> departmentList = customerAddMapper.getDepartmentAddCustomerReport(dto);
		List<DepartAddCustReportResDto> reportList = new ArrayList<DepartAddCustReportResDto>();
		List<Long> departmentIds = new ArrayList<Long>();
		if(!BooleanUtils.isEmpty(childDepartments)){
			// 设置直接子部门的业绩总和
			for(BaseDepartment baseDepartment : childDepartments){
				departmentIds.add(baseDepartment.getId());
				DepartAddCustReportResDto reportDto = new DepartAddCustReportResDto();
				reportList.add(reportDto);
				reportDto.setDepartmentId(baseDepartment.getId());
				reportDto.setDepartmentCode(baseDepartment.getCode());
				reportDto.setDepartmentName(baseDepartment.getName());
				Integer sumCount = 0;
				if(!BooleanUtils.isEmpty(departmentList)){
					for(DepartAddCustReportResDto departmentReportDto:departmentList){
						if(departmentReportDto.getDepartmentCode().startsWith(reportDto.getDepartmentCode())){
							sumCount = sumCount + departmentReportDto.getSumCount();
						}
					}
				}
				reportDto.setSumCount(sumCount);
			}
			
			// 设置是否有下级部门
			BaseDepartmentExample example = new BaseDepartmentExample();
			example.createCriteria().andParentIdIn(departmentIds);
			List<BaseDepartment> childs = baseDepartmentMapper.selectByExample(example);
			for(DepartAddCustReportResDto reportDto : reportList){
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
	
	
	
	
	/**
	 * 获取部门的直接用户的业绩
	 * getDepartmentDirectUserReport:
	 * @author: 欧阳利
	 * @param departmentId
	 * @param dto
	 * @return
	 * @description:
	 */
	private List<DepartAddCustReportResDto> getDepartmentDirectUserReport(Long departmentId ,DepartmentReportSelectDto dto)throws BaseException{
		List<UserInfoDto> allUser = userDepartmentService.getDepartmentDirectUser(departmentId);
		List<DepartAddCustReportResDto> userDepartmentList =  customerAddMapper.getDepartmentUserAddCustomerReport(dto);
		
		List<DepartAddCustReportResDto> list = new ArrayList<DepartAddCustReportResDto>();
		if(!BooleanUtils.isEmpty(allUser)){
			for(UserInfoDto user:allUser){
				DepartAddCustReportResDto departmentReportDto = new DepartAddCustReportResDto();
				list.add(departmentReportDto);
				departmentReportDto.setUserId(user.getId());
				departmentReportDto.setUsername(user.getUsername());
				if(!BooleanUtils.isEmpty(userDepartmentList)){
					for(DepartAddCustReportResDto reportDto : userDepartmentList){
						if(user.getId().equals(reportDto.getUserId())){
							departmentReportDto.setSumCount(reportDto.getSumCount());
						}
					}
				}
				
				if(departmentReportDto.getSumCount() == null){
					departmentReportDto.setSumCount(0);
				}
				
			}
		}
		return list;
	}
	
	
	
	
	
	


	@Override
	public Result<DepartmentAndUserDetailResDto> getDepartmentAndUserAddCustomerDetail(
			DepartmentAndUserDetailReqDto reqDto) throws Exception {
		DepartmentAndUserDetailResDto resultDto = new DepartmentAndUserDetailResDto();
		if (reqDto.getUserId() != null) {
			resultDto.setUserName(userDetailService.getUserRealName(reqDto.getUserId()));
		}
		if (reqDto.getDepartmentId() != null) {
			BaseDepartment baseDepartment = departmentService.getBaseDepartment(reqDto.getDepartmentId()).getResult();
			resultDto.setDepartmentName(baseDepartment.getName());
		}

		resultDto.setCustomerDtos(getDepartmentUserDeclarationDto(reqDto));
		// 第一页才查询业绩轨迹信息
		if (reqDto.getCurrentPage() > 1) {
			return Result.newSuccessResult(resultDto);
		}
        
		if (reqDto.getFilterType() > ReportFilterTypeEnum.UPPER_MONTH.getValue().intValue() ) {// 按月分组
			resultDto.setReportDtos(getDepartmentOrUserMonthGroupReport(reqDto));
		}
		else if (ReportFilterTypeEnum.UPPER_MONTH.getValue().equals(reqDto.getFilterType()) ||
				ReportFilterTypeEnum.MONTH.getValue().equals(reqDto.getFilterType())) {  // 按周分组
			reqDto.setCustomStart(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setCustomEnd(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
			resultDto.setReportDtos(getDepartmentOrUserDayGroupReport(reqDto));
		}
		else if(ReportFilterTypeEnum.CUSTOM.getValue().equals(reqDto.getFilterType())){ // 自定义 按天，周，月分组
			if(ReportCustomGroupEnum.DAY.getValue().equals(reqDto.getStatType())){ //天
				resultDto.setReportDtos(getDepartmentOrUserDayGroupReport(reqDto));
			}else if(ReportCustomGroupEnum.WEEK.getValue().equals(reqDto.getStatType())){ // 周
				resultDto.setReportDtos(getDepartmentUserCustomWeekReportDto(reqDto));
			}else{ // 月
				reqDto.setCustomStart(ReportDateUtils.getMonthStartDay(reqDto.getCustomStart()));
				reqDto.setCustomEnd(ReportDateUtils.getMonthLastDay(reqDto.getCustomEnd()));
				resultDto.setReportDtos(getDepartmentOrUserMonthGroupReport(reqDto));
			}
		}

		return Result.newSuccessResult(resultDto);

	}
	
	
	
	
	/**
	 * 按月分组查询报单统计信息 getDepartmentOrUserMonthGroupReport:
	 */
	private List<DepartmentUserAddCustomerReportDto> getDepartmentOrUserMonthGroupReport(DepartmentAndUserDetailReqDto reqDto)
			throws Exception {
		Map<String, Object> param = getParam(reqDto);

		List<DepartmentUserAddCustomerReportDto> list = customerAddMapper.getDepartmentOrUserMonthGroupReport(param);
		List<DepartmentUserAddCustomerReportDto> reportList = new ArrayList<DepartmentUserAddCustomerReportDto>();
		List<String> monthList = ReportDateUtils.getMonthStr(new Date(), reqDto.getFilterType(), reqDto.getCustomStart(),
				reqDto.getCustomEnd());
		for (String month : monthList) {
			DepartmentUserAddCustomerReportDto reportDto = new DepartmentUserAddCustomerReportDto();
			reportList.add(reportDto);
			reportDto.setDate(month);
			reportDto.setSumCount(0);
			if (!BooleanUtils.isEmpty(list)) {
				for (DepartmentUserAddCustomerReportDto dto : list) {
					if (month.equals(dto.getDate())) {
						reportDto.setSumCount(dto.getSumCount());
					}

				}
			}
		}

		return reportList;
	}
	
	
	/**
	 * 按月分组查询添加客户统计信息 
	 */
	private List<DepartmentUserAddCustomerReportDto> getDepartmentOrUserDayGroupReport(DepartmentAndUserDetailReqDto reqDto)
			throws Exception {
		Map<String, Object> param = getParam(reqDto);
		
		List<DepartmentUserAddCustomerReportDto> list = customerAddMapper.getDepartmentOrUserDayGroupReport(param);
		List<DepartmentUserAddCustomerReportDto> reportList = new ArrayList<DepartmentUserAddCustomerReportDto>();
		List<String> dayList = ReportDateUtils.getDayStrList(reqDto.getCustomStart(), reqDto.getCustomEnd());
		for (String day : dayList) {
			DepartmentUserAddCustomerReportDto reportDto = new DepartmentUserAddCustomerReportDto();
			reportList.add(reportDto);
			reportDto.setDate(day);
			reportDto.setSumCount(0);
			if (!BooleanUtils.isEmpty(list)) {
				for (DepartmentUserAddCustomerReportDto dto : list) {
					if (day.equals(dto.getDate())) {
						reportDto.setSumCount(dto.getSumCount());
					}
				}
			}
		}

		return reportList;
	}
	
	
	private List<DepartmentUserAddCustomerReportDto> getDepartmentUserCustomWeekReportDto(DepartmentAndUserDetailReqDto reqDto)
			throws Exception {
		// 设置参数
		Date startDate = DateUtils.parse(ReportDateUtils.getWeekStartDay(reqDto.getCustomStart()), DateUtils.YYYY_MM_DD);
		Date endDate = DateUtils.parse(ReportDateUtils.getWeekLastDay(reqDto.getCustomEnd()), DateUtils.YYYY_MM_DD);
//        Date startDate = ReportDateUtils.getFirstDayOfFirstWeekOfMonth(DateUtils.parse(reqDto.getCustomStart(), DateUtils.YYYY_MM_DD));
//        Date endDate = ReportDateUtils.getLastDayOfLastWeekOfMonth(DateUtils.parse(reqDto.getCustomEnd(), DateUtils.YYYY_MM_DD));
//        reqDto.setCustomEnd(DateUtils.format(endDate, DateUtils.YYYY_MM_DD));
//        reqDto.setCustomStart(DateUtils.format(startDate, DateUtils.YYYY_MM_DD));
        Map<String, Object> param = getParam(reqDto);
        // 按天分组查询添加客户统计信息
		List<DepartmentUserAddCustomerReportDto> list = customerAddMapper.getDepartmentOrUserDayGroupReport(param);
		// 获取开始日期和结束日期所在的周
		Map<Integer, List<Date>> map = ReportDateUtils.getAllWeekOfMonth( startDate,  endDate);
		// 依据按天分组查询的统计信息 组装 按周分组的统计信息
		List<DepartmentUserAddCustomerReportDto> resultList = new ArrayList<DepartmentUserAddCustomerReportDto>();
		for (Integer i : map.keySet()) {
			List<Date> dateList = map.get(i);
			DepartmentUserAddCustomerReportDto dto = new DepartmentUserAddCustomerReportDto();
			resultList.add(dto);
			dto.setOrderIndex(i);
			dto.setStartDate(DateUtils.format(dateList.get(0), DateUtils.YYYY_MM_DD));
			dto.setEndDate(DateUtils.format(dateList.get(1), DateUtils.YYYY_MM_DD));
			dto.setSumCount(0);
			if (!BooleanUtils.isEmpty(list)) {
				for (DepartmentUserAddCustomerReportDto reportDto : list) {
					Date date= DateUtils.parse(reportDto.getDate(), DateUtils.YYYY_MM_DD);
					log.info("reportDto.getSumCount()"+reportDto.getSumCount());
					log.info("date.getTime():"+date.getTime());
					log.info("dateList.get(0).getTime()"+dateList.get(0).getTime());
					log.info("dateList.get(1).getTime()"+dateList.get(1).getTime());
					log.info("date.after(dateList.get(0)) || date.getTime()==dateList.get(0).getTime()"+(date.after(dateList.get(0)) || date.getTime()==dateList.get(0).getTime()));
					log.info("date.before(dateList.get(1))  || date.getTime()==dateList.get(1).getTime()"+(date.before(dateList.get(1))  || date.getTime()==dateList.get(1).getTime()));
					
					if (date != null && (date.after(dateList.get(0)) || date.getTime()==dateList.get(0).getTime())
							&& (date.before(dateList.get(1))  || date.getTime()==dateList.get(1).getTime())) {
						dto.setSumCount(dto.getSumCount()+reportDto.getSumCount());
					}
					
					
				}
			}
		}
		return resultList;
	}
	

	
	/**
	 * 查询报单列表 getDepartmentUserDeclarationDto:
	 * 
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
	private PaginationSupport<CustomerReportDto> getDepartmentUserDeclarationDto(
			DepartmentAndUserDetailReqDto reqDto) throws Exception {
		PaginationSupport<CustomerReportDto> page = new PaginationSupport<CustomerReportDto>();
		page.setCurrentPage(reqDto.getCurrentPage());
		page.setPageSize(reqDto.getPageSize());

		Map<String, Object> param = getParam(reqDto);
		param.put("offset", (reqDto.getCurrentPage() - 1) * reqDto.getPageSize());
		param.put("pageSize", reqDto.getPageSize());
		
		// 分页查询
		int totalCount = customerAddMapper.getDepartmentUserCustomerDtoCount(param);
		if (totalCount > 0) {
			List<CustomerReportDto> datas = customerAddMapper
					.getDepartmentUserCustomerDtoPage(param);
			page.setDatas(datas);
			if(BooleanUtils.isNotEmpty(datas)){
				for(CustomerReportDto dto : datas){
					if(dto.getLevel() != null){
						dto.setLevelText(CustomerLevelEnum.getEnumName(dto.getLevel()));
					}
				}	
			}
			
		}
		page.setTotalCount(totalCount);
		return page;
	}

	
	private void setStartAndEndDate(DepartmentAndUserDetailReqDto reqDto,Map<String, Object> param)throws Exception{
		if (reqDto.getFilterType() == null) {
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		// 设置是否按照分周
		Boolean weekOfMonth = ReportDateUtils.getWeekOfMonth(reqDto);
		if (ReportFilterTypeEnum.CUSTOM.getValue().equals(reqDto.getFilterType())) {
			if(ReportCustomGroupEnum.DAY.getValue().equals(reqDto.getStatType())){ //天
				param.put("startDate", reqDto.getCustomStart());
				param.put("endDate", reqDto.getCustomEnd());
			}else if(ReportCustomGroupEnum.WEEK.getValue().equals(reqDto.getStatType())){ // 周
				param.put("startDate",  ReportDateUtils.getWeekStartDay(reqDto.getCustomStart()));
				param.put("endDate", ReportDateUtils.getWeekLastDay(reqDto.getCustomEnd()));
			}else{ // 月
				param.put("startDate", ReportDateUtils.getMonthStartDay(reqDto.getCustomStart()));
				param.put("endDate", ReportDateUtils.getMonthLastDay(reqDto.getCustomEnd()));
			}
			
		}
		else {
			param.put("startDate", ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), weekOfMonth));
			param.put("endDate", ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), weekOfMonth));
		}
	}
	
	private Map<String, Object> getParam(DepartmentAndUserDetailReqDto reqDto)throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentCode", null);
		param.put("userId", null);
		if (reqDto.getDepartmentId() != null) {
			BaseDepartment baseDepartment = departmentService.getBaseDepartment(reqDto.getDepartmentId()).getResult();
			param.put("departmentCode", baseDepartment.getCode());
		}
		if (reqDto.getUserId() != null) {
			param.put("userId", reqDto.getUserId());
		}

		// 设置开始和结束日期
		setStartAndEndDate(reqDto,param);
		return param;
	}
	
	
	@Override
	public Result<PaginationSupport<UserAddCustomerRankResDto>> getUserAddCustomerRank(UserAddCustomerRankReqDto reqDto)
			throws BaseException {
		PaginationSupport<UserAddCustomerRankResDto> page = reqDto.getPaginationSupport();

		if (reqDto.getDepartmentId() != null) {
			BaseDepartment baseDepartment = departmentService.getBaseDepartment(reqDto.getDepartmentId()).getResult();
			if (baseDepartment != null) {
				reqDto.setDepartmentCode(baseDepartment.getCode());
			}
		}
		if (ReportFilterTypeEnum.CUSTOM.getValue().equals(reqDto.getFilterType())) {
			reqDto.setStartDate(reqDto.getCustomStart());
			reqDto.setEndDate(reqDto.getCustomEnd());
		}
		else {
			reqDto.setStartDate(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setEndDate(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
		}
		// 查找总记录数
		int totalCount = customerAddMapper.getUserAddCustomerRankCount(reqDto);
		page.setTotalCount(totalCount);
		if(totalCount > 0){
			// 查询用户添加客户排名
			List<UserAddCustomerRankResDto>  datas = customerAddMapper.getUserAddCustomerRankPage(reqDto);
			page.setDatas(datas);
			
			// 查询最大的一个
			List<UserAddCustomerRankResDto>  maxList = null;
			if(reqDto.getCurrentPage() == 1){
				maxList = datas;
			}else{
				reqDto.setCurrentPage(1);
				reqDto.setPageSize(1);
				maxList = customerAddMapper.getUserAddCustomerRankPage(reqDto);
			}
			if(!BooleanUtils.isEmpty(maxList) && !BooleanUtils.isEmpty(datas)){
				UserAddCustomerRankResDto max = maxList.get(0);
				for(UserAddCustomerRankResDto dto : datas){
					dto.setMaxSumCount(max.getSumCount());
				}
			}
		}

		return Result.newSuccessResult(page);
	}

}

