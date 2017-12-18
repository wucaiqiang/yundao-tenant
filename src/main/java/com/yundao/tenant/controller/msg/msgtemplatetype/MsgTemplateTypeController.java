package com.yundao.tenant.controller.msg.msgtemplatetype;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.msg.msgtemplatetype.MsgTemplateTypeService;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateType;
import com.yundao.tenant.dto.msg.msgtemplatetype.MsgTemplateTypeReqDto;
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
@RequestMapping(value = "/msg/template/type/")
@ResponseBody
@Api("模板类型表")
public class MsgTemplateTypeController{

    @Autowired
    private MsgTemplateTypeService msgTemplateTypeService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询模板类型表")
    public Result<PaginationSupport<BaseMsgTemplateType>> getPage(@ModelAttribute MsgTemplateTypeReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return msgTemplateTypeService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增模板类型表", notes="根据MsgTemplateType对象创建模板类型表")
    public Result<Integer> add(@Validated @ModelAttribute MsgTemplateTypeReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateTypeService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑模板类型表信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute MsgTemplateTypeReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateTypeService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取模板类型表详细信息")
    public Result<BaseMsgTemplateType> get(@RequestParam Long id) throws Exception{
       return msgTemplateTypeService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除模板类型表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return msgTemplateTypeService.delete(id);
    }

}
