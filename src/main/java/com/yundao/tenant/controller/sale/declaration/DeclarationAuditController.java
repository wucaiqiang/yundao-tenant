package com.yundao.tenant.controller.sale.declaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageResDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditReqDto;
import com.yundao.tenant.service.sale.declaration.DeclarationAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 报单审核
 *
 * @author jan
 * @create 2017-08-27 PM2:46
 **/
@RestController
@RequestMapping(value = "/declaration/audit")
@ResponseBody
@Api("报单审批")
public class DeclarationAuditController {

    @Autowired
    private DeclarationAuditService declarationAuditService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "查询分页数据")
    public Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(@ModelAttribute DeclarationAuditPageReqDto dto) throws Exception {
        return declarationAuditService.getPage(dto);
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation(value = "审批")
    public Result<Boolean> getPage(@Validated @ModelAttribute DeclarationAuditReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return declarationAuditService.doAudit(dto);
    }

}
