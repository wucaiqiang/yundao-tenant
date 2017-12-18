
package com.yundao.tenant.service.report.declaration.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.report.declaration.DepartUserDeclarationReportReqDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserDeclarationReportDetailDto;
import com.yundao.tenant.dto.report.declaration.DepartmentUserReportDto;
import com.yundao.tenant.dto.report.declaration.ReportDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankReqDto;
import com.yundao.tenant.dto.report.declaration.UserDeclarationRankResDto;
import com.yundao.tenant.enums.report.ReportCustomGroupEnum;
import com.yundao.tenant.enums.report.ReportFilterTypeEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.mapper.report.declaration.ReportDeclarationMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.report.declaration.DepartmentUserReportDetailService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.util.ReportDateUtils;

/**
 * Function: Reason: Date: 2017年11月4日 上午9:26:41
 * 
 * @author 欧阳利
 * @version
 */
@Service
public class DepartmentUserReportDetailServiceImpl implements DepartmentUserReportDetailService {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	ReportDeclarationMapper reportDeclarationMapper;
	@Autowired
	UserDetailService userDetailService;

	/**
	 * 查询部门业绩详情 getDepartmentDeclarationDetailDto:
	 * 
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<DepartmentUserDeclarationReportDetailDto> getDepartmentOrUserDetailDto(
			DepartUserDeclarationReportReqDto reqDto) throws Exception {
		DepartmentUserDeclarationReportDetailDto resultDto = new DepartmentUserDeclarationReportDetailDto();
		if (reqDto.getUserId() != null) {
			resultDto.setUserName(userDetailService.getUserRealName(reqDto.getUserId()));
		}
		if (reqDto.getDepartmentId() != null) {
			BaseDepartment baseDepartment = departmentService.getBaseDepartment(reqDto.getDepartmentId()).getResult();
			resultDto.setDepartmentName(baseDepartment.getName());
		}

		resultDto.setDeclarationDtos(getDepartmentUserDeclarationDto(reqDto));
		// 第一页才查询业绩轨迹信息
		if (reqDto.getCurrentPage() > 1) {
			return Result.newSuccessResult(resultDto);
		}

		if (reqDto.getFilterType() == null) {
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}

		
		if (reqDto.getFilterType() > ReportFilterTypeEnum.UPPER_MONTH.getValue().intValue() ) {// 按月分组
			List<DepartmentUserReportDto> list = getDepartmentOrUserMonthGroupReport(reqDto);
			resultDto.setReportDtos(list);
		}
		else if (ReportFilterTypeEnum.UPPER_MONTH.getValue().equals(reqDto.getFilterType()) ||
				ReportFilterTypeEnum.MONTH.getValue().equals(reqDto.getFilterType())) {  // 按周分组
			reqDto.setCustomStart(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setCustomEnd(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
			resultDto.setReportDtos(getDepartmentOrUserDayGroupReport(reqDto));
		}else if(ReportFilterTypeEnum.CUSTOM.getValue().equals(reqDto.getFilterType())){ // 自定义 按天，周，月分组
			if(ReportCustomGroupEnum.DAY.getValue().equals(reqDto.getStatType())){ //天
				resultDto.setReportDtos(getDepartmentOrUserDayGroupReport(reqDto));
			}else if(ReportCustomGroupEnum.WEEK.getValue().equals(reqDto.getStatType())){ // 周
				resultDto.setReportDtos(getDepartmentUserCustomWeekReportDto(reqDto));
			}else if(ReportCustomGroupEnum.MONTH.getValue().equals(reqDto.getStatType())){ // 月
				reqDto.setCustomStart(ReportDateUtils.getMonthStartDay(reqDto.getCustomStart()));
				reqDto.setCustomEnd(ReportDateUtils.getMonthLastDay(reqDto.getCustomEnd()));
				resultDto.setReportDtos(getDepartmentOrUserMonthGroupReport(reqDto));
			}else{
				resultDto.setReportDtos(getDepartmentOrUserMonthGroupReport(reqDto));
			}
		}

		return Result.newSuccessResult(resultDto);
	}


	private List<DepartmentUserReportDto> getDepartmentUserCustomWeekReportDto(DepartUserDeclarationReportReqDto reqDto)
			throws Exception {
		if (reqDto.getFilterType() == null) {
			return null;
		}
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
		Date startDate = DateUtils.parse(ReportDateUtils.getWeekStartDay(reqDto.getCustomStart()), DateUtils.YYYY_MM_DD);
		Date endDate = DateUtils.parse(ReportDateUtils.getWeekLastDay(reqDto.getCustomEnd()), DateUtils.YYYY_MM_DD);
//        Date startDate = ReportDateUtils.getFirstDayOfFirstWeekOfMonth(DateUtils.parse(reqDto.getCustomStart(), DateUtils.YYYY_MM_DD));
//        Date endDate = ReportDateUtils.getLastDayOfLastWeekOfMonth(DateUtils.parse(reqDto.getCustomEnd(), DateUtils.YYYY_MM_DD));
//        // 设置开始和结束日期
//        reqDto.setCustomEnd(DateUtils.format(endDate, DateUtils.YYYY_MM_DD));
//        reqDto.setCustomStart(DateUtils.format(startDate, DateUtils.YYYY_MM_DD));
     	setStartAndEndDate(reqDto,param,true);
        List<ReportDto> list = reportDeclarationMapper.getDepartmentOrUserDayGroupReport(param);

		Map<Integer, List<Date>> map = ReportDateUtils.getAllWeekOfMonth( startDate,  endDate);
		List<DepartmentUserReportDto> resultList = new ArrayList<DepartmentUserReportDto>();
		for (Integer i : map.keySet()) {
			List<Date> dateList = map.get(i);
			DepartmentUserReportDto dto = new DepartmentUserReportDto();
			resultList.add(dto);
			dto.setOrderIndex(i);
			dto.setStartDate(DateUtils.format(dateList.get(0), DateUtils.YYYY_MM_DD));
			dto.setEndDate(DateUtils.format(dateList.get(1), DateUtils.YYYY_MM_DD));
			dto.setSumDealAmount(0.0d);
			if (!BooleanUtils.isEmpty(list)) {
				for (ReportDto reportDto : list) {
					Date date= DateUtils.parse(reportDto.getDate(), DateUtils.YYYY_MM_DD);
					if (date != null && (date.after(dateList.get(0)) ||  date.getTime()==dateList.get(0).getTime())
							&& (date.before(dateList.get(1))  || date.getTime()==dateList.get(1).getTime())) {
						dto.setSumDealAmount(dto.getSumDealAmount() + reportDto.getSumDealAmount());
					}
				}
			}

		}
		return resultList;
	}
	

	private void setStartAndEndDate(DepartUserDeclarationReportReqDto reqDto,Map<String, Object> param, Boolean weekOfMonth)throws Exception{
		if (reqDto.getFilterType() == null) {
			reqDto.setFilterType(ReportFilterTypeEnum.MONTH.getValue());
		}
		// 设置是否按照分周
		weekOfMonth = ReportDateUtils.getWeekOfMonth(reqDto.getFilterType(),reqDto.getStatType());
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
	
	
	
	/**
	 * 按月分组查询报单统计信息 getDepartmentOrUserMonthGroupReport:
	 */
	private List<DepartmentUserReportDto> getDepartmentOrUserMonthGroupReport(DepartUserDeclarationReportReqDto reqDto)
			throws Exception {
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
		setStartAndEndDate(reqDto,param,true);

		List<ReportDto> list = reportDeclarationMapper.getDepartmentOrUserMonthGroupReport(param);
		List<DepartmentUserReportDto> reportList = new ArrayList<DepartmentUserReportDto>();
		List<String> monthList = ReportDateUtils.getMonthStr(new Date(), reqDto.getFilterType(), reqDto.getCustomStart(),
				reqDto.getCustomEnd());
		for (String month : monthList) {
			DepartmentUserReportDto reportDto = new DepartmentUserReportDto();
			reportList.add(reportDto);
			reportDto.setDate(month);
			reportDto.setSumDealAmount(0.0d);
			if (!BooleanUtils.isEmpty(list)) {
				for (ReportDto dto : list) {
					if (month.equals(dto.getDate())) {
						reportDto.setSumDealAmount(dto.getSumDealAmount());
					}

				}
			}
		}

		return reportList;
	}
	
	
	/**
	 * 按月分组查询报单统计信息 getDepartmentOrUserDayGroupReport:
	 */
	private List<DepartmentUserReportDto> getDepartmentOrUserDayGroupReport(DepartUserDeclarationReportReqDto reqDto)
			throws Exception {
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
		setStartAndEndDate(reqDto,param,true);
		
		List<ReportDto> list = reportDeclarationMapper.getDepartmentOrUserDayGroupReport(param);
		List<DepartmentUserReportDto> reportList = new ArrayList<DepartmentUserReportDto>();
		List<String> dayList = ReportDateUtils.getDayStrList(reqDto.getCustomStart(), reqDto.getCustomEnd());
		for (String day : dayList) {
			DepartmentUserReportDto reportDto = new DepartmentUserReportDto();
			reportList.add(reportDto);
			reportDto.setDate(day);
			reportDto.setSumDealAmount(0.0d);
			if (!BooleanUtils.isEmpty(list)) {
				for (ReportDto dto : list) {
					if (day.equals(dto.getDate())) {
						reportDto.setSumDealAmount(dto.getSumDealAmount());
					}
				}
			}
		}

		return reportList;
	}

