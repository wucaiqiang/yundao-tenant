package com.yundao.tenant.controller.msg.msgtemplatetyperef;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.msg.msgtemplatetyperef.MsgTemplateTypeRefService;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRef;
import com.yundao.tenant.dto.msg.msgtemplatetyperef.MsgTemplateTypeRefReqDto;
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
@RequestMapping(value = "/msg/template/type/ref/")
@ResponseBody
@Api("模板类型关联关系表")
public class MsgTemplateTypeRefController{

    @Autowired
    private MsgTemplateTypeRefService msgTemplateTypeRefService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询模板类型关联关系表")
    public Result<PaginationSupport<BaseMsgTemplateTypeRef>> getPage(@ModelAttribute MsgTemplateTypeRefReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return msgTemplateTypeRefService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增模板类型关联关系表", notes="根据MsgTemplateTypeRef对象创建模板类型关联关系表")
    public Result<Integer> add(@Validated @ModelAttribute MsgTemplateTypeRefReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateTypeRefService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑模板类型关联关系表信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute MsgTemplateTypeRefReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateTypeRefService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取模板类型关联关系表详细信息")
    public Result<BaseMsgTemplateTypeRef> get(@RequestParam Long id) throws Exception{
       return msgTemplateTypeRefService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除模板类型关联关系表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return msgTemplateTypeRefService.delete(id);
    }

}
