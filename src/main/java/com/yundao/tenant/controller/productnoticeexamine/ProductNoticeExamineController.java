package com.yundao.tenant.controller.productnoticeexamine;
import org.springframework.beans.BeanUtils;
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
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExaminePageReqDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExamineReqDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExamineResDto;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;
import com.yundao.tenant.service.productnoticeexamine.ProductNoticeExamineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/productnoticeexamine/")
@ResponseBody
@Api("产品公告审批表")
public class ProductNoticeExamineController{

    @Autowired
    private ProductNoticeExamineService productNoticeExamineService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询产品公告审核表")
    public Result<PaginationSupport<ProductNoticeExamineResDto>> getPage(@ModelAttribute ProductNoticeExaminePageReqDto dto) throws Exception{
		return productNoticeExamineService.getPage(dto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增产品公告审核表", notes="根据ProductNoticeExamine对象创建产品公告审核表")
    public Result<Integer> add(@Validated @ModelAttribute ProductNoticeExamineReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeExamine model = new BaseProductNoticeExamine();
        BeanUtils.copyProperties(dto,model);
        return productNoticeExamineService.add(model);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑产品公告审核表信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute ProductNoticeExamineReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        BaseProductNoticeExamine model = new BaseProductNoticeExamine();
        BeanUtils.copyProperties(dto,model);
        return productNoticeExamineService.update(model);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取产品公告审核表详细信息")
    public Result<BaseProductNoticeExamine> get(@RequestParam Long id) throws Exception{
       return productNoticeExamineService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除产品公告审核表信息")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return productNoticeExamineService.delete(id);
    }

}
