package com.yundao.tenant.mapper.roadshow;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;

/**
 * 文章
 *
 * @author jan
 * @create 2017-10-19 11:35
 **/
public interface RoadshowMapper {
    /**
     * 获取分页
     */
    List<RoadshowResDto> selectPage(RoadshowReqDto reqDto) throws BaseException;
    int selectCount(RoadshowReqDto reqDto) throws BaseException;
}
