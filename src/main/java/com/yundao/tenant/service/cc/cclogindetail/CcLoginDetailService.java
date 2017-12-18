package com.yundao.tenant.service.cc.cclogindetail;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.cc.BaseCcLoginDetail;
import com.yundao.tenant.dto.cc.cclogindetail.CcLoginDetailReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface CcLoginDetailService{


    public Result<Integer> add(CcLoginDetailReqDto reqDto) throws Exception;


    public Result<Integer> update(CcLoginDetailReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcLoginDetail> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcLoginDetail>> getPage(CcLoginDetailReqDto ccLoginDetailReqDto, AbstractBasePageDto pageDto) throws Exception;

}