	/**
	 * 查询报单列表 getDepartmentUserDeclarationDto:
	 * 
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
	private PaginationSupport<DepartmentUserDeclarationDto> getDepartmentUserDeclarationDto(
			DepartUserDeclarationReportReqDto reqDto) throws Exception {
		PaginationSupport<DepartmentUserDeclarationDto> page = new PaginationSupport<DepartmentUserDeclarationDto>();
		page.setCurrentPage(reqDto.getCurrentPage());
		page.setPageSize(reqDto.getPageSize());

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("offset", (reqDto.getCurrentPage() - 1) * reqDto.getPageSize());
		param.put("pageSize", reqDto.getPageSize());
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
		setStartAndEndDate(reqDto,param,false);
		
		int totalCount = reportDeclarationMapper.getDepartmentUserDeclarationDtoCount(param);
		if (totalCount > 0) {
			List<DepartmentUserDeclarationDto> datas = reportDeclarationMapper
					.getDepartmentUserDeclarationDtoPage(param);
			if(!BooleanUtils.isEmpty(datas)){
				for(DepartmentUserDeclarationDto dto: datas){
					dto.setDeclarationStatusText(DeclarationStatusEnum.getName(dto.getDeclarationStatus()));
				}
			}
			page.setDatas(datas);
		}
		page.setTotalCount(totalCount);

		return page;
	}

	/**
	 * 查询用户报单排名
	 * 
	 * @param departmentId
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	public Result<PaginationSupport<UserDeclarationRankResDto>> getUserRankPage(UserDeclarationRankReqDto reqDto)
			throws BaseException {
		PaginationSupport<UserDeclarationRankResDto> page = reqDto.getPaginationSupport();

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
		page.setTotalCount(reportDeclarationMapper.getUserDeclarationRankCount(reqDto));
		List<UserDeclarationRankResDto>  datas = reportDeclarationMapper.getUserDeclarationRankPage(reqDto);
		page.setDatas(datas);
		
		
		// 查询最大的一个
		reqDto.setCurrentPage(1);
		reqDto.setPageSize(1);
		List<UserDeclarationRankResDto>  maxList = reportDeclarationMapper.getUserDeclarationRankPage(reqDto);
		if(!BooleanUtils.isEmpty(maxList) && !BooleanUtils.isEmpty(datas)){
			UserDeclarationRankResDto max = maxList.get(0);
			for(UserDeclarationRankResDto dto : datas){
				dto.setMaxSumDealAmount(max.getSumDealAmount());
			}
		}
		
		return Result.newSuccessResult(page);
	}

}
