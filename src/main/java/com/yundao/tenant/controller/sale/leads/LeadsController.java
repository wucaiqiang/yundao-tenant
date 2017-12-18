package com.yundao.tenant.controller.sale.leads;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.customer.CustomerIdReqDto;
import com.yundao.tenant.dto.sale.leads.*;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.sale.leads.LeadsStatusEnum;
import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.service.sale.leads.LeadsService;
import com.yundao.tenant.service.sale.leads.allot.LeadsAllotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 销售线索
 *
 * @author jan
 * @create 2017-09-06 PM7:59
 **/
@Controller
@ResponseBody
@RequestMapping("/leads")
@Api("销售线索")
public class LeadsController {

    @Autowired
    private LeadsService leadsService;

    @Autowired
    private LeadsAllotService leadsAllotService;

    @RequestMapping(value = "/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("获取分页数据")
    public Result<PaginationSupport<LeadsPageResDto>> getPagePersonal(@ModelAttribute LeadsPageReqDto dto) throws BaseException {
        return leadsService.getPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/get_page_department", method = RequestMethod.GET)
    @ApiOperation("获取分页数据")
    public Result<PaginationSupport<LeadsPageResDto>> getPageDep(@ModelAttribute LeadsPageReqDto dto) throws BaseException {
        return leadsService.getPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/get_page_public", method = RequestMethod.GET)
    @ApiOperation("获取分页数据")
    public Result<PaginationSupport<LeadsPageResDto>> getPagePublic(@ModelAttribute LeadsPageReqDto dto) throws BaseException {
        return leadsService.getPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

    @RequestMapping(value = "/customer/detail/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面销售线索列表")
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetailPersonal(@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsService.getPageForCustomerDetail(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/customer/detail/get_page_department", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面销售线索列表")
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetailDepartment(@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsService.getPageForCustomerDetail(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/customer/detail/get_page_public", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面销售线索列表")
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetailPublic(@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsService.getPageForCustomerDetail(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }


    @RequestMapping(value = "/get_unallot", method = RequestMethod.GET)
    @ApiOperation("获取客户的未分配线索")
    public Result<List<LeadsRemindResDto>> getUnAllot(@Validated @ModelAttribute CustomerIdReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsAllotService.getUnAllots(dto.getCustomerId());
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ApiOperation("处理销售线索")
    public Result<Long> updateStatus(@Validated @ModelAttribute LeadsUpdateStatusReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsService.updateStatus(dto);
    }

    @RequestMapping(value = "/try_allot", method = RequestMethod.POST)
    @ApiOperation("尝试分配回访")
    public Result<List<LeadsRemindResDto>> tryAllot(@Validated @ModelAttribute LeadsAllotReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        checkArgsForAllot(dto);
        return leadsAllotService.doTryAllot(dto);
    }

    @RequestMapping(value = "/allot", method = RequestMethod.POST)
    @ApiOperation("分配回访")
    public Result<Boolean> allot(@Validated @ModelAttribute LeadsAllotReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        checkArgsForAllot(dto);
        return leadsAllotService.doAllot(dto);
    }

    @RequestMapping(value = "/allot_to_fp", method = RequestMethod.POST)
    @ApiOperation("分配给理财师")
    public Result<Boolean> allotToFp(@Validated @ModelAttribute LeadsAllotToFpReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return leadsAllotService.doAllotToFp(dto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取线索")
    public Result<BaseLeads> allotToFp(@RequestParam Long id) throws BaseException {
        return Result.newSuccessResult(leadsAllotService.getById(id));
    }

    private void checkArgsForAllot(@Validated @ModelAttribute LeadsAllotReqDto dto) throws BaseException {
        if (BooleanUtils.isEmpty(dto.getMatter()))
            throw new BaseException(CodeConstant.CODE_1220095);
        if (dto.getMatter().length() > 100)
            throw new BaseException(CodeConstant.CODE_1220096);
    }
}
