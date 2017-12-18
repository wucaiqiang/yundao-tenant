package com.yundao.tenant.controller.user.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.dto.operation.visit.UserVisitAddReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitDetailForLeads;
import com.yundao.tenant.dto.user.visit.UserVisitDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageResDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.user.visit.UserVisitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户回访控制器
 *
 * @author jan
 * @create 2017-08-11 AM10:19
 **/
@Controller
@RequestMapping("/user/visit")
@ResponseBody
@Api("客户回访")
public class UserVisitController {

    @Autowired
    private UserVisitService userVisitService;

    @RequestMapping(value = "/get_page_for_customer_detail_personal", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面的回访数据 - 只获取自己的数据")
    public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPagePersonal(@Validated @ModelAttribute CustomerDetailVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getCustomerDetailVisitPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/get_page_for_customer_detail_department", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面的回访数据 - 获取部门的数据")
    public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPageDep(@Validated @ModelAttribute CustomerDetailVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getCustomerDetailVisitPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/get_page_for_customer_detail_public", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面的回访数据 - 获取所有数据")
    public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPagePublic(@Validated @ModelAttribute CustomerDetailVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getCustomerDetailVisitPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }


    @RequestMapping(value = "/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("分页数据 - 只获取自己的数据")
    public Result<PaginationSupport<UserVisitPageResDto>> getPagePersonal(@Validated @ModelAttribute UserVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/get_page_department", method = RequestMethod.GET)
    @ApiOperation("分页数据 - 获取部门的数据")
    public Result<PaginationSupport<UserVisitPageResDto>> getPageDep(@Validated @ModelAttribute UserVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/get_page_public", method = RequestMethod.GET)
    @ApiOperation("分页数据 - 获取所有数据")
    public Result<PaginationSupport<UserVisitPageResDto>> getPagePublic(@Validated @ModelAttribute UserVisitPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userVisitService.getPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation("回访")
    public Result<Long> doVisit(@Validated @ModelAttribute UserVisitAddReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        if (BooleanUtils.isEmpty(dto.getContent()))
            throw new BaseException(CodeConstant.CODE_1220068);
        if (dto.getContent().length() > 200)
            throw new BaseException(CodeConstant.CODE_1220069);
        return userVisitService.doVisit(dto);
    }

    @RequestMapping(value = "/get_detail_for_leads", method = RequestMethod.GET)
    @ApiOperation("获取销售线索页面回访详情")
    public Result<UserVisitDetailForLeads> getDetailForLeads(@RequestParam Long leadsId) throws BaseException {
        if (leadsId == null)
            throw new BaseException(CodeConstant.CODE_1220089);
        return userVisitService.getForLeads(leadsId);
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取回访详情")
    public Result<UserVisitDto> get(@RequestParam Long id) throws BaseException {
        if (id == null)
            throw new BaseException(CodeConstant.CODE_1200000);
        return userVisitService.get(id);
    }

}
