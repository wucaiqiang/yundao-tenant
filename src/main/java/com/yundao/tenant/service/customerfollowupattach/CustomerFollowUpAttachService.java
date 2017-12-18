package com.yundao.tenant.service.customerfollowupattach;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customerfollowupattach.CustomerFollowUpAttachReqDto;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttach;


public interface CustomerFollowUpAttachService{


    public Result<Integer> add(CustomerFollowUpAttachReqDto reqDto) throws Exception;


    public Result<Integer> update(CustomerFollowUpAttachReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCustomerFollowUpAttach> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCustomerFollowUpAttach>> getPage(CustomerFollowUpAttachReqDto customerFollowUpAttachReqDto, AbstractBasePageDto pageDto) throws Exception;

}
