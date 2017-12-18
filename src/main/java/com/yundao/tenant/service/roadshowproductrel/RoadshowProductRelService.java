package com.yundao.tenant.service.roadshowproductrel;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.roadshowproductrel.RoadshowProductRelReqDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRel;


public interface RoadshowProductRelService{


    public Result<Long> add(RoadshowProductRelReqDto reqDto) throws Exception;


    public Result<Long> update(RoadshowProductRelReqDto reqDto) throws Exception;
    public Result<Long> updateByProductIdAndRoadShowId(RoadshowProductRelReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseRoadshowProductRel> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseRoadshowProductRel>> getPage(RoadshowProductRelReqDto roadshowProductRelReqDto, AbstractBasePageDto pageDto) throws Exception;

}
