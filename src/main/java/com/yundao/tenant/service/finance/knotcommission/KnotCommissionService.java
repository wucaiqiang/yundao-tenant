package com.yundao.tenant.service.finance.knotcommission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.WorkflowAuditReqDto;
import com.yundao.tenant.dto.finance.knotcommission.*;
import com.yundao.tenant.dto.workflow.task.KnotCommissionTaskDto;
import com.yundao.tenant.model.base.finance.BaseKnotCommission;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;

import java.sql.SQLException;


public interface KnotCommissionService{


    public Result<Integer> add(KnotCommissionReqDto reqDto) throws Exception;


    public Result<Integer> update(KnotCommissionReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<KnotCommissionResDto> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseKnotCommission>> getPage(KnotCommissionListReqDto knotCommissionReqDto, AbstractBasePageDto pageDto) throws Exception;

    Result<PaginationSupport<DeclarationKnot>> getDeclarationPage(KnotCommissionPageReqDto dto, BasePageDto pageDto) throws Exception;

    Result<PaginationSupport<DeclarationAuditKnot>> getsAudit(KnotCommissionAuditPageReqDto dto, BasePageDto pageDto) throws BaseException, SQLException;

    Result<Integer> processAudit(WorkflowAuditReqDto dto) throws BaseException;
    
    public Result<KnotCommissionTaskDto> getTaskDto(Long id) throws Exception;
}
