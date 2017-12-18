package com.yundao.tenant.controller.customer.customerdetail;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.customer.customerdetail.CustomerDetailService;
import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.dto.customer.customerdetail.CustomerDetailReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.validator.group.Update;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/customer/detail/")
@ResponseBody
@Api("客户详情表")
public class CustomerDetailController{

    @Autowired
    private CustomerDetailService customerDetailService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询客户详情表")
    public Result<PaginationSupport<BaseCustomerDetail>> getPage(@ModelAttribute CustomerDetailReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return customerDetailService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增客户详情表", notes="根据CustomerDetail对象创建客户详情表")
    public Result<Integer> add(@Validated @ModelAttribute CustomerDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerDetailService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑客户详情表信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CustomerDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerDetailService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取客户详情表详细信息")
    public Result<BaseCustomerDetail> get(@RequestParam Long id) throws Exception{
       return customerDetailService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除客户详情表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return customerDetailService.delete(id);
    }

}
