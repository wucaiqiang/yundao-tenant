package com.yundao.tenant.controller.product.examine;

import java.util.List;

import com.yundao.tenant.model.base.product.BaseProductExamine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.examine.ProductAuditRecordResDto;
import com.yundao.tenant.dto.product.examine.ProductAuditReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageResDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.examine.ProductExamineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品审核控制器
 *
 * @author jan
 * @create 2017-07-22 PM1:29
 **/
@Controller
@RequestMapping("/product/examine")
@ResponseBody
@Api(value = "产品审批")
public class ProductExamineController {

    @Autowired
    private ProductExamineService productExamineService;
    
    @Autowired
    private ProductSelectService productSelectService;

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取分页")
    public Result<PaginationSupport<ProductExaminePageResDto>> getPage(@Validated @ModelAttribute
                                                                               ProductExaminePageReqDto dto,
                                                                       BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return Result.newSuccessResult(productExamineService.getPage(dto));
    }

    @RequestMapping(value = "audit", method = RequestMethod.POST)
    @ApiOperation(value = "审批")
    public Result<Long> audit(@Validated @ModelAttribute ProductAuditReqDto dto, BindingResult bindingResult) throws
            BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return productExamineService.doAudit(dto);
    }

    @RequestMapping(value = "app_audit", method = RequestMethod.POST)
    @ApiOperation(value = "APP审批")
    public Result<Long> appAudit(@Validated @ModelAttribute ProductAuditReqDto dto, BindingResult bindingResult) throws
            BaseException {
        BindingResultHandler.handleByException(bindingResult);
        BaseProductExamine productExamine = productExamineService.getCurrentBaseProductExamine(dto.getId());
        if(productExamine == null){
            throw new BaseException(CodeConstant.CODE_1220031);
        }
        dto.setId(productExamine.getId());
        return productExamineService.doAudit(dto);
    }

    @ApiOperation(value = "查询审核历史记录")
    @RequestMapping(value = "get_history_audit_detail", method = RequestMethod.GET)
    public Result<List<ProductAuditRecordResDto>> getAuditDetail(@RequestParam Long productId)throws BaseException {
    	// 检查产品是否存在
    	if(productId == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200041);
    	}
    	BaseProduct baseProduct = productSelectService.getBaseProduct(productId);
        if (baseProduct == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200042);
        }
    	
    	return productExamineService.getAuditDetail(productId);
    }
}
