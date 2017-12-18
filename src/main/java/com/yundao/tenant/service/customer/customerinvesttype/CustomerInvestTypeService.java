package com.yundao.tenant.service.customer.customerinvesttype;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeReqDto;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestType;


public interface CustomerInvestTypeService{


    public Result<Integer> add(CustomerInvestTypeReqDto reqDto) throws Exception;


    public Result<Integer> update(CustomerInvestTypeReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;
    public Result<Integer> deleteByCustomerId(Long customerId) throws Exception;


    public Result<BaseCustomerInvestType> get(Long id) throws Exception;
    public Result<List<CustomerInvestTypeDto>> getByCustomerId(Long customerId) throws Exception;

    public Result<PaginationSupport<BaseCustomerInvestType>> getPage(CustomerInvestTypeReqDto customerInvestTypeReqDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 新增客户投资偏好
     * @param customerId
     * @param investTypes
     * @return
     */
    Result<Boolean> addCustomerInvest(Long customerId,String investTypes) throws BaseException;

}
