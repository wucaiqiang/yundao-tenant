package com.yundao.tenant.controller.product.productnoticetype;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.productnoticetype.ProductNoticeTypeReqDto;
import com.yundao.tenant.model.base.product.BaseProductNoticeType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.yundao.tenant.service.product.productnoticetype.ProductNoticeTypeService;

import java.util.List;

@RestController
@RequestMapping(value = "/productnoticetype/")
@ResponseBody
@Api("产品公告类型")
public class ProductNoticeTypeController{

    @Autowired
    private ProductNoticeTypeService productNoticeTypeService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询产品公告类型")
    public Result<PaginationSupport<BaseProductNoticeType>> getPage(@ModelAttribute ProductNoticeTypeReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
        BaseProductNoticeType model = new BaseProductNoticeType();
        BeanUtils.copyProperties(dto,model);
		return productNoticeTypeService.getPage(model, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增产品公告类型", notes="根据ProductNoticeType对象创建产品公告类型")
    public Result<Long> add(@Validated @ModelAttribute ProductNoticeTypeReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeType model = new BaseProductNoticeType();
        BeanUtils.copyProperties(dto,model);
        return productNoticeTypeService.add(model);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑产品公告类型信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute ProductNoticeTypeReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeType model = new BaseProductNoticeType();
        BeanUtils.copyProperties(dto,model);
        return productNoticeTypeService.update(model);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取产品公告类型详细信息")
    public Result<BaseProductNoticeType> get(@RequestParam Long id) throws Exception{
       return productNoticeTypeService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除产品公告类型信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return productNoticeTypeService.delete(id);
    }

    @RequestMapping(value = "get_all",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有产品公告类型")
    public Result<List<BaseProductNoticeType>> getAll() throws Exception{
        return productNoticeTypeService.getAll();
    }
}
