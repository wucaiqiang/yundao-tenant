package com.yundao.tenant.controller.videotranscode;
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
import com.yundao.tenant.dto.videotranscode.VideoTranscodeReqDto;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;
import com.yundao.tenant.service.videotranscode.VideoTranscodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/video/transcode/")
@ResponseBody
@Api("视频转码")
public class VideoTranscodeController{

    @Autowired
    private VideoTranscodeService videoTranscodeService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询")
    public Result<PaginationSupport<BaseVideoTranscode>> getPage(@ModelAttribute VideoTranscodeReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return videoTranscodeService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增", notes="根据VideoTranscode对象创建")
    public Result<Integer> add(@Validated @ModelAttribute VideoTranscodeReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return videoTranscodeService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute VideoTranscodeReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return videoTranscodeService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取详细信息")
    public Result<BaseVideoTranscode> get(@RequestParam Long id) throws Exception{
       return videoTranscodeService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return videoTranscodeService.delete(id);
    }

}
