package com.yundao.tenant.service.customer.customerbank;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customer.bank.CustomerBankListDto;
import com.yundao.tenant.dto.customer.customerbank.CustomerBankReqDto;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;

import java.util.List;


public interface CustomerBankService {


    public Result<Long> add(CustomerBankReqDto reqDto) throws Exception;


    public Result<Long> update(CustomerBankReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;

    public Result<Integer> deleteByCustomerId(Long customerId) throws Exception;


    public Result<CustomerBankReqDto> get(Long id) throws Exception;

    public Result<List<CustomerBankListDto>> getByCustomerId(Long customerId) throws Exception;

}
