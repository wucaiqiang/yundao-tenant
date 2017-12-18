package com.yundao.tenant.service.videocategory;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.videocategory.VideoCategoryReqDto;
import com.yundao.tenant.model.base.video.BaseVideoCategory;


public interface VideoCategoryService{


    public Result<Integer> add(VideoCategoryReqDto reqDto) throws Exception;


    public Result<Integer> update(VideoCategoryReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseVideoCategory> get(Long id) throws Exception;
    public BaseVideoCategory getOne() throws BaseException;

    public Result<PaginationSupport<BaseVideoCategory>> getPage(VideoCategoryReqDto videoCategoryReqDto, AbstractBasePageDto pageDto) throws Exception;

}
