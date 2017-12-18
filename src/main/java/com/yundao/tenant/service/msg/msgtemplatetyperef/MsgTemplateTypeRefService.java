package com.yundao.tenant.service.msg.msgtemplatetyperef;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRef;
import com.yundao.tenant.dto.msg.msgtemplatetyperef.MsgTemplateTypeRefReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface MsgTemplateTypeRefService{


    public Result<Integer> add(MsgTemplateTypeRefReqDto reqDto) throws Exception;


    public Result<Integer> update(MsgTemplateTypeRefReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseMsgTemplateTypeRef> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseMsgTemplateTypeRef>> getPage(MsgTemplateTypeRefReqDto msgTemplateTypeRefReqDto, AbstractBasePageDto pageDto) throws Exception;

}
