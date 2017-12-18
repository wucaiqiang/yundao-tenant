package com.yundao.tenant.controller.shareinfo;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.service.shareinfo.ShareInfoService;
import com.yundao.tenant.model.base.BaseShareInfo;
import com.yundao.tenant.dto.shareinfo.ShareInfoReqDto;
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
@RequestMapping(value = "/share/info/")
@ResponseBody
@Api("分享信息")
public class ShareInfoController{

    @Autowired
    private ShareInfoService shareInfoService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询分享信息")
    public Result<PaginationSupport<BaseShareInfo>> getPage(@ModelAttribute ShareInfoReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return shareInfoService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增分享信息", notes="根据ShareInfo对象创建分享信息")
    public Result<Integer> add(@Validated @ModelAttribute ShareInfoReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return shareInfoService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑分享信息信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute ShareInfoReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return shareInfoService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取分享信息详细信息")
    public Result<BaseShareInfo> get(@RequestParam Long id) throws Exception{
       return shareInfoService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除分享信息信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return shareInfoService.delete(id);
    }

}
