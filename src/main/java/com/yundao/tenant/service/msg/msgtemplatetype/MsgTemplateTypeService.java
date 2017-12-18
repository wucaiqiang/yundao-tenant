package com.yundao.tenant.service.msg.msgtemplatetype;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateType;
import com.yundao.tenant.dto.msg.msgtemplatetype.MsgTemplateTypeReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface MsgTemplateTypeService{


    public Result<Integer> add(MsgTemplateTypeReqDto reqDto) throws Exception;


    public Result<Integer> update(MsgTemplateTypeReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseMsgTemplateType> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseMsgTemplateType>> getPage(MsgTemplateTypeReqDto msgTemplateTypeReqDto, AbstractBasePageDto pageDto) throws Exception;

}
