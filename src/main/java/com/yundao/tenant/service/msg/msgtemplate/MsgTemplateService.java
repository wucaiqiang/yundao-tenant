package com.yundao.tenant.service.msg.msgtemplate;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.dto.msg.msgtemplate.MsgTemplateReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface MsgTemplateService{


    public Result<Integer> add(MsgTemplateReqDto reqDto) throws Exception;


    public Result<Integer> update(MsgTemplateReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseMsgTemplate> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseMsgTemplate>> getPage(MsgTemplateReqDto msgTemplateReqDto, AbstractBasePageDto pageDto) throws Exception;

}
