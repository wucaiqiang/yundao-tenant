package com.yundao.tenant.controller.customer.customeranniversaries;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.customer.customeranniversaries.CustomerAnniversariesService;
import com.yundao.tenant.model.base.customer.BaseCustomerAnniversaries;
import com.yundao.tenant.dto.customer.customeranniversaries.CustomerAnniversariesReqDto;
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

import java.util.List;

@RestController
@RequestMapping(value = "/customer/anniversaries/")
@ResponseBody
@Api("客户纪念日表")
public class CustomerAnniversariesController{

    @Autowired
    private CustomerAnniversariesService customerAnniversariesService;

//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询客户纪念日表")
//    public Result<PaginationSupport<BaseCustomerAnniversaries>> getPage(@ModelAttribute CustomerAnniversariesReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return customerAnniversariesService.getPage(dto, pageDto);
//    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增客户纪念日表", notes="根据CustomerAnniversaries对象创建客户纪念日表")
    public Result<Integer> add(@Validated @ModelAttribute CustomerAnniversariesReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerAnniversariesService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑客户纪念日表信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CustomerAnniversariesReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return customerAnniversariesService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取客户纪念日表详细信息")
    public Result<BaseCustomerAnniversaries> get(@RequestParam Long id) throws Exception{
       return customerAnniversariesService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除客户纪念日表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return customerAnniversariesService.delete(id);
    }

    @RequestMapping(value = "get_byCustomerId",method=RequestMethod.GET)
    @ApiOperation(value="条件查询客户纪念日表")
    public Result<List<BaseCustomerAnniversaries>> getByCustomerId(@RequestParam(name = "customerId") Long customerId) throws Exception{
        return customerAnniversariesService.getByCustomerId(customerId);
    }
}
