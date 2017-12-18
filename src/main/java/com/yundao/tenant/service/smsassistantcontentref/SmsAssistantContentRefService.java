package com.yundao.tenant.service.smsassistantcontentref;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.smsassistantcontentref.SmsAssistantContentRefReqDto;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRef;


public interface SmsAssistantContentRefService{


    public Result<Integer> add(SmsAssistantContentRefReqDto reqDto) throws Exception;


    public Result<Integer> update(SmsAssistantContentRefReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseSmsAssistantContentRef> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseSmsAssistantContentRef>> getPage(SmsAssistantContentRefReqDto smsAssistantContentRefReqDto, AbstractBasePageDto pageDto) throws Exception;

}
