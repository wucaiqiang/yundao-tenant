package com.yundao.tenant.service.cc.cclogin;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.cc.BaseCcLogin;
import com.yundao.tenant.dto.cc.cclogin.CcLoginReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface CcLoginService{


    public Result<Integer> add(CcLoginReqDto reqDto) throws Exception;


    public Result<Integer> update(CcLoginReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcLogin> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcLogin>> getPage(CcLoginReqDto ccLoginReqDto, AbstractBasePageDto pageDto) throws Exception;

}
