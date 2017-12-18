package com.yundao.tenant.service.roadshowcolumn;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnAddReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnResDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnUpdateReqDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;

public interface RoadshowColumnService {

	public Result<Long> add(RoadshowColumnAddReqDto reqDto) throws Exception;

	public Result<Long> update(RoadshowColumnUpdateReqDto reqDto) throws Exception;

	public Result<Integer> delete(String ids) throws Exception;

	public Result<RoadshowColumnResDto> get(Long id) throws Exception;

	public Result<List<BaseRoadshowColumn>> getsByPlatformId(Long platformId) throws Exception;

	public Result<List<BaseRoadshowColumn>> getsByPlatformCode(String platformCode) throws Exception;

	public Result<PaginationSupport<RoadshowColumnResDto>> getPage(RoadshowColumnReqDto roadshowColumnReqDto)
			throws Exception;

}
