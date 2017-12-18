package com.yundao.tenant.controller.finance.knotcommission;
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
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.WorkflowAuditReqDto;
import com.yundao.tenant.dto.finance.knotcommission.DeclarationAuditKnot;
import com.yundao.tenant.dto.finance.knotcommission.DeclarationKnot;
import com.yundao.tenant.dto.finance.knotcommission.KnotCommissionAuditPageReqDto;
import com.yundao.tenant.dto.finance.knotcommission.KnotCommissionListReqDto;
import com.yundao.tenant.dto.finance.knotcommission.KnotCommissionPageReqDto;
import com.yundao.tenant.dto.finance.knotcommission.KnotCommissionReqDto;
import com.yundao.tenant.dto.finance.knotcommission.KnotCommissionResDto;
import com.yundao.tenant.dto.workflow.task.KnotCommissionTaskDto;
import com.yundao.tenant.model.base.finance.BaseKnotCommission;
import com.yundao.tenant.service.finance.knotcommission.KnotCommissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/knot/commission/")
@ResponseBody
@Api("结佣记录表")
public class KnotCommissionController{

    @Autowired
    private KnotCommissionService knotCommissionService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询结佣记录表")
    public Result<PaginationSupport<BaseKnotCommission>> getPage(@Validated @ModelAttribute KnotCommissionListReqDto dto, BindingResult bindingResult, @ModelAttribute BasePageDto pageDto) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
		return knotCommissionService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "get_declaration_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询报单结佣记录表")
    public Result<PaginationSupport<DeclarationKnot>> getDeclarationPage(@ModelAttribute KnotCommissionPageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return knotCommissionService.getDeclarationPage(dto, pageDto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增结佣记录表", notes="根据KnotCommission对象创建结佣记录表")
    public Result<Integer> add(@Validated @ModelAttribute KnotCommissionReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return knotCommissionService.add(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="通过报单ID获取结佣记录表详细信息")
    public Result<KnotCommissionResDto> get(@RequestParam Long declarationId) throws Exception{
       return knotCommissionService.get(declarationId);
    }

    @RequestMapping(value = "get_task", method=RequestMethod.GET)
    @ApiOperation(value="通过佣金id查询任务信息")
    public Result<KnotCommissionTaskDto> getTaskDto(Long id) throws Exception{
        return knotCommissionService.getTaskDto(id);
    }
    
    
    @RequestMapping(value = "gets_audit", method=RequestMethod.GET)
    @ApiOperation(value="通过报单ID获取结佣记录表详细信息")
    public Result<PaginationSupport<DeclarationAuditKnot>> getsAudit(@ModelAttribute KnotCommissionAuditPageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
        return knotCommissionService.getsAudit(dto,pageDto);
    }

    @RequestMapping(value = "audit", method=RequestMethod.POST)
    @ApiOperation(value="审批")
    public Result<Integer> audit(@Validated @ModelAttribute WorkflowAuditReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return knotCommissionService.processAudit(dto);
    }

//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除结佣记录表信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return knotCommissionService.delete(id);
//    }

}
