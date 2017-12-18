package com.yundao.tenant.service.customer.customeranniversaries;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.customer.BaseCustomerAnniversaries;
import com.yundao.tenant.dto.customer.customeranniversaries.CustomerAnniversariesReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;

import java.util.List;


public interface CustomerAnniversariesService{


    public Result<Integer> add(CustomerAnniversariesReqDto reqDto) throws Exception;


    public Result<Integer> update(CustomerAnniversariesReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCustomerAnniversaries> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCustomerAnniversaries>> getPage(CustomerAnniversariesReqDto customerAnniversariesReqDto, AbstractBasePageDto pageDto) throws Exception;

    Result<List<BaseCustomerAnniversaries>> getByCustomerId(Long customerId) throws BaseException;
}
