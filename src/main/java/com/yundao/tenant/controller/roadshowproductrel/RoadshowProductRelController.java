package com.yundao.tenant.controller.roadshowproductrel;
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
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.roadshowproductrel.RoadshowProductRelReqDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRel;
import com.yundao.tenant.service.roadshowproductrel.RoadshowProductRelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/roadshow/product/rel/")
@ResponseBody
@Api("路演与产品关联表")
public class RoadshowProductRelController{

    @Autowired
    private RoadshowProductRelService roadshowProductRelService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询路演与产品关联表")
    public Result<PaginationSupport<BaseRoadshowProductRel>> getPage(@ModelAttribute RoadshowProductRelReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return roadshowProductRelService.getPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增路演与产品关联表", notes="根据RoadshowProductRel对象创建路演与产品关联表")
    public Result<Long> add(@Validated @ModelAttribute RoadshowProductRelReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowProductRelService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑路演与产品关联表信息")
    public Result<Long> update(@Validated(value = {Update.class}) @ModelAttribute RoadshowProductRelReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowProductRelService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取路演与产品关联表详细信息")
    public Result<BaseRoadshowProductRel> get(@RequestParam Long id) throws Exception{
       return roadshowProductRelService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除路演与产品关联表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return roadshowProductRelService.delete(id);
    }

}
