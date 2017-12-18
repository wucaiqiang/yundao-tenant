package com.yundao.tenant.controller.sale.reservation;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageResDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditReqDto;
import com.yundao.tenant.service.sale.reservation.ReservationAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预约审核
 *
 * @author jan
 * @create 2017-08-23 PM6:18
 **/
@Controller
@RequestMapping("/reservation/audit")
@ResponseBody
@Api("预约审批")
public class ReservationAuditController {

    @Autowired
    private ReservationAuditService reservationAuditService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取预约审核分页数据")
    public Result<PaginationSupport<ReservationAuditPageResDto>> getPage(@ModelAttribute ReservationAuditPageReqDto dto)
            throws BaseException {
        return reservationAuditService.getPage(dto);
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation(value = "审批")
    public Result<Boolean> doAudit(@Validated @ModelAttribute ReservationAuditReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return reservationAuditService.doAudit(dto);
    }

}
