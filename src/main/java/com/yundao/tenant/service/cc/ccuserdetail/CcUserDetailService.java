package com.yundao.tenant.service.cc.ccuserdetail;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserDetailReqDto;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserInfoDto;
import com.yundao.tenant.model.base.cc.BaseCcUserDetail;


public interface CcUserDetailService {


    public Result<Integer> add(CcUserDetailReqDto reqDto) throws Exception;


    public Result<Integer> update(CcUserDetailReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcUserDetail> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcUserDetail>> getPage(CcUserDetailReqDto ccUserDetailReqDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 获取理财用户的信息
     */
    Result<CcUserInfoDto> getInfo() throws BaseException;
}
