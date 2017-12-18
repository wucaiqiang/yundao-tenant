package com.yundao.tenant.controller.customer.customer;

import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationPageReqDto;
import com.yundao.tenant.model.sale.DeclarationModel;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.customer.CustomerSaleCountResDto;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationResDto;
import com.yundao.tenant.service.sale.reservation.ReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer/sale")
@ResponseBody
@Api("客户交易信息")
public class CustomerSaleController {

	@Autowired
	ReservationService reservationService;

	@Autowired
	DeclarationService declarationService;

    @RequestMapping(value = "gets_reservation", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户详情的交易信息-- 预约")
    public Result<PaginationSupport<CustomerSaleReservationResDto>> getReservations(@ModelAttribute CustomerSaleReservationReqDto dto) throws BaseException {
    	if(dto == null || dto.getCustomerId() == null){
    		return Result.newFailureResult(CodeConstant.CODE_1220047);
    	}
        return reservationService.getCustomerReservations(dto);
    }

    

    @RequestMapping(value = "get_count", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户详情的交易信息-- 预约和报单的个数")
    public Result<CustomerSaleCountResDto> getCount(@RequestParam Long customerId) throws Exception {
    	if(customerId == null){
    		return Result.newFailureResult(CodeConstant.CODE_1220047);
    	}
    	CustomerSaleCountResDto dto = new CustomerSaleCountResDto();
    	dto.setReservationCount(reservationService.getCustomerReservationCount(customerId));
    	dto.setDeclarationCount(declarationService.getCustomerCount(customerId).getResult());
        return Result.newSuccessResult(dto);
    }

	@RequestMapping(value = "/gets_declaration", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户详情的交易信息--报单")
	public Result<PaginationSupport<DeclarationModel>> getPage(@ModelAttribute DeclarationPageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception {
    	if(dto.getCustomerId() == null){
    		throw new BaseException(CodeConstant.CODE_1220047);
		}
		return declarationService.getPage(dto, pageDto);
	}
}
