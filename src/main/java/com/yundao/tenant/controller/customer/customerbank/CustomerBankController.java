package com.yundao.tenant.controller.customer.customerbank;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.customer.customerbank.CustomerBankReqDto;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.service.customer.customerbank.CustomerBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer/bank/")
@ResponseBody
@Api("客户银行卡表")
public class CustomerBankController{

    @Autowired
    private CustomerBankService customerBankService;

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增客户银行卡表", notes="根据CustomerBank对象创建客户银行卡表")
    public Result<Long> add(@Validated(value = {Insert.class}) @ModelAttribute CustomerBankReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerBankService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑客户银行卡表信息")
    public Result<Long> update(@Validated(value = {Update.class}) @ModelAttribute CustomerBankReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerBankService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取客户银行卡表详细信息")
    public Result<CustomerBankReqDto> get(@RequestParam Long id) throws Exception{
       return customerBankService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除客户银行卡表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return customerBankService.delete(id);
    }

}
