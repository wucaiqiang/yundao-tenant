package com.yundao.tenant.controller.roadshow;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.roadshow.RoadshowAddReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowDetailResDto;
import com.yundao.tenant.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.dto.roadshow.RoadshowUpdateReqDto;
import com.yundao.tenant.service.roadshow.RoadshowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/roadshow/")
@ResponseBody
@Api("路演表")
public class RoadshowController{

    @Autowired
    private RoadshowService roadshowService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询路演表")
    public Result<PaginationSupport<RoadshowResDto>> getPage(@ModelAttribute RoadshowReqDto dto) throws Exception{
		return roadshowService.getPage(dto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增路演表", notes="根据Roadshow对象创建路演表")
    public Result<Long> add(@Validated @ModelAttribute RoadshowAddReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑路演表信息")
    public Result<Long> update(@Validated @ModelAttribute RoadshowUpdateReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取路演表详细信息")
    public Result<RoadshowDetailResDto> get(@RequestParam Long id) throws Exception{
       return roadshowService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除路演表信息")
    public Result<Integer> delete(@RequestParam String ids) throws Exception{
        return roadshowService.delete(ids);
    }

}
