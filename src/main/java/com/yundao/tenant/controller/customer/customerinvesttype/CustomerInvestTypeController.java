package com.yundao.tenant.controller.customer.customerinvesttype;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.customer.customerinvesttype.CustomerInvestTypeService;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestType;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeReqDto;
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
@RequestMapping(value = "/customer/invest/type/")
@ResponseBody
@Api("客户投资偏好")
public class CustomerInvestTypeController{

//    @Autowired
//    private CustomerInvestTypeService customerInvestTypeService;
//
//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询客户投资偏好")
//    public Result<PaginationSupport<BaseCustomerInvestType>> getPage(@ModelAttribute CustomerInvestTypeReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return customerInvestTypeService.getPage(dto, pageDto);
//    }
//
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增客户投资偏好", notes="根据CustomerInvestType对象创建客户投资偏好")
//    public Result<Integer> add(@Validated @ModelAttribute CustomerInvestTypeReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return customerInvestTypeService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑客户投资偏好信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CustomerInvestTypeReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return customerInvestTypeService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取客户投资偏好详细信息")
//    public Result<BaseCustomerInvestType> get(@RequestParam Long id) throws Exception{
//       return customerInvestTypeService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除客户投资偏好信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return customerInvestTypeService.delete(id);
//    }

}
