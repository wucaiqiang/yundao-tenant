package com.yundao.tenant.service.customer.customerfollowup;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageResDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpReqDto;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;


public interface CustomerFollowUpService {


    Result<Long> add(CustomerFollowUpReqDto reqDto) throws Exception;


    Result<Integer> update(CustomerFollowUpReqDto reqDto) throws Exception;


    Result<Integer> delete(Long id) throws Exception;


    Result<BaseCustomerFollowUp> get(Long id) throws Exception;

    Result<PaginationSupport<CustomerFollowUpPageResDto>> getPage(CustomerFollowUpPageDto dto, Integer permission) throws Exception;

    Result<Long> processFollow() throws Exception;
}
