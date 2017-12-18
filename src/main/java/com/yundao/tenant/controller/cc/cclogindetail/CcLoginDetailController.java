package com.yundao.tenant.controller.cc.cclogindetail;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.cc.cclogindetail.CcLoginDetailService;
import com.yundao.tenant.model.base.cc.BaseCcLoginDetail;
import com.yundao.tenant.dto.cc.cclogindetail.CcLoginDetailReqDto;
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
@RequestMapping(value = "/cc/login/detail/")
@ResponseBody
@Api("登录详情")
public class CcLoginDetailController{

    @Autowired
    private CcLoginDetailService ccLoginDetailService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询登录详情")
    public Result<PaginationSupport<BaseCcLoginDetail>> getPage(@ModelAttribute CcLoginDetailReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return ccLoginDetailService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增登录详情", notes="根据CcLoginDetail对象创建登录详情")
    public Result<Integer> add(@Validated @ModelAttribute CcLoginDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return ccLoginDetailService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑登录详情信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CcLoginDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return ccLoginDetailService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取登录详情详细信息")
    public Result<BaseCcLoginDetail> get(@RequestParam Long id) throws Exception{
       return ccLoginDetailService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除登录详情信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return ccLoginDetailService.delete(id);
    }

}
