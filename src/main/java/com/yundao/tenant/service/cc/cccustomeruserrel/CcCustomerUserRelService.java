package com.yundao.tenant.service.cc.cccustomeruserrel;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cc.cccustomeruserrel.CcCustomerUserRelReqDto;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;


public interface CcCustomerUserRelService{


    public Result<Integer> add(CcCustomerUserRelReqDto reqDto) throws Exception;


    public Result<Integer> update(CcCustomerUserRelReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcCustomerUserRel> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcCustomerUserRel>> getPage(CcCustomerUserRelReqDto ccCustomerUserRelReqDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 通过客户id查询对应的用户id(投资者id)
     * getUserIdByCustomerId:
     * @author: 欧阳利
     * @param customerId
     * @return
     * @throws BaseException
     * @description:
     */
    public Long getUserIdByCustomerId(Long customerId) throws BaseException;
    
    
    public Long getCustomerIdByUserId(Long UserId) throws BaseException;
}
