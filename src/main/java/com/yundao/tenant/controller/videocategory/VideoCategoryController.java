package com.yundao.tenant.controller.videocategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.videocategory.VideoCategoryReqDto;
import com.yundao.tenant.model.base.video.BaseVideoCategory;
import com.yundao.tenant.service.videocategory.VideoCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/video/category/")
@ResponseBody
@Api("视频分类管理")
public class VideoCategoryController{

    @Autowired
    private VideoCategoryService videoCategoryService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询")
    public Result<PaginationSupport<BaseVideoCategory>> getPage(@ModelAttribute VideoCategoryReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return videoCategoryService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增", notes="根据VideoCategory对象创建")
    public Result<Integer> add(@Validated @ModelAttribute VideoCategoryReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return videoCategoryService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute VideoCategoryReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return videoCategoryService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取详细信息")
    public Result<BaseVideoCategory> get(@RequestParam Long id) throws Exception{
       return videoCategoryService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return videoCategoryService.delete(id);
    }

}
