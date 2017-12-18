package com.yundao.tenant.controller.cc.ccuseraccount;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.cc.ccuseraccount.CcUserAccountService;
import com.yundao.tenant.model.base.cc.BaseCcUserAccount;
import com.yundao.tenant.dto.cc.ccuseraccount.CcUserAccountReqDto;
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
@RequestMapping(value = "/cc/user/account/")
@ResponseBody
@Api("投资用户账号表")
public class CcUserAccountController{

//    @Autowired
//    private CcUserAccountService ccUserAccountService;
//
//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询投资用户账号表")
//    public Result<PaginationSupport<BaseCcUserAccount>> getPage(@ModelAttribute CcUserAccountReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return ccUserAccountService.getPage(dto, pageDto);
//    }
//
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增投资用户账号表", notes="根据CcUserAccount对象创建投资用户账号表")
//    public Result<Integer> add(@Validated @ModelAttribute CcUserAccountReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccUserAccountService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑投资用户账号表信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CcUserAccountReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccUserAccountService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取投资用户账号表详细信息")
//    public Result<BaseCcUserAccount> get(@RequestParam Long id) throws Exception{
//       return ccUserAccountService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除投资用户账号表信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return ccUserAccountService.delete(id);
//    }

}
