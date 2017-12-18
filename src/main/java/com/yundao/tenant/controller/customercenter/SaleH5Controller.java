package com.yundao.tenant.controller.customercenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.tenant.dto.customercenter.MyIndexDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ResDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ResDto;
import com.yundao.tenant.service.customercenter.SaleH5Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@ResponseBody
@Api("H5报单和预约")
public class SaleH5Controller {

	@Autowired
	private SaleH5Service saleH5Service;

	@RequestMapping(value = "/declaration/h5/my/get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询我的报单")
	public Result<PaginationSupport<DeclarationH5ResDto>> getMyDeclaration(@ModelAttribute DeclarationH5ReqDto dto) throws Exception {
		HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		dto.setUserId(user.getUserId());
		return saleH5Service.getMyDeclaration(dto);
	}
	
	@RequestMapping(value = "/reservation/h5/my/get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询我的预约")
	public Result<PaginationSupport<ReservationH5ResDto>> getMyReservation(@ModelAttribute ReservationH5ReqDto dto) throws Exception {
		HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		dto.setUserId(user.getUserId());
		return saleH5Service.getMyReservation(dto);
	}
	
	@RequestMapping(value = "/get/h5/my/index", method = RequestMethod.GET)
	@ApiOperation(value = "获取我的首页信息")
	public Result<MyIndexDto> getMyIndex() throws Exception {
		HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		return saleH5Service.getMyIndex(user.getUserId());
	}

}