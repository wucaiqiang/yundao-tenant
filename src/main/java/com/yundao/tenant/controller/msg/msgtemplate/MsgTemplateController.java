package com.yundao.tenant.controller.msg.msgtemplate;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.msg.msgtemplate.MsgTemplateService;
import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.dto.msg.msgtemplate.MsgTemplateReqDto;
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
@RequestMapping(value = "/msg/template/")
@ResponseBody
@Api("动态模板")
public class MsgTemplateController{

    @Autowired
    private MsgTemplateService msgTemplateService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询动态模板")
    public Result<PaginationSupport<BaseMsgTemplate>> getPage(@ModelAttribute MsgTemplateReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return msgTemplateService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增动态模板", notes="根据MsgTemplate对象创建动态模板")
    public Result<Integer> add(@Validated @ModelAttribute MsgTemplateReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑动态模板信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute MsgTemplateReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return msgTemplateService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取动态模板详细信息")
    public Result<BaseMsgTemplate> get(@RequestParam Long id) throws Exception{
       return msgTemplateService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除动态模板信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return msgTemplateService.delete(id);
    }

}
