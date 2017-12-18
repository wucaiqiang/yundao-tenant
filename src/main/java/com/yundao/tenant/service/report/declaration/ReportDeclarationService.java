

package com.yundao.tenant.service.report.declaration;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.report.declaration.ReportDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportDto;
import com.yundao.tenant.dto.report.declaration.DepartmentReportReqDto;
import com.yundao.tenant.dto.report.declaration.IndexTopDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 上午10:20:15 
 * @author   欧阳利
 * @version   
 */
public interface ReportDeclarationService {

	/**
	 * 获取最近6个月的业绩报单数据
	 * getIndexReportDtos:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<ReportDto> getIndexReportDtos()throws BaseException;
	
	/**
	 * 获取top的业绩信息
	 * indexTopDtos:
	 * @author: 欧阳利
	 * @param count
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<IndexTopDto> getIndexTopDtos(int count)throws BaseException;
	
	
	/**
	 * 获取部门业绩报表
	 * getDepartmentReportDtos:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<List<DepartmentReportDto>> getDepartmentReportDtos(DepartmentReportReqDto reqDto)throws BaseException;
}

