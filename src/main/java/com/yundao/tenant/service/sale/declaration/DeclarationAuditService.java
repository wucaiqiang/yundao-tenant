package com.yundao.tenant.service.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageResDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditReqDto;

/**
 * 报单审核服务接口
 *
 * @author jan
 * @create 2017-08-27 PM2:47
 **/
public interface DeclarationAuditService {

    /**
     * 报单审核分页数据
     */
    Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(DeclarationAuditPageReqDto dto) throws
            BaseException;

    /**
     * 审核
     */
    Result<Boolean> doAudit(DeclarationAuditReqDto dto) throws BaseException;

}
