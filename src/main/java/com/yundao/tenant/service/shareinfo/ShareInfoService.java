package com.yundao.tenant.service.shareinfo;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.shareinfo.ShareInfoReqDto;
import com.yundao.tenant.model.base.BaseShareInfo;


public interface ShareInfoService{


    public Result<Integer> add(ShareInfoReqDto reqDto) throws Exception;


    public Result<Integer> update(ShareInfoReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseShareInfo> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseShareInfo>> getPage(ShareInfoReqDto shareInfoReqDto, AbstractBasePageDto pageDto) throws Exception;

}
