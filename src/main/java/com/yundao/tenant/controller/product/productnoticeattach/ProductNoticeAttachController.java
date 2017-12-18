package com.yundao.tenant.controller.product.productnoticeattach;
import com.yundao.tenant.dto.AbstractBasePageDto;

import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.productnoticeattach.ProductNoticeAttachReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.validator.group.Update;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;

import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import com.yundao.tenant.service.product.productnoticeattach.ProductNoticeAttachService;

@RestController
@RequestMapping(value = "/productnoticeattach/")
@ResponseBody
@Api("产品公告附件")
public class ProductNoticeAttachController{

    @Autowired
    private ProductNoticeAttachService productNoticeAttachService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询产品公告附件")
    public Result<PaginationSupport<BaseProductNoticeAttach>> getPage(@ModelAttribute ProductNoticeAttachReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
        BaseProductNoticeAttach model = new BaseProductNoticeAttach();
        BeanUtils.copyProperties(dto,model);
		return productNoticeAttachService.getPage(model, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增产品公告附件", notes="根据ProductNoticeAttach对象创建产品公告附件")
    public Result<Integer> add(@Validated @ModelAttribute ProductNoticeAttachReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeAttach model = new BaseProductNoticeAttach();
        BeanUtils.copyProperties(dto,model);
        return productNoticeAttachService.add(model);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑产品公告附件信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute ProductNoticeAttachReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeAttach model = new BaseProductNoticeAttach();
        BeanUtils.copyProperties(dto,model);
        return productNoticeAttachService.update(model);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取产品公告附件详细信息")
    public Result<BaseProductNoticeAttach> get(@RequestParam Long id) throws Exception{
       return productNoticeAttachService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除产品公告附件信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return productNoticeAttachService.delete(id);
    }

}
