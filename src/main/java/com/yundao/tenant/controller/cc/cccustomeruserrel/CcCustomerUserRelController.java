package com.yundao.tenant.controller.cc.cccustomeruserrel;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;
import com.yundao.tenant.dto.cc.cccustomeruserrel.CcCustomerUserRelReqDto;
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
@RequestMapping(value = "/cc/customer/user/rel/")
@ResponseBody
@Api("客户用户关系")
public class CcCustomerUserRelController{

    @Autowired
    private CcCustomerUserRelService ccCustomerUserRelService;

//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询客户用户关系")
//    public Result<PaginationSupport<BaseCcCustomerUserRel>> getPage(@ModelAttribute CcCustomerUserRelReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return ccCustomerUserRelService.getPage(dto, pageDto);
//    }
//
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增客户用户关系", notes="根据CcCustomerUserRel对象创建客户用户关系")
//    public Result<Integer> add(@Validated @ModelAttribute CcCustomerUserRelReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccCustomerUserRelService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑客户用户关系信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CcCustomerUserRelReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccCustomerUserRelService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取客户用户关系详细信息")
//    public Result<BaseCcCustomerUserRel> get(@RequestParam Long id) throws Exception{
//       return ccCustomerUserRelService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除客户用户关系信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return ccCustomerUserRelService.delete(id);
//    }

}
