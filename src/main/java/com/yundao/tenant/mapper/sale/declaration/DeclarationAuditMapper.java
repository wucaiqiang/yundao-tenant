package com.yundao.tenant.mapper.sale.declaration;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageResDto;

import java.util.List;
import java.util.Map;

/**
 * 报单审核mapper
 */
public interface DeclarationAuditMapper {

    /**
     * 获取审核分页数据
     */
    List<DeclarationAuditPageResDto> selectAuditPage(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取审核分页数据总条数
     */
    int selectAuditPageCount(Map<String, Object> paramMap) throws BaseException;
}
