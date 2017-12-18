package com.yundao.tenant.controller.customer.pool;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageResDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.customer.pool.CustomerPoolService;
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
 * 客户池控制器
 *
 * @author jan
 * @create 2017-08-14 AM8:50
 **/
@Controller
@RequestMapping("/customer/pool")
@ResponseBody
@Api("客户池")
public class CustomerPoolController {

    @Autowired
    private CustomerPoolService customerPoolService;

    @RequestMapping(value = "/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("获取客户池分页数据数据 - 只获取自己的客户")
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPagePersonal(@Validated @ModelAttribute CustomerPoolPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerPoolService.getPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/get_page_department", method = RequestMethod.GET)
    @ApiOperation("获取客户池分页数据数据 - 获取部门客户数据")
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPageDepartment(@Validated @ModelAttribute CustomerPoolPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerPoolService.getPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/get_page_public", method = RequestMethod.GET)
    @ApiOperation("获取客户池分页数据数据 - 获取所有客户数据")
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPagePublic(@Validated @ModelAttribute CustomerPoolPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerPoolService.getPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

}
