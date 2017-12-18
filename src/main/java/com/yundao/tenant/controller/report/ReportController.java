
package com.yundao.tenant.controller.report;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.reservation.ReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年9月19日 下午2:24:01
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping(value = "/report/")
@ResponseBody
@Api("业绩模块")
public class ReportController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private DeclarationService declarationService;

	@RequestMapping(value = "get_reservation_total", method = RequestMethod.GET)
	@ApiOperation(value = "预约总额")
	public Result<Double> getReservationTotal(@RequestParam Date beginDate,@RequestParam Date endDate) throws BaseException {
		return reservationService.getReservationTotal(beginDate,endDate);
	}
	@RequestMapping(value = "get_declaration_total", method = RequestMethod.GET)
	@ApiOperation(value = "报单总额")
	public Result<Double> getDeclarationTotal(@RequestParam Date beginDate,@RequestParam Date endDate) throws BaseException {
		return declarationService.getDeclarationTotal(beginDate,endDate);
	}
	@RequestMapping(value = "get_reservation_rank", method = RequestMethod.GET)
	@ApiOperation(value = "理财师预约排名")
	public Result<List<AfpReportDto>> getReservationRank(@RequestParam Date beginDate,@RequestParam Date endDate,@RequestParam(defaultValue="3") Integer limit) throws BaseException {
		return reservationService.getReservationRank(beginDate,endDate,limit);
	}
	@RequestMapping(value = "get_declaration_rank", method = RequestMethod.GET)
	@ApiOperation(value = "理财师报单排名")
	public Result<List<AfpReportDto>> getDeclarationRank(@RequestParam Date beginDate,@RequestParam Date endDate,@RequestParam(defaultValue="3") Integer limit) throws BaseException {
		return declarationService.getDeclarationRank(beginDate, endDate, limit);
	}
}
