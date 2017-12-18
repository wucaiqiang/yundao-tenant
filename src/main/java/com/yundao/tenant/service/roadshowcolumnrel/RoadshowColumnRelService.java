package com.yundao.tenant.service.roadshowcolumnrel;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.roadshowcolumnrel.RoadshowColumnRelReqDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRel;


public interface RoadshowColumnRelService{


    public Result<Long> add(RoadshowColumnRelReqDto reqDto) throws Exception;


    public Result<Long> update(RoadshowColumnRelReqDto reqDto) throws Exception;
    public Result<Long> updateByColumnIdsAndRoadShowId(String columnIds,Long roadShowId) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseRoadshowColumnRel> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseRoadshowColumnRel>> getPage(RoadshowColumnRelReqDto roadshowColumnRelReqDto, AbstractBasePageDto pageDto) throws Exception;

}
