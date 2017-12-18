package com.yundao.tenant.service.customer.customerdetail;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.dto.customer.customerdetail.CustomerDetailReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface CustomerDetailService{


    public Result<Integer> add(CustomerDetailReqDto reqDto) throws Exception;


    public Result<Integer> update(CustomerDetailReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCustomerDetail> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCustomerDetail>> getPage(CustomerDetailReqDto customerDetailReqDto, AbstractBasePageDto pageDto) throws Exception;

}
