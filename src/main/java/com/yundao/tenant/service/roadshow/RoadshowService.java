package com.yundao.tenant.service.roadshow;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.roadshow.RoadshowAddReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowDetailResDto;
import com.yundao.tenant.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.dto.roadshow.RoadshowUpdateReqDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshow;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;


public interface RoadshowService{


    public Result<Long> add(RoadshowAddReqDto reqDto) throws Exception;


    public Result<Long> update(RoadshowUpdateReqDto reqDto) throws Exception;


    public Result<Integer> delete(String ids) throws Exception;


    public Result<RoadshowDetailResDto> get(Long id) throws Exception;
    public Result<List<RoadshowResDto>> getByProductId(Long productId) throws Exception;
    public List<BaseRoadshowColumn> getRoadshowColumn(Long roadshowId) throws BaseException ;

    public Result<PaginationSupport<RoadshowResDto>> getPage(RoadshowReqDto roadshowReqDto) throws Exception;

}
